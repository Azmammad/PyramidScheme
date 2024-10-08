package com.example.pyramidscheme.services.impl;

import com.example.pyramidscheme.entities.User;
import com.example.pyramidscheme.mapper.UserMapper;
import com.example.pyramidscheme.model.request.UserRequestDto;
import com.example.pyramidscheme.model.response.UserResponseDto;
import com.example.pyramidscheme.repositories.UserRepository;
import com.example.pyramidscheme.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        if (userRequestDto.getSponsorId() != null) {
            User sponsor = userRepository.findById(userRequestDto.getSponsorId()).orElse(null);
            user.setSponsor(sponsor);
            distributeEarnings(sponsor, user.getInvestment());
        }
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateUserEarnings(Long userId, double earnings) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.addEarnings(earnings);
            userRepository.save(user);
        }
    }

    private void distributeEarnings(User sponsor, Double investment) {
        if (sponsor != null) {
            sponsor.addEarnings(investment * 0.10);
            userRepository.save(sponsor);
            distributeEarnings(sponsor.getSponsor(), investment * 0.10);
        }
    }
}
