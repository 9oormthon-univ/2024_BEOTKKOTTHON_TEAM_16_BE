package org.univ.dangol.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder
                .baseUrl("https://api.vworld.kr/req/data")
                .build();
    }
}
