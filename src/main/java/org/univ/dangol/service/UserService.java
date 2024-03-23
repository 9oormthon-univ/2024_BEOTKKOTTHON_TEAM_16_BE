package org.univ.dangol.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.dto.*;
import org.univ.dangol.entity.*;
import org.univ.dangol.exception.UserNotFoundException;
import org.univ.dangol.repository.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GradeRepository gradeRepository;
    private final UserGradeRepository userGradeRepository;
    private final ItemRepository itemRepository;
    private final UserItemRepository userItemRepository;
    @Transactional
    public int getUserItemCount(String nickName){
        return userRepository.findByName(nickName)
                .map(user -> userItemRepository.findAllByUser(user).size())
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + nickName));
    }
    // 회원 가입
    @Transactional
    public Pair<Optional<User>, Optional<Grade>> join(String nickName) {

        Optional<User> findUser = userRepository.findByName(nickName);

        return findUser.map(user -> {
            // 사용자가 존재할 경우
            List<UserGrade> findUserGrade = userGradeRepository.findByUserOrderByGradeIdDesc(findUser.get());
            return Pair.of(Optional.of(user), Optional.of(findUserGrade.getFirst().getGrade()));

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
    public QuestList showQuestList(Long user_id) {

        // user - 사용자 정보
        // userItemSize - 사용자가 가지고 있는 아이템 사이즈

        User user = userRepository.findById(user_id).get();
        List<UserItem> userItemList = userItemRepository.findAllByUser(user);
        int userItemSize = userItemList.size();
        int userQuestLevel;

        // userQuestLevel - 상단에 뜨는 퀘스트리스트 레벨 (1번째 퀘스트, 2번째 퀘스트, 3번째 퀘스트)

        if (userItemSize != 9) {
            userQuestLevel = (userItemList.size() / 3) + 1;
        } else {
            // 모든 아이템을 모았을 경우
            userQuestLevel = 3;
        }

        // 각 퀘스트를 담는 questListDto
        List<Quest> questListDto = new ArrayList<>();


        // 아이템 사이즈가 9를 넘을 경우
        // 7, 8, 9가 완료되었음을
        if (userItemSize > 9) {
            for (int itemId = 7; itemId <= 9; itemId++) {
                Item item = itemRepository.findById((long) itemId).get();
                Quest questDTO = Quest.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .description(item.getQuestDescription())
                        .isAcquired(true)
                        .imgUrl(item.getImage())
                        .build();
                questListDto.add(questDTO);
            }
        } else {
            // 아이템 리스트가 9 미만일 경우
            // 아이템 파싱을 진행한다 - 1단계 (1~3) 2단계 (4~6) 3단계 (7~9)
            // 아이템 소유 갯수에 따라 더미와 실제 값을 구분해서 넣는다. if) item 2개 소유 -> 진짜 2개, 가짜 1개

            // 해당 레벨에서 사용자가 몇개의 아이템을 가지고 있는지 판단
            int possessItemSize = userItemSize - ((userQuestLevel - 1) * 3);  // 퀘스트 리스트에 넣어야 할 아이템 갯수
            // 실제 들어 있는 아이템 값을 리스트에 넣는다.
            // 1, 2, 3 회 반복
            for (int i = 0; i < possessItemSize; i++) {
                // 반복 시작 위치 파악
                Item input = itemRepository.findById((((userQuestLevel - 1) * 3L) + 1 + i)).get();
                Quest questDTO = Quest.builder()
                        .id(input.getId())
                        .name(input.getName())
                        .description(input.getQuestDescription())
                        .isAcquired(true)
                        .imgUrl(input.getImage())
                        .build();
                questListDto.add(questDTO);
            }
            for (int j = 0; j < 3 - possessItemSize; j++) {         // 3 - 실제 보유 아이템 = 더미 데이터
                Item inputDummyItem = itemRepository.findById((long) (userItemSize + j + 1)).get();
                Quest questDTO = Quest.builder()
                        .id(inputDummyItem.getId())
                        .name(inputDummyItem.getName())
                        .description(inputDummyItem.getQuestDescription())
                        .isAcquired(false)
                        .imgUrl(inputDummyItem.getUnactivatedImage())
                        .build();
                questListDto.add(questDTO);
            }
        }

        return QuestList.builder()
                .quests(questListDto)
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
        List<UserItem> userItemList = userItemRepository.findAllByUser(user);

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
            Item item = itemRepository.findById((long) (userItemList.size() + i + 1)).get();

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

        List<UserGrade> userGradeList = userGradeRepository.findAllByUser(user);
        List<Reward> rewardList = new ArrayList<>();


        // 첫번째 grade에는 별도 보상이 없음. 제거할 것
        userGradeList.removeFirst();

        // 하단 더미 트로피 제작용
        int userGradeListSize = userGradeList.size();

        for (UserGrade userGrade : userGradeList) {
            Grade grade = userGrade.getGrade();
            log.warn("Grade num" + grade.getId());

            // 사용되었는지 여부 확인 - 사용되었다면 리본을 묶을 것
            String trophyImage;
            if (userGrade.isUsed) {
                // 리본 묶인 트로피 이미지
                trophyImage = grade.getTrophyRibbonImage();
            } else {
                // 트로피 이미지
                trophyImage = grade.getTrophyImage();
            }

                rewardList.add(Reward.builder()
                        .id(grade.getId())  // 2, 3, 4로 진행되는 id index (1은 더미데이터)
                        .isAcquired(true)
                        .isUsed(userGrade.isUsed)
                        .imgUrl(trophyImage)
                        .build());

        }

        // 이미지를 가져오기 위한 임의의 grade 객체
        Grade grade = gradeRepository.findById(2L).get();
        for (int i = userGradeListSize + 1; i < 5 - userGradeList.size(); i++) { // 인덱스가 2부터 시작함
            rewardList.add(Reward.builder()
                    .id((long) i + 1)
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
        UserGrade userTopGrade = userGradeRepository.findByUserOrderByGradeIdDesc(user).getFirst();
        Grade topGrade = userTopGrade.getGrade();
        Grade nextGrade = null;

        // Error -> 이후 코드 조정할 것 // 너무 brute
        if (userGradeRepository.findAllByUser(user).size() < 4){
            log.warn("사용자 등급 소유 갯수" + userGradeList.size());
            nextGrade = gradeRepository.findById(topGrade.getId() + 1).get();
        }else{
            nextGrade = Grade.builder()
                    .name("empty")
                    .build();
        }
        Optional<String> nextGradeText = Optional.of(nextGrade.getName());

        String inputDescription;
        if(userGradeList.size() == 4){
            inputDescription = "축하합니다\n당신이 이 구역의 최고에요!";
        }else{
            inputDescription = "조금만 더 시장을 탐험하면, " + nextGradeText.orElse("마스터 등급") + " 이(가) 될 수 있어요!";
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

    public Grade getTopGrade(Long userId){
        User user = userRepository.findById(userId).get();
        return userGradeRepository.findByUserOrderByGradeIdDesc(user).get(0).getGrade();
    }
    public List<String> getGradeImageList(User user){
        //유저 등급 기준 앞 뒤 레벨을 가져오는 메서드
        //유저가 가진 등급 중 가장 높은 등급을 가져온다.
        UserGrade userGrade = userGradeRepository.findByUserOrderByGradeIdDesc(user).getFirst();
        Grade grade = userGrade.getGrade();
        List<String> returnProfileImageList = new ArrayList<>();


        // 각 Grade에 대한 음영처리 이미지도 삽입해야 한다.
        // 시간이 될 경우, 확장성 있게 다시 설계할 것
        if(grade.getId() == 1){ //1레벨 일 경우
            returnProfileImageList.add(null);
            returnProfileImageList.add(gradeRepository.findById(1L).get().getCharacterImage());
            returnProfileImageList.add(gradeRepository.findById(2L).get().getCharacterEmptyImage());
        }else if(grade.getId() == 4){   //마지막 레벨일 경우
            returnProfileImageList.add(gradeRepository.findById(3L).get().getCharacterImage());
            returnProfileImageList.add(gradeRepository.findById(4L).get().getCharacterEmptyImage());
            returnProfileImageList.add(null);

        }else{
            returnProfileImageList.add(gradeRepository.findById(grade.getId() - 1).get().getCharacterImage());
            returnProfileImageList.add(gradeRepository.findById(grade.getId()).get().getCharacterImage());
            returnProfileImageList.add(gradeRepository.findById(grade.getId() + 1).get().getCharacterEmptyImage());
        }
        return returnProfileImageList;
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
}


