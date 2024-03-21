package org.univ.dangol;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.dto.RecommendMarket;
import org.univ.dangol.entity.Grade;
import org.univ.dangol.entity.Item;
import org.univ.dangol.entity.ItemStatus;
import org.univ.dangol.entity.Market;
import org.univ.dangol.repository.GradeRepository;
import org.univ.dangol.repository.ItemRepository;
import org.univ.dangol.repository.MarketRepository;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DatabaseSeeding{

    private final DatabaseSeedingService dbSeedingService;

    @PostConstruct
    public void init(){
        // 개발자에 의해 진행되어야 하는 데이터베이스 시딩, Bean 생성 단계에서 수행
        dbSeedingService.dbGradeInit();
        dbSeedingService.dbItemInit();
        dbSeedingService.dbMarketInit();
    }


    @Component
    @Transactional
    @RequiredArgsConstructor
    static class DatabaseSeedingService{

        private final GradeRepository gradeRepository;
        private final ItemRepository itemRepository;
        private final MarketRepository marketRepository;

        public void dbGradeInit(){
            if(gradeRepository.findById(1L).isEmpty()){
                Grade grade = Grade.builder()
                        .id(1L)
                        .tier("bronze")
                        .name("탐험가")
                        .image("")
                        .isAcquired(true)
                        .build();
                gradeRepository.save(grade);
            }
            if(gradeRepository.findById(2L).isEmpty()){
                Grade grade = Grade.builder()
                        .id(2L)
                        .tier("silver")
                        .name("보석 사냥꾼")
                        .image("")
                        .isAcquired(false)
                        .build();
                gradeRepository.save(grade);
            }
            if(gradeRepository.findById(3L).isEmpty()){
                Grade grade = Grade.builder()
                        .id(3L)
                        .tier("gold")
                        .name("전설 탐험가")
                        .image("")
                        .isAcquired(false)
                        .build();
                gradeRepository.save(grade);
            }
            if(gradeRepository.findById(4L).isEmpty()){
                Grade grade = Grade.builder()
                        .id(4L)
                        .tier("diamond")
                        .name("수호자")
                        .image("")
                        .isAcquired(false)
                        .build();
                gradeRepository.save(grade);
            }
        }

        public void dbItemInit(){

            /**
             *  id - pk
             *  <기본 아이템>
             *  name - 뱃지를 포함한 아이템의 이름
             *  emphasis - 팝업에서 강조하는 문자열
             *  PopupDescription - 이벤트 팝업에서 사용되는 설명문
             *  profileDescription - 프로필 팝업에서 사용되는 설명문
             *  longitude - 경도"
             *  latitude - 위도
             *  image - 아이템 이름
             *
             *  <퀴즈 아이템>
             *
             *  [첫번째 팝업 quizWarning]
             *  quizWarningTitle - 해당 팝업 타이틀
             *  quizWarningConfirmTest - 해당 팝업 버튼 문자열 ex) 녹두 구하러 가기
             *  quizWarningImage - 해당 팝업 이미지 ex) 호랑이(어흥)
             *
             *  [두번째 팝업 quiz]
             *  quizQuestion - 퀴즈 문제
             *  quizPositive - 정답 선지
             *  quizNegative - 오답 선지
             *
             */

            if (itemRepository.findById(1L).isEmpty()) {
                Item item = Item.builder()
                        .Id(1L)
                        .type(ItemStatus.APP)
                        .name("탐험가")
                        .emphasis("용감한 탐험가")
                        .popupDescription("가 되'신 것을 축하드립니다!")
                        .profileDescription("시장 탐험을 시작했다는 것을 증명하는 탐험가 뱃지이다.")
                        .image("이후 추가")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(2L).isEmpty()) {
                Item item = Item.builder()
                        .Id(2L)
                        .type(ItemStatus.Location)
                        .name("탐색의 시작")
                        .emphasis("첫 탐색의 시작")
                        .popupDescription("울 축하드립니다!")
                        .profileDescription("시장 탐험을 위해 필요한 손전등. 바라는 진실을 비추어준다는 소문이 있다.")
                        .image("이후 추가")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(3L).isEmpty()) {
                Item item = Item.builder()
                        .Id(3L)
                        .type(ItemStatus.APP)
                        .name("단골손님")
                        .emphasis("단골손님")
                        .popupDescription("이 되신것을 축하드립니다!\n전통시장과 더 가까워져볼까요?")
                        .profileDescription("단골 손님에게 주어지는 뱃지 더 나은 서비스를 기대할 수 있을 것 같다.")
                        .image("이후 추가")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(4L).isEmpty()) {
                Item item = Item.builder()
                        .Id(4L)
                        .type(ItemStatus.Quiz)
                        .name("푸르른 녹두")
                        .emphasis("생쥐를 물리쳤어요!")
                        .popupDescription("\n녹두를 생쥐의 마수로부터 해방시켰어요!")
                        .profileDescription("왜 생쥐들은 녹두를 좋아할까..? 시장에는 더 맛있는게 많은데 말이야...")
                        .quizWarningTitle("녹두 하나 주면 안 잡아먹지!")
                        .quizConfirmText("녹두 되찾으러 가기")
                        .quizWarningImage("")
                        .quizQuestion("마천 시장은 전문 시장이다.")
                        .quizPositive("O")
                        .quizNegative("X")
                        .latitude(BigDecimal.valueOf(37.497487590252675f))
                        .longitude(BigDecimal.valueOf(127.15083584189415))
                        .image("")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(5L).isEmpty()) {
                Item item = Item.builder()
                        .Id(5L)
                        .type(ItemStatus.Location)
                        .name("달다구리 꿀")
                        .emphasis("배지 발견")
                        .popupDescription("을 축하드립니다!\n달다구리 꿀 배지를 획득하셨어요!")
                        .profileDescription("달다.. 그냥 매우 달다. 가래떡에 찍어먹으면 딱이겠는데!")
                        .latitude(BigDecimal.valueOf(37.4978832))
                        .longitude(BigDecimal.valueOf(127.151115))
                        .image("")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(6L).isEmpty()) {
                Item item = Item.builder()
                        .Id(6L)
                        .type(ItemStatus.Quiz)
                        .name("말랑말랑 꿀떡")
                        .image("")
                        .emphasis("호랑이를 물리쳤어요")
                        .popupDescription("\n 축하드려요! 이제 떡은 우리의 것이에요!")
                        .profileDescription("육식성 호랑이가 노렸던 떡이다... 소화는 시킬 수 있었던 것일까?")
                        .quizWarningTitle("떡 하나 주면 안 잡아먹지!")
                        .quizWarningImage("")
                        .quizConfirmText("떡 구하러 가기")
                        .quizQuestion("생방송 투데이에 나온\n30년 맛집의 이름은?")
                        .quizPositive("소문난 곱창")
                        .quizNegative("맛좋은 곱창")
                        .latitude(BigDecimal.valueOf(37.49802380619021))
                        .longitude(BigDecimal.valueOf(127.15030773074854))
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(7L).isEmpty()) {
                Item item = Item.builder()
                        .Id(7L)
                        .type(ItemStatus.Quiz)
                        .name("복슬복슬 복숭아")
                        .image("")
                        .emphasis("곰을 물리쳤어요!")
                        .popupDescription("\n곰으로부터 복슬복슬 복숭아를 지켜냈어요!")
                        .profileDescription("곰에게는 마늘과 쑥을! 나에게는 복슬복슬 복숭아를!")
                        .quizWarningTitle("과일 하나 주면 안 잡아먹지!")
                        .quizConfirmText("과일 구하러 가기")
                        .quizQuestion("마천 시장은 조선시대 때\n말을 기르던 양마장이\n있는 데서 유래되었다.")
                        .quizPositive("O")
                        .quizNegative("X")
                        .latitude(BigDecimal.valueOf(37.498921855945575))
                        .longitude(BigDecimal.valueOf(127.15048044919968))
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(8L).isEmpty()) {
                Item item = Item.builder()
                        .Id(8L)
                        .type(ItemStatus.Location)
                        .name("바삭바삭 녹두전")
                        .emphasis("배지 발견")
                        .popupDescription("을 축하드립니다!\n바삭바삭 녹두전 배지를 획득하셨어요!")
                        .profileDescription("비오는 날 녹두전! 크으 못참지!")
                        .latitude(BigDecimal.valueOf(37.4988331))
                        .longitude(BigDecimal.valueOf(127.1513726))
                        .image("")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(9L).isEmpty()) {
                Item item = Item.builder()
                        .Id(9L)
                        .type(ItemStatus.Quiz)
                        .name("과일 바구니")
                        .emphasis("과일 바구니")
                        .popupDescription("획득을 축하드립니다!\n신선한 과일 바구니를 획득했어요!")
                        .profileDescription("산지배송 과일 바구니..! 신선함이 느껴진다아!")
                        .latitude(BigDecimal.valueOf(37.4993124))
                        .longitude(BigDecimal.valueOf(127.1521428))
                        .image("")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
        }

        public void dbMarketInit(){

            if (marketRepository.findById(1L).isEmpty()) {
                Market market = Market.builder()
                        .id(1L)
                        .name("의정부 제일 시장")
                        .description("'다 있는 의정부 제일 시장'을 추천드립니다.\n함께 의정부 제일 시장을 탐색하시겠습니까?")
                        .image("http://uihope.or.kr/cmm/fms/getImage.do?atchFileId=FILE_000000000000274")
                        .latitude(BigDecimal.valueOf(37.739754477807224))
                        .longitude(BigDecimal.valueOf(127.05039598248882))
                        .region1Depth("경기도")
                        .region2Depth("의정부시")
                        .region3Depth("")
                        .roadName("시민로121번길 43-2")
                        .build();
                marketRepository.save(market);
            }
            if (marketRepository.findById(2L).isEmpty()) {
                Market market = Market.builder()
                        .id(2L)
                        .name("마천 시장")
                        .description("'맛집으로 넘치는 마천 시장'을 추천드립니다.\\n함께 마천 시장을 탐색하시겠습니까?")
                        .image("http://modo.phinf.naver.net/20160324_75/1458803635350ff1q6_JPEG/mosaSEAY4j.jpeg?type=f530_353")
                        .latitude(BigDecimal.valueOf(37.49815517860691))
                        .longitude(BigDecimal.valueOf(127.1504139325548))
                        .region1Depth("서울특별시")
                        .region2Depth("송파구")
                        .region3Depth("")
                        .roadName("마천로45길 23")
                        .build();
                marketRepository.save(market);
            }
            if (marketRepository.findById(3L).isEmpty()) {
                Market market = Market.builder()
                        .id(2L)
                        .name("가락 농수산물 도매시장")
                        .description("'싱싱한 수산물 가득 가락 시장'을 추천드립니다.\\n함께 가락 시장을 탐색하시겠습니까?")
                        .image("https://minio.nculture.org/amsweb-opt/multimedia_assets/116/28893/8809/c/28893-full-size.jpg")
                        .latitude(BigDecimal.valueOf(37.49815517860691))
                        .longitude(BigDecimal.valueOf(127.1109403328604))
                        .region1Depth("서울특별시")
                        .region2Depth("송파구")
                        .region3Depth("")
                        .roadName("양재대로 932")
                        .build();
                marketRepository.save(market);
            }

        }
    }
}
