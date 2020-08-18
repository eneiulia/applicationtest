package com.company.applicationtest.facade;

import com.company.applicationtest.dto.UserDto;
import com.company.applicationtest.model.User;
import com.company.applicationtest.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserFacade {

    private final UserService userService;

    private final ModelMapper modelMapper;

    public List<UserDto> getAllUsers() {
        List<User> listOfUsers = userService.getAllUsers();
        return listOfUsers.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user = userService.createUser(user);
        return modelMapper.map(user, UserDto.class);
    }
}
