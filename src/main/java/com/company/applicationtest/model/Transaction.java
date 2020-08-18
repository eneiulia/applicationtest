package com.company.applicationtest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    private String id;

    @Column(name = "currency_from")
    private String currencyFrom;

    @Column(name = "currency_to")
    private String currencyTo;

    @Column(name = "exchange_rate")
    private String exchangeRate;

    @Column(name = "original_amount")
    private String originalAmount;

    @Column(name = "creditor_masked_pan")
    private String creditorMaskedPan;

    @Column(name = "creditor_name")
    private String creditorName;

    @Column(name = "debtor_masked_pan")
    private String debtorMaskedPan;

    @Column(name = "debtor_name")
    private String debtorName;

    private String status;

    private String amount;

    @Column(name = "update_time")
    private Date update;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
