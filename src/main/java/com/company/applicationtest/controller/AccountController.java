package com.company.applicationtest.controller;

import com.company.applicationtest.dto.AccountDto;
import com.company.applicationtest.facade.AccountFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountFacade accountFacade;

    @GetMapping
    List<AccountDto> getAllAccountsForCurrentUser(Principal userPrincipal) {
        return accountFacade.getAllAccountsByUser(userPrincipal.getName());
    }

}
