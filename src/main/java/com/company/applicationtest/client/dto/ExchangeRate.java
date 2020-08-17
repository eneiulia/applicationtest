package com.company.applicationtest.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRate {
    private String currencyFrom;
    private String currencyTo;
    private String rate;
}