package org.univ.dangol;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.entity.*;
import org.univ.dangol.repository.GradeRepository;
import org.univ.dangol.repository.ItemRepository;
import org.univ.dangol.repository.MarketRepository;
import org.univ.dangol.repository.ShopRepository;

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
        // dbSeedingService.dbShopInit();
        dbSeedingService.db9oormthonShopInit();
    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class DatabaseSeedingService{

        private final GradeRepository gradeRepository;
        private final ItemRepository itemRepository;
        private final MarketRepository marketRepository;
        private final ShopRepository shopRepository;

        public void db9oormthonShopInit(){
            if (shopRepository.findById(1L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(1L)
                        .name("라이언네 분식집")
                        .address("카카오시 구름구 AI동 34번지")
                        .latitude(BigDecimal.valueOf(37.352125003015296))
                        .longitude(BigDecimal.valueOf(127.07120522898217))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("분식")
                        .tag("떡볶이-어묵")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(2L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(2L)
                        .name("프로도네 반찬가게")
                        .address("카카오시 구름구 AI동 2번지")
                        .latitude(BigDecimal.valueOf(37.35218567779572))
                        .longitude(BigDecimal.valueOf(127.07144512970152))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("반찬가게")
                        .tag("김치-장아찌")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(3L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(3L)
                        .name("튜브네 정육점")
                        .address("카카오시 구름구 AI동 3번지")
                        .latitude(BigDecimal.valueOf(37.35207739394533))
                        .longitude(BigDecimal.valueOf(127.07171026529826))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("정육점")
                        .tag("돼지고기-소고기")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(4L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(4L)
                        .name("콘과 무지의 이불가게")
                        .address("카카오시 구름구 AI동 4번지")
                        .latitude(BigDecimal.valueOf(37.351897309612355))
                        .longitude(BigDecimal.valueOf(127.07150975497879))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("이불가게")
                        .tag("베개-이불")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(5L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(5L)
                        .name("네오네 야채가게")
                        .address("카카오시 구름구 AI동 77번지")
                        .latitude(BigDecimal.valueOf(37.35178469474807))
                        .longitude(BigDecimal.valueOf(127.07148707478284))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("야채가게")
                        .tag("배추-토마토")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(6L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(6L)
                        .name("제이-지의 만물상점")
                        .address("카카오시 구름구 AI동 123번지")
                        .latitude(BigDecimal.valueOf(37.351604487426094))
                        .longitude(BigDecimal.valueOf(127.07148972557167))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("만물상점")
                        .tag("호랑이-AK47")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(7L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(7L)
                        .name("춘식이네 방앗간")
                        .address("카카오시 구름구 AI동 44번지")
                        .latitude(BigDecimal.valueOf(37.35179382592479))
                        .longitude(BigDecimal.valueOf(127.07128674469152))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("방앗간")
                        .tag("가래떡-무지개떡")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(8L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(8L)
                        .name("구르미네 하늘포차")
                        .address("카카오시 구름구 AI동 321번지")
                        .latitude(BigDecimal.valueOf(37.35123487791715))
                        .longitude(BigDecimal.valueOf(127.0717997567674))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("포차")
                        .tag("전-동동주")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(9L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(9L)
                        .name("팬다 주니어의 국밥집")
                        .address("카카오시 구름구 AI동 34번지")
                        .latitude(BigDecimal.valueOf(37.35126391229903))
                        .longitude(BigDecimal.valueOf(127.07220892405834))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("국밥집")
                        .tag("돼지국밥-소국밥")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(10L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(10L)
                        .name("스카피의 이상한 족발집")
                        .address("카카오시 구름구 AI동 25번지")
                        .latitude(BigDecimal.valueOf(37.35126391229903))
                        .longitude(BigDecimal.valueOf(127.07220892405834))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("국밥집")
                        .tag("돼지국밥-소국밥")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(11L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(11L)
                        .name("팬다 주니어의 국밥집")
                        .address("카카오시 구름구 AI동 176번지")
                        .latitude(BigDecimal.valueOf(37.35158125346711))
                        .longitude(BigDecimal.valueOf(127.07265222934058))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("국밥집")
                        .tag("돼지국밥-소국밥")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(12L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(12L)
                        .name("케로와 베로니의 과일집")
                        .address("카카오시 구름구 AI동 726번지")
                        .latitude(BigDecimal.valueOf(37.35187402515536))
                        .longitude(BigDecimal.valueOf(127.07275409179769))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("과일")
                        .tag("사과-배")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(13L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(13L)
                        .name("양몬드의 점집")
                        .address("카카오시 구름구 AI동 763번지")
                        .latitude(BigDecimal.valueOf(37.35229541165852))
                        .longitude(BigDecimal.valueOf(127.07250054623943))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/kakao.jpeg")
                        .category("점집")
                        .tag("운명-명운")
                        .build();
                shopRepository.save(shop);
            }

        }

        public void db9oormthonItemInit(){
            if (itemRepository.findById(1L).isEmpty()) {
                Item item = Item.builder()
                        .Id(1L)
                        .type(PopupType.APP)
                        .name("빛나는 탐험가의 모자")
                        .popupDescription("탐험하장에 오신 것을 축하드려요!")
                        .questDescription("탐험하장!에 오신 여러분을 환영해요!?")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Hat.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/HatShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(2L).isEmpty()) {
                Item item = Item.builder()
                        .Id(2L)
                        .type(PopupType.Location)
                        .name("진실의 손전등")
                        .popupDescription("환영해요! 구름톤 시장!")
                        .profileDescription("시장 탐험을 위해 필요한 손전등. 바라는 진실을 비추어준다는 소문이 있다.")
                        .questDescription("이제는 직접 구름톤 시장을\n탐험해볼 시간이에요!")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Flashlight.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/FlashlightShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(3L).isEmpty()) {
                Item item = Item.builder()
                        .Id(3L)
                        .type(PopupType.APP)
                        .name("단골손님")
                        .popupDescription("단골손님이 되신것을 축하드립니다!\n전통시장과 더 가까워져볼까요?")
                        .profileDescription("단골 손님에게 주어지는 뱃지 더 나은 서비스를 기대할 수 있을 것 같다.")
                        .questDescription("좋아하는 상점을\n단골로 등록해보세요!")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Bag.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/BagShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(4L).isEmpty()) {
                Item item = Item.builder()
                        .Id(4L)
                        .type(PopupType.Quiz)
                        .name("푸르른 녹두")
                        .popupDescription("생쥐를 물리쳤어요!\n녹두를 생쥐의 마수로부터 해방시켰군요!!")
                        .profileDescription("왜 생쥐들은 녹두를 좋아할까..? 시장에는 더 맛있는게 많은데 말이야...")
                        .questDescription("시장을 탐험하다보면,\n푸르른 녹두 배지를 획득할 수 있어요!")
                        .quizTitle("녹두 하나 주면 안 잡아먹지!")
                        .quizWarningImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/EventBadgeRat.png")
                        .quizWarningImageText("생쥐(찍찍!)")
                        .quizConfirmText("녹두 되찾으러 가기")
                        .quizWarningImage("")
                        .quizQuestion("마천 시장은 전문 시장이다.")
                        .quizPositive("O")
                        .quizNegative("X")
                        .latitude(BigDecimal.valueOf(37.3520873939453300))
                        .longitude(BigDecimal.valueOf(127.0717102652982600))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Wheat.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/WheatShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(5L).isEmpty()) {
                Item item = Item.builder()
                        .Id(5L)
                        .type(PopupType.Location)
                        .name("달다구리 꿀")
                        .popupDescription("꿀을 되찾았어요!\n달다구리 꿀 배지는 덤인 것 같군요!")
                        .profileDescription("달다.. 그냥 매우 달다. 가래떡에 찍어먹으면 딱이겠는데!")
                        .questDescription("시장을 탐험하다보면,\n달다구리 꿀 배지를 발견할 수 있어요!")
                        .latitude(BigDecimal.valueOf(37.4978832))
                        .longitude(BigDecimal.valueOf(127.151115))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Honeypot.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/HoneypotShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(6L).isEmpty()) {
                Item item = Item.builder()
                        .Id(6L)
                        .type(PopupType.Quiz)
                        .name("말랑말랑 꿀떡")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Honeyricecake.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/HoneyricecakeShadow.png")
                        .popupDescription("호랑이를 물리쳤어요\n축하드려요! 이제 떡은 우리의 것이에요!")
                        .profileDescription("육식성 호랑이가 노렸던 떡이다... 소화는 시킬 수 있었던 것일까?")
                        .quizWarningImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/EventBadgeTiger.png")
                        .quizWarningImageText("호랑이(어흥!)")
                        .questDescription("시장을 탐험하다보면\n말랑말랑 꿀떡 배지를 획득할 수 있어요")
                        .quizTitle("떡 하나 주면 안 잡아먹지!")
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
                        .type(PopupType.Quiz)
                        .name("복슬복슬 복숭아")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Peach.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/PeachShadow.png")
                        .popupDescription("곰을 물리쳤어요!\n곰으로부터 복슬복슬 복숭아를 지켜냈어요!")
                        .quizWarningImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/EventBadgeBear.png")
                        .quizWarningImageText("곰(크앙!)")
                        .profileDescription("곰에게는 마늘과 쑥을! 나에게는 복슬복슬 복숭아를!")
                        .questDescription("시장을 탐험하다보면\n복슬복슬 복숭아 배지를 발견할 수 있어요!")
                        .quizTitle("과일 하나 주면 안 잡아먹지!")
                        .quizConfirmText("과일 구하러 가기")
                        .quizQuestion("마천 시장은 조선시대 때\n말을 기르던 양마장이\n있는 데서 유래되었다.")
                        .quizPositive("O")
                        .quizNegative("X")
                        .latitude(BigDecimal.valueOf(37.498921855945575))
                        .longitude(BigDecimal.valueOf(127.15048044919968))
                        .build();
                itemRepository.save(item);
            }
            if (itemRepository.findById(8L).isEmpty()) {
                Item item = Item.builder()
                        .Id(8L)
                        .type(PopupType.Location)
                        .name("바삭바삭 녹두전")
                        .popupDescription("비오는 날에는 녹두전이죠!\n바삭바삭 녹두전 배지를 획득하셨어요!")
                        .profileDescription("비오는 날 녹두전! 크으 못참지!")
                        .questDescription("시장을 탐험하다보면\n바삭바삭 녹두전 배지를 획득할 수 있어요!")
                        .latitude(BigDecimal.valueOf(37.4988331))
                        .longitude(BigDecimal.valueOf(127.1513726))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Jeon.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/JeonShadow.png")
                        .build();
                itemRepository.save(item);
            }
            if (itemRepository.findById(9L).isEmpty()) {
                Item item = Item.builder()
                        .Id(9L)
                        .type(PopupType.Location)
                        .name("과일 바구니")
                        .popupDescription("과일 바구니 획득을 축하드립니다!\n신선한 과일 바구니를 획득했어요!")
                        .profileDescription("산지배송 과일 바구니..! 신선함이 느껴진다아!")
                        .questDescription("시장을 탐험하다보면,\n말랑말랑 꿀떡 배지를 발견할 수 있어요")
                        .latitude(BigDecimal.valueOf(37.4993124))
                        .longitude(BigDecimal.valueOf(127.1521428))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Fruitbasket.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/FruitbasketShadow.png")
                        .build();
                itemRepository.save(item);

            }
        }
        public void dbGradeInit(){
            if(gradeRepository.findById(1L).isEmpty()){
                Grade grade = Grade.builder()
                        .id(1L)
                        .tier("Bronze")
                        .name("탐험가")
                        .tierImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/blonzeTierIcon.png")
                        .characterImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/bronzeGrade.png")
                        .characterEmptyImage(null)
                        .trophyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Trophy.png")
                        .trophyEmptyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/TrophyShadow.png")
                        .trophyRibbonImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/usedTrophy.png")
                        .build();
                gradeRepository.save(grade);
            }
            if(gradeRepository.findById(2L).isEmpty()){
                Grade grade = Grade.builder()
                        .id(2L)
                        .tier("Silver")
                        .name("보석 사냥꾼")
                        .tierImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/sliverTierIcon.png")
                        .characterImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/siverGrade.png")
                        .characterEmptyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/sliverGradeShadow-big-removebg-preview.png")
                        .trophyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Trophy.png")
                        .trophyEmptyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/TrophyShadow.png")
                        .trophyRibbonImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/usedTrophy.png")
                        .build();
                gradeRepository.save(grade);
            }
            if(gradeRepository.findById(3L).isEmpty()){
                Grade grade = Grade.builder()
                        .id(3L)
                        .tier("Gold")
                        .name("전설 탐험가")
                        .tierImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/goldTierIcon.png")
                        .characterImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/goldGrade.png")
                        .characterEmptyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/goldGradeShadow-big-removebg-preview.png")
                        .trophyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Trophy.png")
                        .trophyEmptyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/TrophyShadow.png")
                        .trophyRibbonImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/usedTrophy.png")
                        .build();
                gradeRepository.save(grade);
            }
            if(gradeRepository.findById(4L).isEmpty()){
                Grade grade = Grade.builder()
                        .id(4L)
                        .tier("Diamond")
                        .name("수호자")
                        .tierImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/platinumTierIcon.png")
                        .characterImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/platinumGrade.png")
                        .characterEmptyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/platinumGradeShadow-big-removebg-preview.png")
                        .trophyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Trophy.png")
                        .trophyEmptyImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/TrophyShadow.png")
                        .trophyRibbonImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/usedTrophy.png")
                        .build();
                gradeRepository.save(grade);
            }
        }

        public void dbItemInit(){

            if (itemRepository.findById(1L).isEmpty()) {
                Item item = Item.builder()
                        .Id(1L)
                        .type(PopupType.APP)
                        .name("탐험가")
                        .popupDescription("용감한 탐험가가 되신 것을 축하드립니다!")
                        .profileDescription("시장 탐험을 시작했다는 것을 증명하는 탐험가 뱃지이다.")
                        .questDescription("우주 저 너머로. 탐험해볼까요?")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Hat.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/HatShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(2L).isEmpty()) {
                Item item = Item.builder()
                        .Id(2L)
                        .type(PopupType.Location)
                        .name("탐색의 시작")
                        .popupDescription("첫 탐색의 시작울 축하드립니다!")
                        .profileDescription("시장 탐험을 위해 필요한 손전등. 바라는 진실을 비추어준다는 소문이 있다.")
                        .questDescription("이제는 직접 시장을\n탐험해볼 시간이에요!")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Flashlight.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/FlashlightShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(3L).isEmpty()) {
                Item item = Item.builder()
                        .Id(3L)
                        .type(PopupType.APP)
                        .name("단골손님")
                        .popupDescription("단골손님이 되신것을 축하드립니다!\n전통시장과 더 가까워져볼까요?")
                        .profileDescription("단골 손님에게 주어지는 뱃지 더 나은 서비스를 기대할 수 있을 것 같다.")
                        .questDescription("좋아하는 상점을\n단골로 등록해보세요!")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Bag.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/BagShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(4L).isEmpty()) {
                Item item = Item.builder()
                        .Id(4L)
                        .type(PopupType.Quiz)
                        .name("푸르른 녹두")
                        .popupDescription("생쥐를 물리쳤어요!\n녹두를 생쥐의 마수로부터 해방시켰군요!!")
                        .profileDescription("왜 생쥐들은 녹두를 좋아할까..? 시장에는 더 맛있는게 많은데 말이야...")
                        .questDescription("시장을 탐험하다보면,\n푸르른 녹두 배지를 획득할 수 있어요!")
                        .quizTitle("녹두 하나 주면 안 잡아먹지!")
                        .quizWarningImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/EventBadgeRat.png")
                        .quizWarningImageText("생쥐(찍찍!)")
                        .quizConfirmText("녹두 되찾으러 가기")
                        .quizWarningImage("")
                        .quizQuestion("마천 시장은 전문 시장이다.")
                        .quizPositive("O")
                        .quizNegative("X")
                        .latitude(BigDecimal.valueOf(37.497487590252675f))
                        .longitude(BigDecimal.valueOf(127.15083584189415))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Wheat.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/WheatShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(5L).isEmpty()) {
                Item item = Item.builder()
                        .Id(5L)
                        .type(PopupType.Location)
                        .name("달다구리 꿀")
                        .popupDescription("꿀을 되찾았어요!\n달다구리 꿀 배지는 덤인 것 같군요!")
                        .profileDescription("달다.. 그냥 매우 달다. 가래떡에 찍어먹으면 딱이겠는데!")
                        .questDescription("시장을 탐험하다보면,\n달다구리 꿀 배지를 발견할 수 있어요!")
                        .latitude(BigDecimal.valueOf(37.4978832))
                        .longitude(BigDecimal.valueOf(127.151115))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Honeypot.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/HoneypotShadow.png")
                        .build();
                // 위도 경도 추후 추가할 것
                itemRepository.save(item);
            }
            if (itemRepository.findById(6L).isEmpty()) {
                Item item = Item.builder()
                        .Id(6L)
                        .type(PopupType.Quiz)
                        .name("말랑말랑 꿀떡")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Honeyricecake.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/HoneyricecakeShadow.png")
                        .popupDescription("호랑이를 물리쳤어요\n축하드려요! 이제 떡은 우리의 것이에요!")
                        .profileDescription("육식성 호랑이가 노렸던 떡이다... 소화는 시킬 수 있었던 것일까?")
                        .quizWarningImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/EventBadgeTiger.png")
                        .quizWarningImageText("호랑이(어흥!)")
                        .questDescription("시장을 탐험하다보면\n말랑말랑 꿀떡 배지를 획득할 수 있어요")
                        .quizTitle("떡 하나 주면 안 잡아먹지!")
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
                        .type(PopupType.Quiz)
                        .name("복슬복슬 복숭아")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Peach.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/PeachShadow.png")
                        .popupDescription("곰을 물리쳤어요!\n곰으로부터 복슬복슬 복숭아를 지켜냈어요!")
                        .quizWarningImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/EventBadgeBear.png")
                        .quizWarningImageText("곰(크앙!)")
                        .profileDescription("곰에게는 마늘과 쑥을! 나에게는 복슬복슬 복숭아를!")
                        .questDescription("시장을 탐험하다보면\n복슬복슬 복숭아 배지를 발견할 수 있어요!")
                        .quizTitle("과일 하나 주면 안 잡아먹지!")
                        .quizConfirmText("과일 구하러 가기")
                        .quizQuestion("마천 시장은 조선시대 때\n말을 기르던 양마장이\n있는 데서 유래되었다.")
                        .quizPositive("O")
                        .quizNegative("X")
                        .latitude(BigDecimal.valueOf(37.498921855945575))
                        .longitude(BigDecimal.valueOf(127.15048044919968))
                        .build();
                itemRepository.save(item);
            }
            if (itemRepository.findById(8L).isEmpty()) {
                Item item = Item.builder()
                        .Id(8L)
                        .type(PopupType.Location)
                        .name("바삭바삭 녹두전")
                        .popupDescription("비오는 날에는 녹두전이죠!\n바삭바삭 녹두전 배지를 획득하셨어요!")
                        .profileDescription("비오는 날 녹두전! 크으 못참지!")
                        .questDescription("시장을 탐험하다보면\n바삭바삭 녹두전 배지를 획득할 수 있어요!")
                        .latitude(BigDecimal.valueOf(37.4988331))
                        .longitude(BigDecimal.valueOf(127.1513726))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Jeon.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/JeonShadow.png")
                        .build();
                itemRepository.save(item);
            }
            if (itemRepository.findById(9L).isEmpty()) {
                Item item = Item.builder()
                        .Id(9L)
                        .type(PopupType.Location)
                        .name("과일 바구니")
                        .popupDescription("과일 바구니 획득을 축하드립니다!\n신선한 과일 바구니를 획득했어요!")
                        .profileDescription("산지배송 과일 바구니..! 신선함이 느껴진다아!")
                        .questDescription("시장을 탐험하다보면,\n말랑말랑 꿀떡 배지를 발견할 수 있어요")
                        .latitude(BigDecimal.valueOf(37.4993124))
                        .longitude(BigDecimal.valueOf(127.1521428))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Fruitbasket.png")
                        .unactivatedImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/FruitbasketShadow.png")
                        .build();
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
                        .address("경기도 의정부시 시민로121번길 43-2")
                        .build();
                marketRepository.save(market);
            }
            if (marketRepository.findById(2L).isEmpty()) {
                Market market = Market.builder()
                        .id(2L)
                        .name("구름톤 유니브")
                        .description("'밤샘 넘치는 구름톤 유니브를 추천드립니다.\n함께 해뜨는 걸 보시겠습니까?")
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/billy.jpeg")
                        .latitude(BigDecimal.valueOf(37.3518562))
                        .longitude(BigDecimal.valueOf(127.0717912))
                        .address("서울특별시 송파구 마천로45길 23")
                        .build();
                marketRepository.save(market);
            }
            if (marketRepository.findById(3L).isEmpty()) {
                Market market = Market.builder()
                        .id(3L)
                        .name("가락 농수산물 도매시장")
                        .description("'싱싱한 수산물 가득 가락 시장'을 추천드립니다.\n함께 가락 시장을 탐색하시겠습니까?")
                        .image("https://minio.nculture.org/amsweb-opt/multimedia_assets/116/28893/8809/c/28893-full-size.jpg")
                        .latitude(BigDecimal.valueOf(37.49815517860691))
                        .longitude(BigDecimal.valueOf(127.1109403328604))
                        .address("서울특별시 송파구 양재대로 932")
                        .build();
                marketRepository.save(market);
            }


        }

        public void dbShopInit(){
            Market machenMarket = marketRepository.findById(2L).get();
            if (shopRepository.findById(1L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(1L)
                        .name("맛있는반찬")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 26-1")
                        .latitude(BigDecimal.valueOf(37.498014860517756))
                        .longitude(BigDecimal.valueOf(127.15093314233705))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20161121_3%2F1479723448243BaHQk_JPEG%2F177071594748106_0.jpeg")
                        .category("반찬가게")
                        .tag("김치-단호박")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(2L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(2L)
                        .name("춘천 닭발")
                        .market(machenMarket)
                        .address("서울 송파구 성내천로32길 22")
                        .latitude(BigDecimal.valueOf(37.49791542117659))
                        .longitude(BigDecimal.valueOf(127.15119021370128))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20231027_33%2F1698414161584mfp0z_JPEG%2F1000002390.jpg")
                        .category("닭요리점")
                        .tag("닭발-내장탕")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(3L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(3L)
                        .name("삼성상회")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 26")
                        .latitude(BigDecimal.valueOf(37.49789109172456))
                        .longitude(BigDecimal.valueOf(127.15083959700209))
                        .image("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/samsungStore.png")
                        .category("식품점")
                        .tag("고춧가루-참기름")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(4L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(4L)
                        .name("종로 떡집")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 24-8")
                        .latitude(BigDecimal.valueOf(37.49774215163447))
                        .longitude(BigDecimal.valueOf(127.15105416103837))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMzA5MjhfMjA4%2FMDAxNjk1OTEwNjczODEx.U7d9iAIsmzZk43a7BU2q1elBCYzps-PBR5B3QhVdOXkg.JOm4eMOBvVa2vDt6dB9hW7wYmTFjA5j43I0UQA817-Eg.JPEG%2F20230928_182828.jpg")
                        .category("떡집")
                        .tag("돌잔치 떡-생일 기념 떡")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(5L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(5L)
                        .name("충남 떡집")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 24-10")
                        .latitude(BigDecimal.valueOf(37.49769247350385))
                        .longitude(BigDecimal.valueOf(127.15115018410617))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200429_96%2F1588087772918dwyPO_JPEG%2FPuxVdyfwmabFVP_HJB9hCOkY.jpeg.jpg")
                        .category("떡집")
                        .tag("시루떡-답례떡")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(6L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(6L)
                        .name("불타는 포차")
                        .market(machenMarket)
                        .address("서울 송파구 성내천로32길 24")
                        .latitude(BigDecimal.valueOf(37.49778459832357))
                        .longitude(BigDecimal.valueOf(127.15132848051788))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20201024_296%2F16035294803368gt6O_JPEG%2FvgzCDDPqLSqsIcT69cC8C6nr.jpg")
                        .category("곱창집")
                        .tag("순대볶음-곱창볶음")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(7L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(7L)
                        .name("소문난 곱창")
                        .market(machenMarket)
                        .address("서울 송파구 거마로22길 33")
                        .latitude(BigDecimal.valueOf(37.497576029121376))
                        .longitude(BigDecimal.valueOf(127.15061279155681))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20201110_78%2F1604968171604zKn3D_JPEG%2FgjJSQU_YvIRXzrRQ4uXPCYrI.jpeg.jpg")
                        .category("곱창집")
                        .tag("순대볶음-곱창볶음")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(8L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(8L)
                        .name("암사직화쪽갈비")
                        .market(machenMarket)
                        .address("서울 송파구 거마로22길 35 1층")
                        .latitude(BigDecimal.valueOf(37.49752627559298))
                        .longitude(BigDecimal.valueOf(127.15076818459264))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230419_7%2F16818769299877DGIJ_PNG%2F1.png")
                        .category("고깃집")
                        .tag("쪽갈비-갈비살")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(9L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(9L)
                        .name("착한 밥집")
                        .market(machenMarket)
                        .address("서울 송파구 거마로22길 37")
                        .latitude(BigDecimal.valueOf(37.497424789998604))
                        .longitude(BigDecimal.valueOf(127.15086410335246))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDAzMDJfMzAw%2FMDAxNzA5Mzc3MzU5NTA0.Z8D7l80qzgbulmSMCDGT0AYI_24Skx9-CNmhA1h_NVEg.IwOSjUC4z7ymscrnjpOlMQqADsIXdx29ZftvWpcR9XEg.JPEG%2F20240302_183425.jpg.jpg")
                        .category("백반집")
                        .tag("닭도리탕-제육볶음")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(10L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(10L)
                        .name("종로 회집")
                        .market(machenMarket)
                        .address("서울 송파구 거마로 22길 39")
                        .latitude(BigDecimal.valueOf(37.49735027661575))
                        .longitude(BigDecimal.valueOf(127.15100531035682))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDAyMDFfMjMy%2FMDAxNzA2Nzk1OTY0MTQ1.7bowX6KILrY0jt1moiV8hXPl9CAmY5krHsHES2YYKEIg.SOOH4k-4It0QWCc9IiijEm2sgsKJLniqYbODQSiUS40g.JPEG%2F9371018A-ED78-4505-9EB6-7E36E03F5CF7.jpeg")
                        .category("횟집")
                        .tag("내장탕-모둠회")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(11L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(11L)
                        .name("원조 토속 순대국")
                        .market(machenMarket)
                        .address("서울 송파구 거마로22길 40")
                        .latitude(BigDecimal.valueOf(37.49725354157809))
                        .longitude(BigDecimal.valueOf(127.15090899300218))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200202_61%2F1580577215637Rki0u_JPEG%2FmyHP40vXLsyG_t6ndjT5ms9y.jpg")
                        .category("순대국집")
                        .tag("순대국-술국")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(12L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(12L)
                        .name("LOTO")
                        .market(machenMarket)
                        .address("서울 송파구 거마로22길 41-1")
                        .latitude(BigDecimal.valueOf(37.497232856858226))
                        .longitude(BigDecimal.valueOf(127.15123124461337))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20161019_171%2F14768407547447gCXp_JPEG%2F176967583430_4.jpg")
                        .category("카페")
                        .tag("화덕피자-치킨")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(13L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(13L)
                        .name("설렁탕 우정")
                        .market(machenMarket)
                        .address("서울 송파구 마천로41길 33")
                        .latitude(BigDecimal.valueOf(37.49703241254866))
                        .longitude(BigDecimal.valueOf(127.15120822339195))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20211210_188%2F1639131623029DNkkW_JPEG%2F1639131590646.jpg")
                        .category("설렁탕집")
                        .tag("설렁탕-도가니탕")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(14L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(14L)
                        .name("오가커피")
                        .market(machenMarket)
                        .address("서울 송파구 마천로41길 25-1 오가커피")
                        .latitude(BigDecimal.valueOf(37.49697247213188))
                        .longitude(BigDecimal.valueOf(127.15052111144493))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20220226_266%2F1645870878126L3W41_JPEG%2F20220109_163448.jpg")
                        .category("카페")
                        .tag("와플-로터스 과자")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(15L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(15L)
                        .name("Cafe헤븐")
                        .market(machenMarket)
                        .address("서울 송파구 마천로41길 23 2층 cafe헤븐")
                        .latitude(BigDecimal.valueOf(37.49707428835461))
                        .longitude(BigDecimal.valueOf(127.15016509771279))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20221105_52%2F1667575576395HSI6y_JPEG%2FIMG_20221022_184019_175.jpg")
                        .category("카페")
                        .tag("사과스무디-쌍화차")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(16L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(16L)
                        .name("고바우약국")
                        .market(machenMarket)
                        .address("서울 송파구 마천로41길 21")
                        .latitude(BigDecimal.valueOf(37.49711052604031))
                        .longitude(BigDecimal.valueOf(127.15000967817556))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20191117_94%2F1573994133218PryXP_JPEG%2FkoAyZMwwXHPvTlgmkWc1nHiD.jpg")
                        .category("약국")
                        .tag("종합비타민-건강음료")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(17L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(17L)
                        .name("보이걸주니어")
                        .market(machenMarket)
                        .address("서울 송파구 마천로41길 28")
                        .latitude(BigDecimal.valueOf(37.49683058209316))
                        .longitude(BigDecimal.valueOf(127.15050669106513))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20191129_154%2F1574956191706xO8Co_JPEG%2FBjsgh-H5sUF4KQ10Gvud54gM.jpeg.jpg")
                        .category("옷가게")
                        .tag("캐주얼-트랜디")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(18L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(18L)
                        .name("밥이랑찌개랑")
                        .market(machenMarket)
                        .address("서울 송파구 마천로41길 28")
                        .latitude(BigDecimal.valueOf(37.4967582531304))
                        .longitude(BigDecimal.valueOf(127.15070161689593))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20191109_203%2F1573306288605RcP7i_JPEG%2FCwIEvWxHLk9T4Ge3YAzxCXGL.jpeg.jpg")
                        .category("백반집")
                        .tag("내장탕-우거지탕")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(19L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(19L)
                        .name("마당호프")
                        .market(machenMarket)
                        .address("서울 송파구 성내천로 222")
                        .latitude(BigDecimal.valueOf(37.499515763839256))
                        .longitude(BigDecimal.valueOf(127.15212076833261))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDAzMTlfMjA5%2FMDAxNzEwODA1MzIxNjYz.hryk7MUdYRj08N5xvG5sD0NfBvSp86C0olHgFB9Prmog.OS9sViCkEVfCDWyQ8sHT0wcrbN1riK59Nl7YvfJqS-og.JPEG%2F20240307_204201.jpg.jpg")
                        .category("술집")
                        .tag("마당안주-주류")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(20L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(20L)
                        .name("정선유통")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 45")
                        .latitude(BigDecimal.valueOf(37.49943699523425))
                        .longitude(BigDecimal.valueOf(127.15206689142373))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMzA2MDRfMzYg%2FMDAxNjg1ODYwMDk0MTg4.hkAbT7KqhW1i95j5so2iGW0FcyEKalYML0BUzrcFpBcg.u6WSMJq1AZ2XVnNwGnD207bAWaZDSuql8qiqA6Dob1cg.JPEG%2F57EDCB01-A1C3-447D-8E16-53D617B64744.jpeg")
                        .category("횟집")
                        .tag("민어회-해물라면")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(21L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(21L)
                        .name("마천골")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 44")
                        .latitude(BigDecimal.valueOf(37.49934116173424))
                        .longitude(BigDecimal.valueOf(127.15214585905004))
                        .image("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDAxMjNfMjA4%2FMDAxNzA1OTg3Mjg3NTk5.sbw47aVdnxWlgD-Zfu67wa1p2zxQTRZLF0SOi_UtuGkg.sTJJ_nRJF4EZFuS6lD-6mI79nm89JeTUvGpejTVuYrkg.JPEG.cesonagi%2F20240115%25A3%25DF165300.jpg")
                        .category("분식집")
                        .tag("떡볶이-어묵")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(22L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(22L)
                        .name("별찌소곱창")
                        .market(machenMarket)
                        .address("서울 송파구 성내천로 224 1층")
                        .latitude(BigDecimal.valueOf(37.4994727567486))
                        .longitude(BigDecimal.valueOf(127.15228324612526))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20201220_162%2F1608461971853G6fmX_JPEG%2FaYhuLZlcVyzd8pJz-lxxhXdT.jpeg.jpg")
                        .category("곱창집")
                        .tag("소곱창-소주")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(23L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(23L)
                        .name("명량핫도그")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 41 1층")
                        .latitude(BigDecimal.valueOf(37.499252562367474))
                        .longitude(BigDecimal.valueOf(127.15185447668266))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230912_177%2F1694483641035g26zG_JPEG%2F%25B8%25ED%25B6%25FB%25C7%25D6%25B5%25B5%25B1%25D7_%25B7%25CE%25B0%25ED.jpg")
                        .category("프렌차이즈 분식집")
                        .tag("감자핫도그-쌀핫도그")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(24L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(24L)
                        .name("민속빈대떡")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 42")
                        .latitude(BigDecimal.valueOf(37.49920272534332))
                        .longitude(BigDecimal.valueOf(127.15207348437048))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200819_260%2F15978117819513xVzi_JPEG%2F1VOLVGi5BYE2KGWR2VuwOLfQ.jpg")
                        .category("전집")
                        .tag("모듬전-고기완자")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(25L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(25L)
                        .name("미래원축산물직판장")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 40-1")
                        .latitude(BigDecimal.valueOf(37.49920272534332))
                        .longitude(BigDecimal.valueOf(127.15207348437048))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20190923_151%2F15691665011415N8uX_JPEG%2FjgqnBp3lhXZhHbOGW2a8PpOp.jpeg.jpg")
                        .category("정육점")
                        .tag("소고기-돼지고기")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(26L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(26L)
                        .name("연심이네")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 39-1 (마천동) 연심이네")
                        .latitude(BigDecimal.valueOf(37.499170532909424))
                        .longitude(BigDecimal.valueOf(127.15170870942563))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMzA2MDNfMTM1%2FMDAxNjg1Nzc5NzEyNjM3.hNExbXucCZIwumRfYNqODPXRGMaJ5QLIsz78L7Guqagg.AB5YONoGgMuPg3yO5r2rptBl0QS1Ltps0JapdU_sybYg.JPEG%2F1EDE6294-32B5-46DD-A322-867EB0D2074B.jpeg")
                        .category("식품집")
                        .tag("삶은옥수수-누릉지")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(27L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(27L)
                        .name("부산어묵")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 39")
                        .latitude(BigDecimal.valueOf(37.49908166593081))
                        .longitude(BigDecimal.valueOf(127.15162512714103))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDAyMDNfMzkg%2FMDAxNzA2OTUxODIxMTg3.LW1g00odnpMCDRfujk3DLZ99_Ov3DG0ZN0fng_X28nAg.FS70m9wUDx-2At_BwM4PO2zOprq-dj3DwWSffy-aHdUg.JPEG%2F8307F9AF-3C57-4BC7-824B-000B52537191.jpeg")
                        .category("어묵집")
                        .tag("오뎅탕-어묶볶음")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(28L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(28L)
                        .name("원이네순대국")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 38 마천중앙시장 상인회129호")
                        .latitude(BigDecimal.valueOf(37.498861952051456))
                        .longitude(BigDecimal.valueOf(127.15169818995695))
                        .image("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDAxMTJfMjgy%2FMDAxNzA1MDMyOTM4Njc2.VlZul6ekH2nXKXTf1NM7vOF7l8cyrHiIobzoK1vTghkg.e7VzE-YVZhgq87uEpQrl620rryiz7mU1KWbQtyJ5nnkg.JPEG.fresh901207%2FIMG_1882.jpg")
                        .category("순대국집")
                        .tag("순대국-모듬수육")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(29L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(29L)
                        .name("장충동한방족발 노랑앞치마")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 37")
                        .latitude(BigDecimal.valueOf(37.498970246611016))
                        .longitude(BigDecimal.valueOf(127.15156270347312))
                        .image("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzEyMzBfMjE3%2FMDAxNzAzOTE0NTA3OTA0.706fCsEdAyaIQBwO6sM2iuDtNYvGpiWc0DyepmJhL54g.2irknIbmaba5sSmN52oa1ZF6t7p5hVQtweiSh2lXfssg.JPEG.eunjung_yc%2FIMG_8253.JPG")
                        .category("족발집")
                        .tag("한방 족발-양념 족발")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(30L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(30L)
                        .name("권순화보쌈족발")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 35-1")
                        .latitude(BigDecimal.valueOf(37.498869014294485))
                        .longitude(BigDecimal.valueOf(127.15146071983771))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDAzMjBfMjk5%2FMDAxNzEwOTAyNzY5MTky.AESlr3DGEVM9uln2z7hHCZTvudHHnkmHzWMeRoDhlI4g.8MwudwzsEVCJpyZEyBYjjbblCi9HgOaptWdLvQmdlWEg.JPEG%2F20240316_185231.jpg.jpg")
                        .category("보쌈집")
                        .tag("보쌈-족발")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(31L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(31L)
                        .name("빨간모자반찬")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 35 1층")
                        .latitude(BigDecimal.valueOf(37.49881616552294))
                        .longitude(BigDecimal.valueOf(127.15139417405229))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20231005_192%2F1696490944566AFW2P_JPEG%2FKakaoTalk_20231005_150822779_22.jpg")
                        .category("반찬가게")
                        .tag("김치-생선구이")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(32L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(32L)
                        .name("장충동한방족발")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 34")
                        .latitude(BigDecimal.valueOf(37.49868315520597))
                        .longitude(BigDecimal.valueOf(127.15148154835839))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMzExMTNfMjgz%2FMDAxNjk5ODAzMDc5MzE5.jxQ56A72i00g7Q8o1x5V4YocEsLbkdkvLdeUUXCIjecg.TWRJ-gU75z_jAggxbzXfGQnAEfIcSR5zg5CrQpn3xPgg.JPEG%2F20231108_111647.jpg")
                        .category("족발집")
                        .tag("족발-메밀쟁반국수")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(33L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(33L)
                        .name("수빈이네반찬가게")
                        .market(machenMarket)
                        .address("서울 송파구 마천로51가길 28")
                        .latitude(BigDecimal.valueOf(37.4986406871728))
                        .longitude(BigDecimal.valueOf(127.1512241885812))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210607_8%2F1623051686403HIFpT_JPEG%2Fupload_6be69e09bf0d870368927325de6813d4.jpg")
                        .category("김치가게")
                        .tag("파김치-총각김치")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(34L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(34L)
                        .name("화성이불")
                        .market(machenMarket)
                        .address("서울 송파구 마천로51가길 26")
                        .latitude(BigDecimal.valueOf(37.49854703067524))
                        .longitude(BigDecimal.valueOf(127.15136253168934))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20191117_195%2F1573973010729qtcp7_JPEG%2FQlj7sGxKjz7rkDoYmzY4BhFW.jpeg.jpg")
                        .category("이불가게")
                        .tag("이불-배개")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(35L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(35L)
                        .name("진미곱창")
                        .market(machenMarket)
                        .address("서울 송파구 마천로51가길 23")
                        .latitude(BigDecimal.valueOf(37.49847278844964))
                        .longitude(BigDecimal.valueOf(127.15129170232667))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDAzMTRfNjEg%2FMDAxNzEwNDA0ODYzMDA4.ygEz6nacKN7tBIFoe_-4i-99Zi0-dAfPpIzpQdfurNcg._oezkTWCCKFWP5s7RHOjcbfXiuV1mQxIk_CG7aJHjkEg.JPEG%2F20240314_155212.jpg.jpg")
                        .category("곱창집")
                        .tag("소곱창-돼지곱창")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(36L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(36L)
                        .name("옛날산골통닭")
                        .market(machenMarket)
                        .address("서울 송파구 마천로51가길 27 1층 옛날산골통닭")
                        .latitude(BigDecimal.valueOf(37.498568700990695))
                        .longitude(BigDecimal.valueOf(127.15115053662997))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230124_117%2F16745694291672i9uh_JPEG%2F20230113_003045.jpg")
                        .category("옛날통닭집")
                        .tag("옛날통닭-닭강정")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(37L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(37L)
                        .name("일도불백")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 30")
                        .latitude(BigDecimal.valueOf(37.498347886461474))
                        .longitude(BigDecimal.valueOf(127.15120380789303))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210709_52%2F1625810912130bJ1ma_JPEG%2F0MJcTy3hJhnTpZasszoM1gii.JPG.jpg")
                        .category("백반집")
                        .tag("제육볶음-불고기")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(38L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(38L)
                        .name("주병이김")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 31")
                        .latitude(BigDecimal.valueOf(37.498420199977964))
                        .longitude(BigDecimal.valueOf(127.15102160069286))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20170204_156%2F1486135526896JCgOH_JPEG%2F186154405546242_0.jpeg")
                        .category("김가게")
                        .tag("김부각-파래김")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(39L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(39L)
                        .name("굿뜨래밤")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 18")
                        .latitude(BigDecimal.valueOf(37.497507595951056))
                        .longitude(BigDecimal.valueOf(127.1504020318885))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20181221_219%2F1545359054641tWohD_JPEG%2Fm_b9vuMcx1IIEn2eH042MP2Z.jpg")
                        .category("견과류가게")
                        .tag("생율-밤")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(40L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(40L)
                        .name("다래홍두깨손칼국수")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 17")
                        .latitude(BigDecimal.valueOf(37.49755631980098))
                        .longitude(BigDecimal.valueOf(127.15017030364648))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20221122_227%2F1669121970790s5BvG_JPEG%2F20210727_173920.jpg")
                        .category("칼국수집")
                        .tag("홍두께손칼국수-만두국")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(41L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(41L)
                        .name("장원보쌈")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 15")
                        .latitude(BigDecimal.valueOf(37.49738524411886))
                        .longitude(BigDecimal.valueOf(127.15007949261259))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDAyMDFfMTc4%2FMDAxNzA2NzgzMzA0NDUx.1fCA6K5wUa-PmGj7PsCEyUFp1UGhpMRnheaMouuXiWYg.J4yuPJPYfavE9lHEoDsokQUvPh0yPSWI3A2-EhsFEfUg.JPEG%2FA0D47178-5E93-441B-8782-EE1846561797.jpeg")
                        .category("보쌈가게")
                        .tag("보쌈-막국수")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(42L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(42L)
                        .name("쌀마을")
                        .market(machenMarket)
                        .address("서울 송파구 마천로51가길 24")
                        .latitude(BigDecimal.valueOf(37.49845897083777))
                        .longitude(BigDecimal.valueOf(127.15152774396749))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20191111_28%2F1573472865476dmqI5_JPEG%2Fra12tQn6eUcvcRK4OajNEWMU.jpeg.jpg")
                        .category("쌀가게")
                        .tag("쌀-잡곡")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(43L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(43L)
                        .name("슈즈아이")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 14")
                        .latitude(BigDecimal.valueOf(37.49721739271688))
                        .longitude(BigDecimal.valueOf(127.15011025516586))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20211106_24%2F1636167001138JNYCH_JPEG%2Fx0lnNCtgFe627ub1xAYjnCCX.jpg")
                        .category("신발가게")
                        .tag("구두-운동화")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(44L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(44L)
                        .name("마천새마음금고 본점")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 13 새마을금고")
                        .latitude(BigDecimal.valueOf(37.49718507051331))
                        .longitude(BigDecimal.valueOf(127.14984302650608))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_267%2F1441032545139ecwUp_JPEG%2F166253613057894_0.jpg")
                        .category("은행")
                        .tag("적금-예금")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(45L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(45L)
                        .name("오꾸꼬 마천점")
                        .market(machenMarket)
                        .address("서울 송파구 마천로41길 20")
                        .latitude(BigDecimal.valueOf(37.496939806862635))
                        .longitude(BigDecimal.valueOf(127.14963757006157))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20180323_264%2F15218136483907xA6o_JPEG%2FHFPzz51igabGrOzz-6-MdChj.jpg")
                        .category("치킨집")
                        .tag("순살치킨-양념치킨")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(46L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(46L)
                        .name("벧엘 칼국수")
                        .market(machenMarket)
                        .address("서울 송파구 마천로41길 22")
                        .latitude(BigDecimal.valueOf(37.496846195205165))
                        .longitude(BigDecimal.valueOf(127.14974198668374))
                        .image("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMjJfMjcz%2FMDAxNjc3MDMzOTA0ODkx.F2_6YnVmQB4u3T15N6NRmdK8WggJV_NBAY3ZvOnySagg.jEFRjTYR-wg5qOmTvmFIn3erx5u0fjyhfUjQtCFORNkg.JPEG.100-percent%2F20230119%25A3%25DF183459.jpg")
                        .category("칼국수집")
                        .tag("추어탕-칼국수")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(47L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(47L)
                        .name("오리바베큐")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 23")
                        .latitude(BigDecimal.valueOf(37.49809068041351))
                        .longitude(BigDecimal.valueOf(127.1506505783393))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210922_209%2F1632288458570f4A8P_JPEG%2Fupload_5f894d92d03cd96a280c9fdf0b3d614c.jpg")
                        .category("고깃집")
                        .tag("오리바베큐-등갈비")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(48L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(48L)
                        .name("마천루")
                        .market(machenMarket)
                        .address("서울 송파구 거마로22길 30 1층")
                        .latitude(BigDecimal.valueOf(37.49776505022307))
                        .longitude(BigDecimal.valueOf(127.14987669763624))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDAyMDRfMjI2%2FMDAxNzA3MDI1MTkwNjM0.lG6W3LXrX_t9DqOGNBVso6HMlxulZHBJOsYc49SS8fMg.UsvZDQRU7yBzr8SSjcb15Eg1sG6b2nhZuANz0UThgWQg.JPEG%2F250805FE-A4F1-4BA2-80E5-A96244EAA991.jpeg")
                        .category("중국집")
                        .tag("짜장면-탕수육")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(49L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(49L)
                        .name("송천엄마손칼국수")
                        .market(machenMarket)
                        .address("서울 송파구 마천로45길 8 1층")
                        .latitude(BigDecimal.valueOf(37.49670211704138))
                        .longitude(BigDecimal.valueOf(127.1496766753882))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20220822_251%2F1661154699061z2q6C_JPEG%2FKakaoTalk_20220822_163506194.jpg")
                        .category("칼국수집")
                        .tag("칼국수-만두국")
                        .build();
                shopRepository.save(shop);
            }
            if (shopRepository.findById(50L).isEmpty()){
                Shop shop = Shop.builder()
                        .id(50L)
                        .name("시장통 횟집")
                        .market(machenMarket)
                        .address("서울 송파구 거마로22길 32")
                        .latitude(BigDecimal.valueOf(37.49758690108936))
                        .longitude(BigDecimal.valueOf(127.15003466182766))
                        .image("https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMzA1MDZfMjkz%2FMDAxNjgzMzY5MzQyNzU2.KUl5MFgXtOe4NSRHxItOdtDbpNmUl1_1sw1vwNYZCP4g.h17DyANWF27WKIfS7keZl1j46kJu0Ki0VV_SJ4Jl-jEg.JPEG%2F3E719AB9-2DCD-425C-A936-10774D52D5BB.jpeg")
                        .category("횟집")
                        .tag("다슬기-방어회")
                        .build();
                shopRepository.save(shop);
            }
        }
    }
}
