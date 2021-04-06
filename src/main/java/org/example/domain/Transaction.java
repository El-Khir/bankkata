package org.example.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Transaction {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    protected final Amount amount;
    protected final LocalDate date;

    protected Transaction(Amount amount, LocalDate date) {
        checkAmountValidity(amount);
        this.amount = amount;
        this.date = date;
    }

    protected StatementElement dateToStatementElement() {
        return new StatementElement(date.format(DATE_FORMATTER));
    }

    protected void checkAmountValidity(Amount amount) {
        if (!amount.isPositive()) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }
    }

    public abstract Amount performOn(Amount amount);

    public abstract StatementElement statementElement();
}
