package com.example.pyramidscheme.model.response;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private Double investment;
    private Double earnings;
    private String sponsorName;
}
