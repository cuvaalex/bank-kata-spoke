package com.finix.kata.groovy

import spock.lang.Specification

import java.time.LocalDate

/**
 * Created by alex on 7/8/17.
 */
class ClockShould extends Specification {

    Clock clock

    def setup() {
        clock = new Clock()
    }

    def "should return today date under format dd/MM/yyyy"() {
        when:
        clock.now = LocalDate.of(2017, 7, 8)

        then:
        clock.nowToString() == "08/07/2017"
    }
}
