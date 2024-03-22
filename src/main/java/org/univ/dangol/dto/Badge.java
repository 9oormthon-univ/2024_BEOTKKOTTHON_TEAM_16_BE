package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.univ.dangol.entity.ItemStatus;

import java.time.LocalDateTime;

@SuperBuilder
@Getter
@Setter
public class Badge {
    //Badge에 획득 여부를 보내야 할까
    //
    private Long id;
    private String name;
    private ItemStatus acquisitionMethod;
    private LocalDateTime acquiredAt;
    private String description;
    private String imgUrl;
}
