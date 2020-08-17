package com.company.applicationtest.controller;

import com.company.applicationtest.model.Account;
import com.company.applicationtest.model.User;
import com.company.applicationtest.repository.AccountRepository;
import com.company.applicationtest.repository.UserRepository;
import com.company.applicationtest.utils.AccountUtil;
import com.company.applicationtest.utils.UserUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AccountControllerEndToEndTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    private static String accountURL = "/accounts";

    @Test
    public void shouldReturnAllAccounts() throws Exception {
        User user = userRepository.save(UserUtil.newUser("Ionut"));
        Account account = accountRepository.save(AccountUtil.newAccount("1", new Date(), user));

        mockMvc.perform(MockMvcRequestBuilders.get(accountURL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(account.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].product").value(account.getProduct()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value(account.getStatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].type").value(account.getType()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].balance").value(account.getBalance()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userName").value(user.getName()));
    }
}
