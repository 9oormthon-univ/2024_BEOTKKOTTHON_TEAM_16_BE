package org.univ.dangol.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.MarketScreen;
import org.univ.dangol.dto.RecommendMarket;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TempMarketScreenController {
    @GetMapping("users/{userId}/markets/recommend")
    public ResponseEntity<MarketScreen> recommendMarkets(){
        // TO DO CHANGE REGION
        List<RecommendMarket> markets = new ArrayList<>();
        RecommendMarket recommendMarket1 = RecommendMarket.builder()
                .id(1)
                .description("'다 있는 의정부 제일 시장'을 추천드립니다.\n함께 의정부 제일 시장을 탐색하시겠습니까?")
                .imgUrl("http://uihope.or.kr/cmm/fms/getImage.do?atchFileId=FILE_000000000000274")
                .latitude(37.739754477807224)
                .longitude(127.05039598248882)
                .build();
        RecommendMarket recommendMarket2 = RecommendMarket.builder()
                .id(2)
                .description("'맛집으로 넘치는 마천 시장'을 추천드립니다.\\n함께 마천 시장을 탐색하시겠습니까?")
                .imgUrl("http://modo.phinf.naver.net/20160324_75/1458803635350ff1q6_JPEG/mosaSEAY4j.jpeg?type=f530_353")
                .latitude(37.49815517860691)
                .longitude(127.1504139325548)
                .build();
        RecommendMarket recommendMarket3 = RecommendMarket.builder()
                .id(3)
                .description("'싱싱한 수산물 가득 가락 시장'을 추천드립니다.\\n함께 가락 시장을 탐색하시겠습니까?")
                .imgUrl("https://minio.nculture.org/amsweb-opt/multimedia_assets/116/28893/8809/c/28893-full-size.jpg")
                .latitude(37.49815517860691)
                .longitude(127.1109403328604)
                .build();
        markets.add(recommendMarket1); markets.add(recommendMarket2); markets.add(recommendMarket3);
        MarketScreen dto = MarketScreen.builder()
                .markets(markets)
                .build();
        // END REGION

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok()
                .headers(headers)
                .body(dto);
    }
}
