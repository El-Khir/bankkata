package org.example.domain;

import org.example.domain.StatementElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StatementElementTest {

    private static final StatementElement HELLO = new StatementElement("HELLO");
    private static final StatementElement HI = new StatementElement("HI");

    @Mock
    private PrintStream printStream;

    @Test
    public void givenAnotherAmountWithDifferentValue_whenEquals_ThenReturnFalse() {
        assertNotEquals(HI, HELLO);
    }

    @Test
    public void givenAnotherAmountWithSameValue_whenEquals_ThenReturnTrue() {
        StatementElement anotherHello = new StatementElement("HELLO");

        assertEquals(anotherHello, HELLO);
    }

    @Test
    public void whenStaticStatementElementOf_thenInitialiseCorrectStatementElement() {

        assertEquals(HELLO, StatementElement.of("HELLO"));
    }

    @Test
    public void givenNullValue_whenNew_thenIllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> new StatementElement(null));
    }

    @Test
    public void givenNullValue_whenStaticOf_thenIllegalArgumentExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> StatementElement.of(null));
    }

    @Test
    public void whenConcat_thenReturnConcatenatedWithSeparator() {
        StatementElement expectedConcatenated = new StatementElement("HELLO || HI");
        assertEquals(expectedConcatenated, HELLO.concat(HI));

    }

    @Test
    public void whenPrint_thenPrintCorrectValue() {
        HELLO.print(printStream);

        verify(printStream).println("HELLO");
    }

}
