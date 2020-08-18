package com.company.applicationtest.client.facade;

import com.company.applicationtest.client.dto.WireMockTransactionDto;
import com.company.applicationtest.client.service.WireMockClientService;
import com.company.applicationtest.dto.AccountDto;
import com.company.applicationtest.model.Account;
import com.company.applicationtest.model.Transaction;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class WireMockClientFacade {

    private final WireMockClientService wireMockClientService;

    private final ModelMapper modelMapper;

    public List<Account> getAccounts(String name) {
        List<AccountDto> listOfAccountDtos = wireMockClientService.getAccounts(name);
        return listOfAccountDtos.stream()
                .map(accountDto -> modelMapper.map(accountDto, Account.class))
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactions(String name) {
        List<WireMockTransactionDto> listOfWireMockTransactionDtos = wireMockClientService.getTransactions(name);
        return listOfWireMockTransactionDtos.stream()
                .map(transactionDto -> {
                    Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
                    transaction.setCurrencyFrom(transactionDto.getExchangeRate().getCurrencyFrom());
                    transaction.setCurrencyTo(transactionDto.getExchangeRate().getCurrencyTo());
                    return transaction;
                })
                .collect(Collectors.toList());
    }
}
