package org.example.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WithdrawalTest {

    private static final LocalDate NOW = LocalDate.now();

    @Test
    public void givenNegativeAmount_whenNew_thenIllegalArgumentExceptionThrown() {
        Amount negativeAmount = Amount.of(-10L);
        assertThrows(IllegalArgumentException.class, () -> new Withdrawal(negativeAmount, NOW));
    }

    @Test
    public void givenZeroAmount_whenNew_thenIllegalArgumentExceptionThrown() {
        Amount negativeAmount = Amount.of(0L);
        assertThrows(IllegalArgumentException.class, () -> new Withdrawal(negativeAmount, NOW));
    }

    @Test
    public void whenPerform_thenReturnDifferentAmount() {
        Transaction withdrawalTen = new Withdrawal(Amount.of(10L), NOW);

        assertEquals(Amount.of(-5L), withdrawalTen.performOn(Amount.of(5L)));
    }

    @Test
    public void whenStatementElement_thenReturnCorrectStatementElement() {
        Transaction withdrawalTen = new Withdrawal(Amount.of(10L), NOW);
        StatementElement expectedStatementElement = StatementElement.of(
                NOW.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        + " ||  || 10.00");

        assertEquals(expectedStatementElement, withdrawalTen.statementElement());
    }


}
