package specs

import com.finix.kata.groovy.Account
import com.finix.kata.groovy.Console
import spock.lang.*

/**
 * Created by alex on 6/18/17.
 */
class PrintStatementSpecs extends Specification {

    Account account
    Console console = Mock()

    def setup(){
        account = new Account()
    }

    def print_statement_all() {
        when:
        account.deposit(1000.00)
        account.deposit(2000.00)
        account.withdraw(500.00)

        account.printStatement()

        then:
        1 * console.printline("date       || credit   || debit    || balance")

        then:
        1 * console.printline("14/01/2012 ||          || 500.00   || 2500.00")

        then:
        1 * console.printline("13/01/2012 || 2000.00  ||          || 3000.00")

        then:
        1 * console.printline("10/01/2012 || 1000.00  ||          || 1000.00")
    }

}
