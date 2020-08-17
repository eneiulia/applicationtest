package com.company.applicationtest.service;

import com.company.applicationtest.client.facade.WireMockClientFacade;
import com.company.applicationtest.model.Transaction;
import com.company.applicationtest.model.User;
import com.company.applicationtest.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    private TransactionRepository transactionRepository;

    private WireMockClientFacade wireMockClientFacade;

    private UserService userService;

    public void updateTransactions() {
        List<User> users = userService.getAllUsers();
        users.parallelStream().forEach(user ->
                saveTransactions(wireMockClientFacade.getTransactions(user.getName())));
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Async
    private void saveTransactions(List<Transaction> transactions) {
        transactionRepository.saveAll(transactions);
    }
}
