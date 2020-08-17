package com.company.applicationtest.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDto {
    private Integer id;

    @NotNull
    @NotBlank(message = "Name can't be blank.")
    private String name;
}
