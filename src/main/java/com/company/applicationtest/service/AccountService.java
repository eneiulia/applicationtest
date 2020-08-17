package com.company.applicationtest.service;

import com.company.applicationtest.client.facade.WireMockClientFacade;
import com.company.applicationtest.model.Account;
import com.company.applicationtest.model.User;
import com.company.applicationtest.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private WireMockClientFacade wireMockClientFacade;

    private AccountRepository accountRepository;

    private UserService userService;

    public void updateAccounts() {
        List<User> users = userService.getAllUsers();
        users.parallelStream()
                .forEach(user -> saveAccounts(wireMockClientFacade.getAccounts(user.getName()), user));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void cleanupAccounts() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        accountRepository.findAll().stream().filter(account -> account.getUpdate().before(cal.getTime()))
                .forEach(account -> accountRepository.delete(account));
    }

    private void saveAccounts(List<Account> accounts, User user) {
        accounts.forEach(account -> account.setUser(user));
        accountRepository.saveAll(accounts);
    }
}
