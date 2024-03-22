package org.univ.dangol.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.entity.*;
import org.univ.dangol.repository.*;
import org.univ.dangol.test_dto.TEST_ProfileScreen;
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
    public TEST_QuestScreenDTO showQuestList(Long user_id){
        // 퀘스트 리스트라고 하였지만, 사실 아이템 리스트와 같다. 가지고 있냐, 가지고 있지 않냐의 차이.
        // 시퀀스와 퀘스트 객체를 만들어야 한다.

        // 몇번째 퀘스트인지 확인
        User user = userRepository.findById(user_id).get();
        List<UserItem> userItemList = userItemRepository.findByUser(user);
        int userItemSize = userItemList.size();
        int userQuestLevel;

        if (userItemSize != 9){
            userQuestLevel = (userItemList.size() / 3) + 1;
        }
        else{
            // 모든 아이템을 모았을 경우
            userQuestLevel = 3;
        }

        //TestDTO 추후 변경해야 함
        List<TEST_QuestDTO> testDTOs = new ArrayList<TEST_QuestDTO>();

        // 보여줘야 할 아이템 리스트
        // 마지막 단계일 경우 별도 처리가 필요하다
        if(userItemSize == 9){
            for(int itemId = 7; itemId <= 9; itemId++){
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
        }
        else {
            int levelItemSize = userItemSize - ((userQuestLevel - 1) * 3);  // 퀘스트 리스트에 넣어야 할 아이템 갯수
            for(int i = 0; i < levelItemSize; i++){
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
            for(int j = 0; j < 3 - levelItemSize; j++){         // 3 - 실제 보유 아이템 = 더미 데이터
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



    @Transactional
    public void showProfile(Long user_id){
        User user = userRepository.findById(user_id).get();
//        List<UserGrade> = userGradeRepository.findAll(user.getId);
        List<Grade> userGradeList = getGradeList(user);




    }

    public List<Grade> getGradeList(User user){
        //유저 등급 기준 앞 뒤 레벨을 가져오는 메서드
        //유저가 가진 등급 중 가장 높은 등급을 가져온다.
        UserGrade userGrade = userGradeRepository.findByUserOrderByGradeIdDesc(user).get();
        Grade grade = userGrade.getGrade();
        List<Grade> returnGradeList = new ArrayList<Grade>();


        // 각 Grade에 대한 음영처리 이미지도 삽입해야 한다.
        if(grade.getId() == 1){
            returnGradeList.add(Grade.builder()
                    .name("empty")
                    .id(99L)
                    .characterEmptyImage("emptyImage")  //추후 삽입할 것
                    .build());
            returnGradeList.add(gradeRepository.findById(1L).get());
            returnGradeList.add(gradeRepository.findById(2L).get());
        }else if(grade.getId() == 4){
            returnGradeList.add(gradeRepository.findById(3L).get());
            returnGradeList.add(gradeRepository.findById(4L).get());
            returnGradeList.add(Grade.builder()
                    .name("empty")
                    .id(99L)
                    .characterEmptyImage("emptyImage")  //추후 삽입할 것
                    .build());
        }
        return returnGradeList;
    }


    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
}


