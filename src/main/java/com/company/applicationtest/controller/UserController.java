package com.company.applicationtest.controller;

import com.company.applicationtest.dto.AccountDto;
import com.company.applicationtest.dto.UserDto;
import com.company.applicationtest.facade.AccountFacade;
import com.company.applicationtest.facade.UserFacade;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
@AllArgsConstructor
public class UserController {

    UserFacade userFacade;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userFacade.getAllUsers();
    }

    @PostMapping
    public UserDto createUser(@RequestBody @Valid UserDto userDto) {
        return userFacade.createUser(userDto);
    }
}

