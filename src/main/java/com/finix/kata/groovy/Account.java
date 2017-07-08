package com.finix.kata.groovy;

import java.util.List;

/**
 * Created by alex on 6/18/17.
 */
public class Account {

    private final TransactionRepository repository;
    private final StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter){
        this.repository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }


    public void deposit(int amount) {
        repository.depositTransaction(amount);
    }

    public void withdraw(int amount) {
        repository.withdrawTransaction(amount);
    }

    public void printStatement() {
        List<Transaction> transactions =  repository.allTransactions();
        statementPrinter.print(transactions);

    }
}
