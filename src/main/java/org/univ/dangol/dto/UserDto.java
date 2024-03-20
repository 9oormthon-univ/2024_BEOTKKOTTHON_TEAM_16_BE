package org.univ.dangol.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserDto {
    private Long id;
    private String nickName;
    private int age;
}