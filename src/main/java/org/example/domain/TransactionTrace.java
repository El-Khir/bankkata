package org.example.domain;

public class TransactionTrace {

    private final Transaction transaction;
    private final Amount amountAfterTransaction;

    public TransactionTrace(Transaction transaction, Amount amountAfterTransaction) {
        this.transaction = transaction;
        this.amountAfterTransaction = amountAfterTransaction;
    }

    public StatementElement statementElement() {
        return transaction.statementElement()
                .concat(amountAfterTransaction.statementElement());
    }
}
