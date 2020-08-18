package com.company.applicationtest.configuration;

import com.company.applicationtest.service.AccountService;
import com.company.applicationtest.service.TransactionService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private final AccountService accountService;

    private final TransactionService transactionService;

    @Scheduled(cron="${update.cron}")
    public void updateAccountsAndTransactions() {
        accountService.updateAccounts();
        transactionService.updateTransactions();
        log.debug("Update accounts and transactions.");
    }

    @Scheduled(cron="${cleanup.cron}")
    public void cleanupAccounts() {
        accountService.cleanupAccounts();
        log.debug("Cleanup accounts.");
    }
}
