package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * BookRowDto
 * Badge의 리스트와 reward 정보를 보관한다.
 * Profile 페이지 구성에 사용된다.
 */

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class BookRow {
    List<Badge> badges;
    Reward reward;

}
