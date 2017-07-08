package specs

import com.finix.kata.groovy.Account
import com.finix.kata.groovy.Clock
import com.finix.kata.groovy.Console
import com.finix.kata.groovy.StatementPrinter
import com.finix.kata.groovy.TransactionRepository
import spock.lang.*

/**
 * Created by alex on 6/18/17.
 */
class PrintStatementSpecs extends Specification {

    Account account
    Console console = Mock()
    Clock clock = Mock()
    TransactionRepository repository
    StatementPrinter printer

    def setup(){
        repository = new TransactionRepository(clock)
        printer = new StatementPrinter(console)

        account = new Account(repository, printer)
    }

    def print_statement_all() {
        setup:
        clock.nowToString() >>> ["10/01/2012", "13/01/2012", "14/01/2012"]

        when:
        account.deposit(1000)
        account.deposit(2000)
        account.withdraw(500)

        account.printStatement()

        then:
        1 * console.printline("date || credit || debit || balance")

        then:
        1 * console.printline("14/01/2012 ||  || 500 || 2500")

        then:
        1 * console.printline("13/01/2012 || 2000 ||  || 3000")

        then:
        1 * console.printline("10/01/2012 || 1000 ||  || 1000")
    }

}
