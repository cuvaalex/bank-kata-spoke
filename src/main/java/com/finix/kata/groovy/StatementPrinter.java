package com.finix.kata.groovy;

import com.sun.jdi.connect.Connector;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by alex on 6/24/17.
 */
public class StatementPrinter {

    public static final String STATEMENT_HEADER = "date || credit || debit || balance";
    private final Console console;
    private final AtomicInteger totalAmount = new AtomicInteger();

    public StatementPrinter(Console console){
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printline(STATEMENT_HEADER);

        transactions.stream().map(transaction -> {
            return statementLine(transaction, totalAmount);
        }).collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printline);
    }

    private String statementLine(Transaction transaction, AtomicInteger totalAmount) {
        StringBuffer sb = new StringBuffer();
        sb.append(transaction.date);
        sb.append(" || ");
        if(transaction.amount < 0){
            sb.append(" || ");
            sb.append(-transaction.amount);
            sb.append(" || ");
        }else {
            sb.append(transaction.amount);
            sb.append(" || ");
            sb.append(" || ");
        }
        sb.append(totalAmount.addAndGet(transaction.amount));
        return sb.toString();
    }
}
