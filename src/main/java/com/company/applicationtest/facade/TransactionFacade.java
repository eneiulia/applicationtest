package com.company.applicationtest.facade;

import com.company.applicationtest.dto.TransactionDto;
import com.company.applicationtest.model.Transaction;
import com.company.applicationtest.service.TransactionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TransactionFacade {

    private final TransactionService transactionService;

    private final ModelMapper modelMapper;

    public List<TransactionDto> getAllTransactionsByUser(String username) {
        List<Transaction> listOfTransactions = transactionService.getAllTransactionsByUser(username);
        return listOfTransactions.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
    }
}
