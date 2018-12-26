package pers.henglin.design.pattern.state

import spock.lang.Specification

class StateTest extends Specification {
    /*
        [create] --> [ready] <--> [running] --> [finish]
                     ^           |
                     |           V
                     [  blocked  ]
     */
    def "test State termination"() {
        setup:
        ThreadContext context = new ThreadContext([Action.TERMINATION])

        when:
        while(!context.isFinish()){
            context.change()
        }

        then:
        context.getLog() == new File(getClass().getResource('/state/termination.txt').toURI()).text
    }

    def "test State IO"() {
        setup:
        ThreadContext context = new ThreadContext([Action.IO, Action.TERMINATION])

        when:
        while(!context.isFinish()){
            context.change()
        }

        then:
        context.getLog() == new File(getClass().getResource('/state/io.txt').toURI()).text
    }

    def "test State timeout"() {
        setup:
        ThreadContext context = new ThreadContext([Action.TIMEOUT, Action.TERMINATION])

        when:
        while(!context.isFinish()){
            context.change()
        }

        then:
        context.getLog() == new File(getClass().getResource('/state/timeout.txt').toURI()).text
    }
}
