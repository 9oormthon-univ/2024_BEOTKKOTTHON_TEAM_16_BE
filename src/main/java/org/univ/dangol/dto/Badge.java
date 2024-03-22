package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.univ.dangol.entity.PopupType;

import java.time.LocalDateTime;

/**
 * BadgeDto
 *
 * Badge 정보를 광범위하게 담는다.
 */

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class Badge {

    private Long id;
    private String name;
    private PopupType acquisitionMethod;
    private LocalDateTime acquiredAt;
    private String description;
    private String imgUrl;
}
