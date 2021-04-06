package org.example.domain;

import java.io.PrintStream;
import java.util.List;
import java.util.Objects;

public class Statement {

    public static final StatementElement HEADER = header();

    private final List<StatementElement> statementElements;

    public Statement(List<StatementElement> statementElements) {
        this.statementElements = statementElements;
    }

    public void print(PrintStream printStream) {
        HEADER.print(printStream);
        statementElements.
                forEach(statementElement -> statementElement.print(printStream));
    }

    private static StatementElement header() {
        return StatementElement.of("date")
                .concat(StatementElement.of("credit"))
                .concat(StatementElement.of("debit"))
                .concat(StatementElement.of("balance"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(statementElements, statement.statementElements);
    }
}
