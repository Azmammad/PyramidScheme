package com.example.pyramidscheme.services;

import com.example.pyramidscheme.model.request.UserRequestDto;
import com.example.pyramidscheme.model.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUsers();
    void updateUserEarnings(Long userId, double earnings);
}
