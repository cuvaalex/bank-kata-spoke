package com.finix.kata.groovy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 6/18/17.
 */
public class TransactionRepository {

    private Clock clock;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public TransactionRepository(Clock clock){
        this.clock = clock;
    }

    public void depositTransaction(int amount) {
        transactions.add(new Transaction(clock.nowToString(), amount));
    }

    public void withdrawTransaction(int amount) {
        transactions.add(new Transaction(clock.nowToString(), -amount));
    }

    public List<Transaction> allTransactions() {
        return transactions;
    }

}
