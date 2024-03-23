package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.entity.*;
import org.univ.dangol.repository.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자 모험에 대한 서비스이다.
 */

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdventureService {

    private final UserRepository userRepository;
    private final UserGradeRepository userGradeRepository;
    private final GradeRepository gradeRepository;
    private final UserItemRepository userItemRepository;
    private final ItemRepository itemRepository;

    public List<PopupType> itemSeq = Arrays.asList(
            PopupType.APP, PopupType.Location, PopupType.APP,
            PopupType.Quiz, PopupType.Location, PopupType.Quiz,
            PopupType.Quiz, PopupType.Location, PopupType.Location
    );

    /**
     * touchTrigger
     * 사용자가 특정 물체와 접촉했을 경우, 다음 이벤트를 사용자에게 반환하는 서비스입니다.
     */
    @Transactional
    public Item touchTrigger(Long id){
        // (ValidationCheck) index가 9가 넘을 경우 OutofBoundsException 발생
        // 사용자가 특정 물체와 접촉했을 경우 다음 이벤트가 발생한다.

        User user = userRepository.findById(id).get();
        int userItemSize = userItemRepository.findAllByUser(user).size();


        // 우선, 다음에 발생시킬 이벤트는 사용자가 가진 아이템의 갯수로 판단한다.
        // zero-based, one-based 와 햇갈릴 가능성 체크할 것
        List<UserItem> userItemList = userItemRepository.findAllByUser(user);

        int userGetItemSize = userItemList.size();                                  // 반환을 위해 별도 저장
        PopupType itemTrigger = itemSeq.get(userGetItemSize);                      // 모두 모았을 때 예외처리 필요
        Item item = itemRepository.findById((long) (userGetItemSize + 1)).get();    // 사용자가 다음에 받아야 할 아이템

        // 아이템을 모두 수집했을 경우
        if(userGetItemSize == 9) {
            return Item.builder()
                    .Id(99L)
                    .name("모든 아이템을 수집하였습니다")
                    .build();
        }

        return switch (itemTrigger) {
            case Location ->
                // location 기반 서비스 실행
                    locationEvent(user, item);
            case Quiz ->
                // quiz 기반 서비스 실행
                    quizEvent(item);
            case APP ->
                // app 기반 서비스 실행
                    locationEvent(user, item);
            default -> item;
        };
    }

    /**
     * locationEvent
     * 위치기반 이벤트 : 사용자가 특정 물체와 접촉했을 경우, 해당 순번에 맞는 아이템을 반환한다.
     * @return 다음 아이템에 대한 값
     */
    @Transactional
    public Item locationEvent(User user, Item item){
        // locationEvent일 경우, 클라이언트에게 item을 반환하고, (저장) 까지 진행한다.
        UserItem newUserItem = UserItem.builder()
                .user(user)
                .item(item)
                .acquireAt(LocalDateTime.now())
                .build();
        userItemRepository.save(newUserItem);
        levelUpValidation(user);
        return item;
    }

    /**
     * locationEvent
     * 퀴즈기반 이벤트 : 사용자가 특정 물체와 접촉했을 경우, 해당 순번에 맞는 퀴즈 내용을 반환한다.
     * (주의) 클라이언트 측에서 발생한 이벤트가 퀴즈임을 알려야 한다. - ItemStatus가 Quiz이면 Quiz에 대한 추가 프로세스 필요
     * (주의) 사용자 풀이에 대한 검증 절차가 필요하다 - 추가 API가 필요하다.
     * @return 다음 아이템에 대한 값
     */
    @Transactional
    public Item quizEvent(Item item){
        // quizEvent일 경우, 클라이언트에게 item을 반환하는 과정까지는 수행하지만, (저장)은 검증 이후 수행한다.
        return item;
    }

    /**
     * quizValidation
     * 사용자가 풀이한 퀴즈에 대한 검증은 클라이언트에서 수행한다.
     * true가 올 경우, 해당 아이템을 userItem과 Item에 넣는 과정을 수행한다.
     *
     * @Param userResult - <참이 들어올 경우에만 해당 메서드가 호출된다>
     * @Param userId - 사용자 아이디로 parameter가 넘어온다.
     *
     * (정답 시) isCorrect = true
     * (오답 시) isCorrect = false
     *
     */
    @Transactional
    public boolean quizValidation(String userResult, Long userId){
        // 이건 그냥 아이템을 공짜로 얻는 수준이다.
        // 평가할 필요가 있다. 실제로 quiz가 필요한 영역인지
        // 사용자
        User user = userRepository.findById(userId).get();

        // 다음 아이템
        List<UserItem> userItemList = userItemRepository.findAllByUser(user);
        Item item = itemRepository.findById((long) (userItemList.size() + 1)).get();

        if(item.getType() == PopupType.Quiz && item.getQuizPositive().equals(userResult)) {
            UserItem userItem = UserItem.builder()
                    .user(user)
                    .item(item)
                    .acquireAt(LocalDateTime.now())
                    .build();
            userItemRepository.save(userItem);
            levelUpValidation(user);
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * checkLevelUp
     * 클라이언트 측에서 레벨업 판단 후 API 호출 시
     * 해당 내용 검증 및 검증 내용 반환
     */

    public boolean checkLevelUp(Long userId){
        User user = userRepository.findById(userId).get();
        int userItemSize = userItemRepository.findAllByUser(user).size();
        int userGradeSize = userGradeRepository.findAllByUser(user).size();

        if(userItemSize % 3 != 0) // 레벨이 맞지 않을 경우
            return false;
        else if(userGradeSize - 1 != (userItemSize / 3))  // 해당 Grade가 없을 경우
            return false;
        else
            return true;
    }

    @Transactional
    public void levelUpValidation(User user){
        List<UserItem> userItems = userItemRepository.findAllByUser(user);
        int userItemSize = userItems.size();

        if(userItemSize % 3 == 0){
            // 뱃지가 3개 6개 9개 일 경우
            List<UserGrade> userGradeList = userGradeRepository.findAllByUser(user);
            Grade grade = gradeRepository.findById(Long.valueOf(userGradeList.size() + 1)).get();

            UserGrade userGrade = UserGrade.builder()
                    .user(user)
                    .grade(grade)
                    .build();
            userGradeRepository.save(userGrade);
        }
    }
}
