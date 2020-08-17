package com.company.applicationtest.utils;

import com.company.applicationtest.dto.AccountDto;
import com.company.applicationtest.model.Account;
import com.company.applicationtest.model.User;

import java.util.Date;

public class AccountUtil {
    public static Account newAccount(String id, Date update, User user) {
        Account account = new Account();
        account.setId(id);
        account.setUpdate(update);
        account.setProduct("Gold account.");
        account.setStatus("ENABLED");
        account.setType("CREDIT_CARD");
        account.setBalance(2638.2743685932996);
        account.setUser(user);
        return account;
    }

    public static AccountDto newAccountDto(String id, Date update, User user) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(id);
        accountDto.setUpdate(update);
        accountDto.setProduct("Gold account.");
        accountDto.setStatus("ENABLED");
        accountDto.setType("CREDIT_CARD");
        accountDto.setBalance(2638.2743685932996);
        accountDto.setUserName(user.getName());
        return accountDto;
    }
}
