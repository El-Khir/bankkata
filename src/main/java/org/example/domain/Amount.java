package org.example.domain;

import java.text.DecimalFormat;

public class Amount extends AbstractWrapper<Long> {

    private final DecimalFormat df = new DecimalFormat("#.00");

    public Amount(Long value) {
        super(value);
    }

    public Amount add(Amount amount) {
        return new Amount(value + amount.value);
    }

    public Amount subtract(Amount amount) {
        return new Amount(value - amount.value);
    }

    public boolean isPositive() {
        return value > 0;
    }

    public static Amount of(Long value) {
        return new Amount(value);
    }

    public StatementElement statementElement() {
        return new StatementElement(df.format(value));
    }
}
