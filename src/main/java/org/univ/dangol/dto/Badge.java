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
    private Long id;
    private String name;
    private ItemStatus acquisitionMethod;
    private LocalDateTime acquiredAt;
    private String description;
    private String imgUrl;
}
