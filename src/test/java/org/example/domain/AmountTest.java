package org.example.domain;

import org.example.domain.Amount;
import org.example.domain.StatementElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AmountTest {


    private static final Amount TEN = new Amount(10L);
    private static final Amount FIVE = new Amount(5L);
    public static final Amount FIFTEEN = new Amount(15L);

    @Test
    public void whenStaticAmountOf_thenInitialiseCorrectAmount() {
        Amount amountOfTen = Amount.of(10L);

        assertEquals(TEN, amountOfTen);
    }

    @Test
    public void givenNullValue_whenNew_thenIllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> new Amount(null));
    }

    @Test
    public void givenNullValue_whenStaticOf_thenIllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> new Amount(null));
    }

    @Test
    public void givenAnotherAmountWithDifferentValue_whenEquals_ThenReturnFalse() {
        Amount minusTen = Amount.of(-10L);

        assertNotEquals(TEN, minusTen);
    }

    @Test
    public void givenAnotherAmountWithSameValue_whenEquals_ThenReturnTrue() {
        Amount anotherTen = new Amount(10L);

        assertEquals(TEN, anotherTen);
    }

    @Test
    public void whenAdd_thenReturnSumValue() {
        Amount tenAddFive = TEN.add(FIVE);

        assertEquals(FIFTEEN, tenAddFive);
    }

    @Test
    public void whenAdd_thenReturnDifferenceValue() {

        Amount fiveSubtractTen = FIVE.subtract(TEN);

        assertEquals(Amount.of(-5L), fiveSubtractTen);
    }

    @Test
    public void givenNegativeAmount_whenIsPositive_thenReturnFalse() {
        Amount minusFive = Amount.of(-5L);

        assertFalse(minusFive.isPositive());
    }

    @Test
    public void givenZeroAmount_whenIsPositive_thenReturnFalse() {
        Amount zero = Amount.of(0L);

        assertFalse(zero.isPositive());
    }

    @Test
    public void givenPositiveAmount_whenIsPositive_thenReturnTrue() {
        assertTrue(TEN.isPositive());
    }

    @Test
    public void whenStatementElement_thenReturnExpectedStatementElement() {
        StatementElement expected = StatementElement.of("10.00");

        assertEquals(expected, TEN.statementElement());
    }

}