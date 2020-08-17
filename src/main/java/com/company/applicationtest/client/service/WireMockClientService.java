package com.company.applicationtest.client.service;

import com.company.applicationtest.client.WireMockClient;
import com.company.applicationtest.client.dto.WireMockTransactionDto;
import com.company.applicationtest.dto.AccountDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class WireMockClientService {

    private WireMockClient wireMockClient;

    public List<AccountDto> getAccounts(String name) {
        return wireMockClient.getAccounts(getToken(name));
    }

    public List<WireMockTransactionDto> getTransactions(String name) {
        return wireMockClient.getTransactions(getToken(name));
    }

    private String getToken(String name) {
        return wireMockClient.login(name).get("token");
    }
}
