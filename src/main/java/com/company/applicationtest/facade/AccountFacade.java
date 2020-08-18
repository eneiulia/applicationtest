package com.company.applicationtest.facade;

import com.company.applicationtest.dto.AccountDto;
import com.company.applicationtest.model.Account;
import com.company.applicationtest.service.AccountService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountFacade {

    private final AccountService accountService;

    private final ModelMapper modelMapper;

    public List<AccountDto> getAllAccountsByUser(String username) {
        List<Account> listOfAccounts = accountService.getAllAccountsByUser(username);
        return listOfAccounts.stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }
}
