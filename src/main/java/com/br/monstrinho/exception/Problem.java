package com.br.monstrinho.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Problem {
    private Integer status;
    private String type;
    private String title;
    private String message;
    private List<Field> fields;

    @Getter
    @Builder
    public static class Field{

        private String name;
        private String userMessage;
    }
}
