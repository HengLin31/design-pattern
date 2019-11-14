package pers.henglin.design.pattern.decorator2

import pers.henglin.design.pattern.decorator2.impl.*
import spock.lang.Specification

/**
 * Created by linheng on 14/11/2019.
 */
class Decorator2Test extends Specification {
    def "test decorator2: warrior use weapon"() {
        setup:
        String warriorName = "Kevin"

        Weapon sword = new Sword()
        Weapon fireSword = new FirePower(sword)
        Weapon holySword = new HolyPower(sword)
        Weapon holyFireSword = new HolyPower(fireSword)
        Warrior warrior = new Warrior(warriorName, sword)
        warrior.attack()

        warrior.setWeapon(fireSword)
        warrior.attack()

        warrior.setWeapon(holySword)
        warrior.attack()

        warrior.setWeapon(holyFireSword)
        warrior.attack()

    }
}
