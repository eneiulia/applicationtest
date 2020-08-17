package com.company.applicationtest.controller;

import com.company.applicationtest.dto.TransactionDto;
import com.company.applicationtest.facade.TransactionFacade;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {

    private TransactionFacade transactionFacade;

    @GetMapping
    List<TransactionDto> getAllTransactions() {
        return transactionFacade.getAllTransactions();
    }

}
