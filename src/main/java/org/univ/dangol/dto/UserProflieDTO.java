package org.univ.dangol.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.univ.dangol.entity.ItemStatus;

import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder
@Getter
@Setter
public class UserProflieDTO {
    //사용자 이름
    private String nickname;
    //등급 설명
    private String gradeDescription;
    //캐릭터 이름
    private String characterName;
    //이전 단계 캐릭터 사진
    private String currentImage;
    //현재 단계 캐릭터 사진
    private String nextImage;
    //다음 단계 캐릭터 사진 (물음표일 가능성 높음)
    private String previousImage;

    private List<Badge> badges;

    private List<Trophy> rewards;

}


