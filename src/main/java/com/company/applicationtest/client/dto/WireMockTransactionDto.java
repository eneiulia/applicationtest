package com.company.applicationtest.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WireMockTransactionDto {
    private String id;
    private String accountId;
    private ExchangeRate exchangeRate;
    private OriginalAmount originalAmount;
    private Creditor creditor;
    private Debtor debtor;
    private String status;
    private String amount;
    private String update;
    private String description;
}

@Getter
@Setter
class OriginalAmount {
    private String amount;
}

@Getter
@Setter
class Creditor {
    private String maskedPan;
    private String name;
}

@Getter
@Setter
class Debtor {
    private String maskedPan;
    private String name;
}
