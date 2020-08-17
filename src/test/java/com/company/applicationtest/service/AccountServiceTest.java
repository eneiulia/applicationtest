package com.company.applicationtest.service;

import com.company.applicationtest.client.service.WireMockClientService;
import com.company.applicationtest.model.User;
import com.company.applicationtest.repository.AccountRepository;
import com.company.applicationtest.repository.UserRepository;
import com.company.applicationtest.utils.AccountUtil;
import com.company.applicationtest.utils.UserUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AccountServiceTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @MockBean
    private WireMockClientService wireMockClientService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnAllAccounts() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        User user = userRepository.save(UserUtil.newUser("Ionut"));
        accountRepository.save(AccountUtil.newAccount("1", cal.getTime(), user));
        Date newDate = new Date();
        Mockito.when(wireMockClientService.getAccounts(Mockito.any(String.class)))
                .thenReturn(Arrays.asList(AccountUtil.newAccountDto("1", newDate, user)));

        accountService.updateAccounts();

        assertEquals(newDate, accountRepository.findAll().get(0).getUpdate());
    }

}
