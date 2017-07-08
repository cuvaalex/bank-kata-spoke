package com.finix.kata.groovy

import spock.lang.Specification

/**
 * Created by alex on 7/8/17.
 */
class StatementPrinterShould extends Specification{

    StatementPrinter statement
    Console console = Mock()

    def setup() {
        statement = new StatementPrinter(console);
    }

    def "Should always return the header"() {
        when:
        def transactions = new ArrayList<Transaction>()
        statement.print(transactions)

        then:
        1 * console.printline("date || credit || debit || balance")
    }

    def "Should return statement in a reverse mode"() {
        when:
        def transactions = containingTransaction(
            depositTransaction("10/01/2012", 1000),
            depositTransaction("13/01/2012", 2000),
            withdrawTransaction("14/01/2012", 500)
        )
        statement.print(transactions)

        then:
        1 * console.printline("date || credit || debit || balance")

        then:
        1 * console.printline("14/01/2012 ||  || 500 || 2500")

        then:
        1 * console.printline("13/01/2012 || 2000 ||  || 3000")

        then:
        1 * console.printline("10/01/2012 || 1000 ||  || 1000")

    }

    List<Transaction> containingTransaction(Transaction... transactions) {
        return Arrays.asList(transactions)
    }

    Transaction depositTransaction(String date, int amount) {
        return new Transaction(date, amount)
    }

    Transaction withdrawTransaction(String date, int amount) {
        return new Transaction(date, -amount)
    }
}
