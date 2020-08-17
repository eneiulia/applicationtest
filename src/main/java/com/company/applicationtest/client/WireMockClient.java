package com.company.applicationtest.client;

import com.company.applicationtest.client.dto.WireMockTransactionDto;
import com.company.applicationtest.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "WireMockAPI", url = "${wire.mock.client.api.url}")
public interface WireMockClient {

    @PostMapping(value = "/login")
    Map<String, String> login (
            @RequestHeader("username") String name
    );

    @GetMapping(value = "/accounts")
    List<AccountDto> getAccounts (
            @RequestHeader(name = "X-AUTH") String token
    );

    @GetMapping(value = "/transactions")
    List<WireMockTransactionDto> getTransactions (
            @RequestHeader(name = "X-AUTH") String token
    );
}

