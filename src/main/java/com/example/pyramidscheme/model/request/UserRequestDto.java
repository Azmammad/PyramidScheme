package com.example.pyramidscheme.model.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private Double investment;
    private Long sponsorId;
}
