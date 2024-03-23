package org.univ.dangol.dto.apiDto;

import lombok.Data;

import java.util.List;

@Data
public class FeatureCollection {
    private String type;
    private List<Double> bbox;
    private List<Feature> features;
}
