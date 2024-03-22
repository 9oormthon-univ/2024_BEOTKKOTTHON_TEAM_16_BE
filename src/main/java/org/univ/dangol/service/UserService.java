package org.univ.dangol.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.dto.Badge;
import org.univ.dangol.dto.BookRow;
import org.univ.dangol.dto.ProfileScreen;
import org.univ.dangol.dto.Reward;
import org.univ.dangol.entity.*;
import org.univ.dangol.repository.*;
import org.univ.dangol.test_dto.TEST_QuestDTO;
import org.univ.dangol.test_dto.TEST_QuestScreenDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GradeRepository gradeRepository;
    private final UserGradeRepository userGradeRepository;
    private final ItemRepository itemRepository;
    private final UserItemRepository userItemRepository;

    // 회원 가입
    @Transactional
    public Pair<Optional<User>, Optional<Grade>> join(String nickName) {

        Optional<User> findUser = userRepository.findByName(nickName);

        return findUser.map(user -> {
            // 사용자가 존재할 경우
            Optional<UserGrade> findUserGrade = userGradeRepository.findByUserOrderByGradeIdDesc(findUser.get());
            return Pair.of(Optional.of(user), Optional.of(findUserGrade.get().getGrade()));

        }).orElseGet(() -> {
            // 사용자가 존재하지 않을 경우, 새 사용자와 1번 캐릭터와 1번 아이템을 제공한다.
            Grade firstGrade = gradeRepository.findById(1L)
                    .orElseThrow(() -> new EntityNotFoundException("Error : Grade 발견 실패"));

            User newUser = User.builder()
                    .name(nickName)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            User registerUser = userRepository.save(newUser);

            UserGrade userGrade = UserGrade.builder()
                    .user(newUser)
                    .grade(firstGrade)
                    .build();

            userGradeRepository.save(userGrade);

            Optional<Item> firstItem = itemRepository.findById(1L);

            UserItem userItem = UserItem.builder()
                    .item(firstItem.get())
                    .user(newUser)
                    .acquireAt(LocalDateTime.now())
                    .build();

            userItemRepository.save(userItem);

            return Pair.of(Optional.of(registerUser), Optional.of(firstGrade));
        });
    }

    /**
     * showQuestList
     * 퀘스트 리스트 팝업을 위한 서비스
     * 사용자가 현재 풀이해야 할 퀘스트 팝업을 위한 서비스이다.
     */
    @Transactional
    public TEST_QuestScreenDTO showQuestList(Long user_id) {
        // 퀘스트 리스트라고 하였지만, 사실 아이템 리스트와 같다. 가지고 있냐, 가지고 있지 않냐의 차이.
        // 시퀀스와 퀘스트 객체를 만들어야 한다.

        // 몇번째 퀘스트인지 확인
        User user = userRepository.findById(user_id).get();
        List<UserItem> userItemList = userItemRepository.findByUser(user);
        int userItemSize = userItemList.size();
        int userQuestLevel;

        if (userItemSize != 9) {
            userQuestLevel = (userItemList.size() / 3) + 1;
        } else {
            // 모든 아이템을 모았을 경우
            userQuestLevel = 3;
        }

        //TestDTO 추후 변경해야 함
        List<TEST_QuestDTO> testDTOs = new ArrayList<TEST_QuestDTO>();

        // 보여줘야 할 아이템 리스트
        // 마지막 단계일 경우 별도 처리가 필요하다
        if (userItemSize == 9) {
            for (int itemId = 7; itemId <= 9; itemId++) {
                Item inputDummyItem = itemRepository.findById((long) itemId).get();
                TEST_QuestDTO questDTO = TEST_QuestDTO.builder()
                        .id(inputDummyItem.getId())
                        .name(inputDummyItem.getName())
                        .description(inputDummyItem.getQuestDescription())
                        .isAcquired(true)
                        .imgUrl(inputDummyItem.getImage())
                        .build();
                testDTOs.add(questDTO);
            }
        } else {
            int levelItemSize = userItemSize - ((userQuestLevel - 1) * 3);  // 퀘스트 리스트에 넣어야 할 아이템 갯수
            for (int i = 0; i < levelItemSize; i++) {
                UserItem inputUserItem = userItemList.get(((userQuestLevel - 1) * 3) + i);
                Item inputItem = itemRepository.findById(inputUserItem.getId()).get();
                TEST_QuestDTO questDTO = TEST_QuestDTO.builder()
                        .id(inputItem.getId())
                        .name(inputItem.getName())
                        .description(inputItem.getQuestDescription())
                        .isAcquired(true)
                        .imgUrl(inputItem.getImage())
                        .build();
                testDTOs.add(questDTO);
            }
            for (int j = 0; j < 3 - levelItemSize; j++) {         // 3 - 실제 보유 아이템 = 더미 데이터
                Item inputDummyItem = itemRepository.findById((long) (userItemSize + j + 1)).get();
                TEST_QuestDTO questDTO = TEST_QuestDTO.builder()
                        .id(inputDummyItem.getId())
                        .name(inputDummyItem.getName())
                        .description(inputDummyItem.getQuestDescription())
                        .isAcquired(false)
                        .imgUrl(inputDummyItem.getUnactivatedImage())
                        .build();
                testDTOs.add(questDTO);
            }
        }

        return TEST_QuestScreenDTO.builder()
                .quests(testDTOs)
                .sequence(userQuestLevel)
                .build();
    }

    /**
     * showProfile
     * 프로필 페이지를 위한 서비스
     * 사용자의 아이템을 모두 보여주는 서비스이다.
     */
    @Transactional
    public ProfileScreen showProfile(Long user_id) {
        User user = userRepository.findById(user_id).get();
        List<UserItem> userItemList = userItemRepository.findByUser(user);

        // 상단 캐릭터 표시를 위한 기능
        List<String> userProfileImageList = getGradeImageList(user);
        List<Badge> userBadgeList = new ArrayList<Badge>();
        // 뱃지 표시를 위한 기능

        // 클라이언트에 Badge를 모두 담아서 제공한다.
        // 얻지 못한 Badge의 경우에는 나머지를 acquiredAt을 null로 설정하면 되겠다.
        for (UserItem userItem : userItemList) {
            // 가지고 있는 아이템
            userBadgeList.add(Badge.builder()
                    .id(userItem.getItem().getId())
                    .name(userItem.getItem().getName())
                    .acquisitionMethod(userItem.getItem().getType())
                    .acquiredAt(userItem.getAcquireAt())
                    .description(userItem.getItem().getPopupDescription())
                    .imgUrl(userItem.getItem().getImage())
                    .build());
        }
        for (int i = 0; i < 9 - userItemList.size(); i++) {
            // 더미 데이터 생성
            Item item = itemRepository.findById((long) (userItemList.size() + i)).get();

            userBadgeList.add(Badge.builder()
                    .id(item.getId())
                    .name(item.getName())
                    .description(item.getPopupDescription())
                    .acquisitionMethod(item.getType())
                    .imgUrl(item.getUnactivatedImage())
                    .build());
        }

        // [각 BookRow에 들어갈 badge 리스트]
        // 좀 야만스럽게 코딩했음. 추후 알고리즘 확장성 있게 설계하도록
        List<Badge> badge1List = new ArrayList<Badge>();
        List<Badge> badge2List = new ArrayList<Badge>();
        List<Badge> badge3List = new ArrayList<Badge>();

        for (int i = 0; i < 3; i++) {
            badge1List.add(userBadgeList.get(i));
        }
        for (int i = 3; i < 6; i++) {
            badge2List.add(userBadgeList.get(i));
        }
        for (int i = 6; i < 9; i++) {
            badge3List.add(userBadgeList.get(i));
        }

        // [각 BookRow에 들어갈 Reward]

        List<UserGrade> userGradeList = userGradeRepository.findByUser(user);
        List<Reward> rewardList = new ArrayList<>();
        // 첫번째 grade에는 별도 보상이 없음. 제거할 것
        userGradeList.removeFirst();

        for (UserGrade userGrade : userGradeList) {
            Grade grade = userGrade.getGrade();

            // 사용되었는지 여부 확인 - 사용되었다면 리본을 묶을 것
            String trophyImage;
            if (grade.isUsed) {
                // 리본 묶인 트로피 이미지
                trophyImage = grade.getTrophyRibbonImage();
            } else {
                // 트로피 이미지
                trophyImage = grade.getTrophyImage();
            }

            rewardList.add(Reward.builder()
                    .id(grade.getId())  // 2, 3, 4로 진행되는 id index (1은 더미데이터)
                    .isAcquired(true)
                    .isUsed(grade.isUsed)
                    .imgUrl(trophyImage)
                    .build());
        }

        // 이미지를 가져오기 위한 임의의 grade 객체
        Grade grade = gradeRepository.findById(2L).get();
        for (int i = 2; i < 5 - userGradeList.size(); i++) { // 인덱스가 2부터 시작함
            rewardList.add(Reward.builder()
                    .id((long) i)
                    .isAcquired(false)
                    .isUsed(false)
                    .imgUrl(grade.getTrophyEmptyImage())
                    .build()
            );
        }

        // [BookRow] 우선 야만스럽게 코딩
        List<BookRow> bookRows = new ArrayList<BookRow>();
        bookRows.add(BookRow.builder()
                .badges(badge1List)
                .reward(rewardList.get(0))
                .build());

        bookRows.add(BookRow.builder()
                .badges(badge2List)
                .reward(rewardList.get(1))
                .build());

        bookRows.add(BookRow.builder()
                .badges(badge3List)
                .reward(rewardList.get(2))
                .build());

        // ProfileScreen 생성
        UserGrade userTopGrade = userGradeRepository.findByUserOrderByGradeIdDesc(user).get();
        Grade topGrade = userTopGrade.getGrade();
        Grade nextGrade = gradeRepository.findById(topGrade.getId() + 1).get();

        String inputDescription;
        if(userGradeList.size() == 4){
            inputDescription = "축하합니다\n당신이 이 구역의 최고에요!";
        }else{
            inputDescription = "조금만 더 시장을 탐험하면," + nextGrade.getName() + "이 될 수 있어요!";
        }

        return ProfileScreen.builder()
                .nickname(user.getName())
                .characterName(topGrade.getName())
                .gradeDescription(inputDescription)
                .previousImage(userProfileImageList.get(0))
                .currentImage(userProfileImageList.get(1))
                .nextImage(userProfileImageList.get(2))
                .bookRows(bookRows)
                .build();

    }




    /**
     * getGradeList
     * 사용자의 이전 등급, 현재 등급, 다음 등급을 List로 저장해서 반환한다.
     * showProfile 에서 상단 캐릭터 반환을 위해 선언되었다
     */

    public List<String> getGradeImageList(User user){
        //유저 등급 기준 앞 뒤 레벨을 가져오는 메서드
        //유저가 가진 등급 중 가장 높은 등급을 가져온다.
        UserGrade userGrade = userGradeRepository.findByUserOrderByGradeIdDesc(user).get();
        Grade grade = userGrade.getGrade();
        List<String> returnProfileImageList = new ArrayList<>();


        // 각 Grade에 대한 음영처리 이미지도 삽입해야 한다.
        // 시간이 될 경우, 확장성 있게 다시 설계할 것
        if(grade.getId() == 1){ //1레벨 일 경우
            returnProfileImageList.add("물음표 사진 입력");
            returnProfileImageList.add(gradeRepository.findById(1L).get().getCharacterImage());
            returnProfileImageList.add(gradeRepository.findById(2L).get().getCharacterImage());
        }else if(grade.getId() == 4){   //마지막 레벨일 경우
            returnProfileImageList.add(gradeRepository.findById(3L).get().getCharacterImage());
            returnProfileImageList.add(gradeRepository.findById(4L).get().getCharacterImage());
            returnProfileImageList.add("물음표 사진 입력");

        }else{
            returnProfileImageList.add(gradeRepository.findById(grade.getId() - 1).get().getCharacterImage());
            returnProfileImageList.add(gradeRepository.findById(grade.getId()).get().getCharacterImage());
            returnProfileImageList.add(gradeRepository.findById(grade.getId() + 1).get().getCharacterImage());
        }
        return returnProfileImageList;
    }


    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
}


