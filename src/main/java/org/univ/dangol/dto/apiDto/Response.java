package org.univ.dangol.dto.apiDto;

import lombok.Data;

@Data
public class Response {
    private Service service;
    private String status;
    private Record record;
    private Page page;
    private Result result;
}
