package pers.henglin.design.pattern.decorator

import pers.henglin.design.pattern.decorator.impl.*
import spock.lang.Specification

class DecoratorTest extends Specification {
    def "test decorator: control CRUD"() {
        setup:
        Control control = new Control()


        when:
        PermissionsDecorator permissionsDecorator = new Delete(new Update(new Read(new Create(control))))

        then:
        Integer.toBinaryString(permissionsDecorator.open()) == "1111"
        permissionsDecorator.id() == "control -> create -> read -> update -> delete"
    }
}
