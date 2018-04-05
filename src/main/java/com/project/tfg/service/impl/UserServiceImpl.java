package com.project.tfg.service.impl;

import com.project.tfg.dto.UserDto;
import com.project.tfg.model.User;
import com.project.tfg.repository.UserRepository;
import com.project.tfg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Optional<UserDto> save(UserDto userDto) {
         Optional<UserDto> user= Optional.of(toDto(this.userRepository.save(toModel(userDto))));
         return user;

    }




    @Override
    public Optional<UserDto> findById(String id) {
        return this.userRepository.findById(id).map(it -> toDto(it));
    }

    @Override
    public Optional<List<UserDto>> findAll() {
        return Optional.of(this.userRepository.findAll().stream().map(this::toDto).collect(Collectors.toList()));
    }

    @Override
    public void delete(UserDto userDto) {
        this.userRepository.delete(toModel(userDto));
    }

    @Override
    public Optional<UserDto> update(UserDto userDto) {
        Optional<UserDto> user = Optional.of(toDto(this.userRepository.save(toModel(userDto))));
        return user;
    }

    private User toModel(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        return user;
    }

    private UserDto toDto(User userDto) {
        UserDto user = new UserDto();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        return user;
    }
}
