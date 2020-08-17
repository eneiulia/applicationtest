package com.company.applicationtest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AccountDto {
    private String id;
    private Date update;
    private String userName;
    private String product;
    private String status;
    private String type;
    private Double balance;
}