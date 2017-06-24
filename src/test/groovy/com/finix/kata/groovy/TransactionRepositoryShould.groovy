package com.finix.kata.groovy

import spock.lang.Specification

/**
 * Created by alex on 6/24/17.
 */
class TransactionRepositoryShould extends Specification {


    def "should stock a deposit transaction"() {
        setup:
            def clock = Mock()
            def repository = new TransactionRepository(clock)
            def transactions = Arrays.asList(new Transaction("25/02/2017", 100));


        when:
            clock.TODAY >> "25/02/2017"
            repository.depositTransaction(100)


        then:
            repository.allTransactions().length == 1
            repository.allTransactions() == transactions

    }
}
