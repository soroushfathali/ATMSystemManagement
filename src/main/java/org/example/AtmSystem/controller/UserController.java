package org.example.AtmSystem.controller;
import org.example.AtmSystem.model.dtos.AccountDto;
import org.example.AtmSystem.model.dtos.UserDto;
import org.example.AtmSystem.model.service.UserService;

import java.util.List;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public void create(){
        userService.create();
    }
    public void update(UserDto dto){
        userService.update(dto);
    }
    public void delete(long id){
        userService.delete(id);
    }
    public UserDto findById(long id){
        return userService.findById(id);
    }
    public List<AccountDto> finaAll(){
        //return null;
        return userService.findAll();
    }
}
