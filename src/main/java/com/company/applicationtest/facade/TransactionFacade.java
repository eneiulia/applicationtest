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

    private TransactionService transactionService;

    private ModelMapper modelMapper;

    public List<TransactionDto> getAllTransactions() {
        List<Transaction> listOfTransactions = transactionService.getAllTransactions();
        return listOfTransactions.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
    }
}
