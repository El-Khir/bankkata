package org.example.domain;

import org.example.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void init() {
        account = new Account();
    }

    @Test
    public void givenEmptyAccount_whenStatement_thenReturnEmptyList() {
        Statement emptyStatement = new Statement(Collections.emptyList());
        assertEquals(emptyStatement, account.statement());
    }


    @Test
    public void givenPerformedTransactions_whenStatement_thenReturnCorrectStatement() {
        LocalDate now = LocalDate.now();
        String formattedNow = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Transaction depositTen = new Deposit(new Amount(10L), now);
        Transaction withdrawalFive = new Withdrawal(new Amount(5L), now);
        Transaction depositTwenty = new Deposit(new Amount(20L), now);

        Statement expectedStatement = new Statement(Arrays.asList(
                StatementElement.of(formattedNow + " || 20.00 ||  || 25.00"),
                StatementElement.of(formattedNow + " ||  || 5.00 || 5.00"),
                StatementElement.of(formattedNow + " || 10.00 ||  || 10.00")

        ));

        account.performTransaction(depositTen);
        account.performTransaction(withdrawalFive);
        account.performTransaction(depositTwenty);
        Statement statement = account.statement();

        assertEquals(expectedStatement, statement);

    }


}
