package com.company.applicationtest.service;

import com.company.applicationtest.client.facade.WireMockClientFacade;
import com.company.applicationtest.model.Transaction;
import com.company.applicationtest.model.User;
import com.company.applicationtest.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final WireMockClientFacade wireMockClientFacade;

    private final UserService userService;

    public void updateTransactions() {
        List<User> users = userService.getAllUsers();
        users.parallelStream().forEach(user ->
                saveTransactions(wireMockClientFacade.getTransactions(user.getName())));
    }

    public List<Transaction> getAllTransactionsByUser(String username) {
        return userService.getUserByUsername(username).getAccounts().stream().
                flatMap(account -> account.getTransactions().stream()).collect(Collectors.toList());
    }

    @Async
    private void saveTransactions(List<Transaction> transactions) {
        transactionRepository.saveAll(transactions);
    }
}
