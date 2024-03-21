package org.univ.dangol.test_dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class Test_Badge {

    Long id;
    String name;
    String acquistionMethod;
    String acquiredAt;
    String description;
    String imgUrl;


}
