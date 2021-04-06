package org.example.domain;

import java.time.LocalDate;

public class Withdrawal extends Transaction {

    public Withdrawal(Amount amount, LocalDate date) {
        super(amount, date);
    }

    @Override
    public Amount performOn(Amount amount) {
        return amount.subtract(this.amount);
    }

    @Override
    public StatementElement statementElement() {
        return dateToStatementElement()
                .concat(StatementElement.EMPTY)
                .concat(amount.statementElement());
    }

}
