package org.example.AtmSystem.model.service;

import org.example.AtmSystem.model.dtos.UserDto;
import org.example.AtmSystem.model.entity.Role;
import org.example.AtmSystem.model.entity.User;
import org.example.AtmSystem.model.exception.UserException;
import org.example.AtmSystem.model.repository.UserRepo;
import org.example.AtmSystem.util.Regex;

public class AuthService {
    private final UserRepo repo;

    public AuthService(UserRepo repo) {
        this.repo = repo;
    }

    public void register(UserDto dto) {
        validateUserDto(dto);
        User user = userDtoToUser(dto);
        baseValidation(user);
        repo.save(user);
    }

    private void baseValidation(User user) {
        if (!(user.getFirstName().matches(Regex.name) &&
                user.getLastName().matches(Regex.lastName) &&
                user.getNationalCode().matches(Regex.National_Code))) {
            throw new UserException("Invalid input");
        }
    }

    private User userDtoToUser(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setRegisterDate(dto.getRegisterDate());
        user.setNationalCode(dto.getNationalCode());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setCardNumber(dto.getCardNumber());
        user.setRole(dto.getRole());
        user.setPassword(dto.getPassword());
        return user;
    }

    private void validateUserDto(UserDto dto) {
        if (dto == null) {
            throw new UserException("userDto cannot be null");
        }
    }

    public Role login(String nationalCode, String password) {
        return repo.login(nationalCode, password);
    }

    public void forgotPass(String numberCard, String password, String newPassword) {
        repo.changePassword(numberCard, password, newPassword);
    }

}
