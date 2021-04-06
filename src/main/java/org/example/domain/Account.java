package org.example.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Account {

    private static final int LIST_HEAD = 0;

    private Amount balance = new Amount(0L);
    private final List<TransactionTrace> transactionTraces = new LinkedList<>();

    public void performTransaction(Transaction transaction) {
        balance = transaction.performOn(balance);
        transactionTraces.add(LIST_HEAD, new TransactionTrace(transaction, balance));
    }

    public Statement statement() {
        return new Statement(toStatementElementList());
    }

    private List<StatementElement> toStatementElementList() {
        return transactionTraces.stream()
                .map(TransactionTrace::statementElement)
                .collect(Collectors.toList());
    }
}