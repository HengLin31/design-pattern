package pers.henglin.design.pattern.proxy

import pers.henglin.design.pattern.proxy.impl.LogHandler
import pers.henglin.design.pattern.proxy.impl.Service
import pers.henglin.design.pattern.proxy.impl.Session
import spock.lang.Specification

class ProxyTest extends Specification {
    def "test java proxy"() {
        setup:
        def initSession = [
                "key1": "value1",
                "key2": "value2",
                "key3": "value3",
                "key4": "value4",
                "key5": "value5",
        ]
        LogHandler logHandler = new LogHandler()
        Service service = (Service) logHandler.bind(new Session(initSession))

        when:
        service.getKeys()
        service.getValue("key1")
        service.getValue("key2")
        service.getValue("key3")
        service.getValue("key4")
        service.getValue("key5")

        then:
        logHandler.getLog() == new File(getClass().getResource('/proxy/steps.txt').toURI()).text
    }
}
