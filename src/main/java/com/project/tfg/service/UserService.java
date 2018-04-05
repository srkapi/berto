package com.project.tfg.service;

import com.project.tfg.dto.UserDto;
import com.project.tfg.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserDto> save(UserDto userDto);
    Optional<UserDto> findById(String id);
    Optional<List<UserDto>> findAll();
    void delete(UserDto userDto);
    Optional<UserDto> update(UserDto userDto);
}
