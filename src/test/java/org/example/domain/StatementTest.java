package org.example.domain;

import org.example.domain.Statement;
import org.example.domain.StatementElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StatementTest {

    @Mock
    private PrintStream printStream;

    private static final String header = "date || credit || debit || balance";

    @Test
    public void givenEmptyStatementElementList_whenPrint_thenOnlyPrintHeader() {
        Statement statement = new Statement(Collections.emptyList());

        statement.print(printStream);

        verify(printStream).println(any(String.class));
        verify(printStream).println(header);
    }

    @Test
    public void whenPrint_thenPrintCorrectValues() {
        StatementElement hello = StatementElement.of("HELLO");
        StatementElement hi = StatementElement.of("HI");
        Statement statement = new Statement(Arrays.asList(hello, hi));

        statement.print(printStream);

        verify(printStream, times(3)).println(any(String.class));
        verify(printStream).println(header);
        verify(printStream).println("HELLO");
        verify(printStream).println("HI");
    }

}
