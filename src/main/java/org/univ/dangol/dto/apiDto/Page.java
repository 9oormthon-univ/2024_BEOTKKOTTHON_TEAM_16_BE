package org.univ.dangol.dto.apiDto;

import lombok.Data;

@Data
public class Page {
    private String total;
    private String current;
    private String size;
}
