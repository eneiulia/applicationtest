package com.company.applicationtest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
    private String id;
    private String currencyFrom;
    private String currencyTo;
    private String exchangeRate;
    private String originalAmount;
    private String creditorMaskedPan;
    private String creditorName;
    private String debtorMaskedPan;
    private String debtorName;
    private String status;
    private String amount;
    private String update;
    private String description;
    private String accountId;
}