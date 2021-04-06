package org.example.domain;

import org.example.domain.Amount;
import org.example.domain.Deposit;
import org.example.domain.StatementElement;
import org.example.domain.TransactionTrace;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTraceTest {

    @Test
    public void whenStatementElement_thenReturnCorrectStatementElement() {
        LocalDate now = LocalDate.now();
        TransactionTrace depositTenOnFifteen = new TransactionTrace(new Deposit(Amount.of(10L), now), Amount.of(15L));

        StatementElement expectedStatementElement = StatementElement.of(
                now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        + " || 10.00 ||  || 15.00");

        assertEquals(expectedStatementElement, depositTenOnFifteen.statementElement());
    }

}
