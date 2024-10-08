package com.example.pyramidscheme.mapper;

import com.example.pyramidscheme.entities.User;
import com.example.pyramidscheme.model.request.UserRequestDto;
import com.example.pyramidscheme.model.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract User toEntity(UserRequestDto userRequestDto);

    @Mapping(source = "sponsor.name", target = "sponsorName")
    public abstract UserResponseDto toResponseDto(User user);
}
