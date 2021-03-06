package com.project.tfg.controller;


import com.project.tfg.dto.UserDto;
import com.project.tfg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Optional<List<UserDto>> getAll(){
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserDto> getById(@PathVariable("id") String id){
        return this.userService.findById(id);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserDto userDto){
        Optional<UserDto> update = this.userService.update(userDto);
        return Optional.of(update)
                .map(it -> new ResponseEntity<>(it,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
    @PostMapping
    public Optional<UserDto> save(@RequestBody UserDto userDto){
        return this.userService.save(userDto);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody UserDto userDto){
         this.userService.delete(userDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
