package com.finix.kata.groovy;

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


    public void deposit(double amount) {
        repository.depositTransaction(amount);
    }

    public void withdraw(double amount) {
        repository.withdrawTransaction(amount);
    }

    public void printStatement() {
        Transaction[] transactions =  repository.allTransactions();
        statementPrinter.print(transactions);

    }
}
