package org.example.domain;

import java.time.LocalDate;

public class Deposit extends Transaction {

    public Deposit(Amount amount, LocalDate date) {
        super(amount, date);
    }

    @Override
    public Amount performOn(Amount amount) {
        return amount.add(this.amount);
    }

    @Override
    public StatementElement statementElement() {
        return dateToStatementElement()
                .concat(amount.statementElement())
                .concat(StatementElement.EMPTY);
    }


}
