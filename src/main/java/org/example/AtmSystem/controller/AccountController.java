package org.example.AtmSystem.controller;

import org.example.AtmSystem.model.dtos.AccountDto;
import org.example.AtmSystem.model.dtos.UserDto;
import org.example.AtmSystem.model.service.AccountService;

import java.util.List;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void create(){
        accountService.create();
    }
    public void update(UserDto dto){
        accountService.update(dto);
    }
    public void delete(long id){
        accountService.delete(id);
    }
    public AccountDto findById(long id){
        return accountService.findById(id);
    }
    public List<AccountDto> finaAll(){
        //return null;
        return accountService.findAll();
    }
}
