package org.univ.dangol.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.univ.dangol.entity.Grade;

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
    private Grade grade;
}