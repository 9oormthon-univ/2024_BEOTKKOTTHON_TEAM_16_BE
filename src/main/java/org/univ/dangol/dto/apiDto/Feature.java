package org.univ.dangol.dto.apiDto;

import lombok.Data;

@Data
public class Feature {
    private String type;
    private Geometry geometry;
    private Properties properties;
    private String id;
}
