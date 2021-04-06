package org.example.domain;

import java.io.PrintStream;

public class StatementElement extends AbstractWrapper<String> {

    private static final String SEPARATOR = " || ";
    public static final StatementElement EMPTY = new StatementElement("");

    public StatementElement(String value) {
        super(value);
    }

    public static StatementElement of(String value) {
        return new StatementElement(value);
    }

    public StatementElement concat(StatementElement other) {
        return new StatementElement (String.join(SEPARATOR, value, other.value));
    }

    public void print(PrintStream printStream) {
        printStream.println(value);
    }
}
