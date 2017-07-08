package com.finix.kata.groovy

import spock.lang.Specification

/**
 * Created by alex on 6/24/17.
 */
class TransactionRepositoryShould extends Specification {

    String TODAY = "25/12/2016"
    Clock clock = Mock()

    def "should stock a deposit transaction"() {
        setup:
            def repository = new TransactionRepository(clock)
            def transactions = Arrays.asList(new Transaction(TODAY, 100))


        when:
            clock.nowToString() >> TODAY
            repository.depositTransaction(100)


        then:
            repository.allTransactions().size() == 1
            repository.allTransactions() == transactions

    }

    def "should stock a withdraw transaction"() {
        setup:
        def repository = new TransactionRepository(clock)
        def transactions = Arrays.asList(new Transaction(TODAY, -100))


        when:
        clock.nowToString() >> TODAY
        repository.withdrawTransaction(100)


        then:
        repository.allTransactions().size() == 1
        repository.allTransactions() == transactions

    }

}
