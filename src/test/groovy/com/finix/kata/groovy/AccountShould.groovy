package com.finix.kata.groovy

import spock.lang.*

import java.lang.reflect.Array


/**
 * Created by alex on 6/18/17.
 */

class AccountShould extends Specification {

    TransactionRepository transactionRepository = Mock()
    StatementPrinter statementPrinter = Mock()

    Account account

    def setup() {
        account = new Account(transactionRepository, statementPrinter)
    }

    def "should deposit a transaction"() {
        when:
        account.deposit(100)

        then:
        1 * transactionRepository.depositTransaction(100)
    }

    def "should withdraw a transaction"() {
        when:
        account.withdraw(100)

        then:
        1 * transactionRepository.withdrawTransaction(100)

    }

    def "should call statementPrinter with a list of transactions"() {
        setup()
        def transactions = Arrays.asList(new Transaction("25/02/2017", 100));
        transactionRepository.allTransactions() >> transactions

        when:
        account.printStatement()

        then:
        1 * statementPrinter.print(transactions)
    }

    
}
