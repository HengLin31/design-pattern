package pers.henglin.design.pattern.decorator2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.henglin.design.pattern.decorator2.impl.Weapon;

/**
 * Created by linheng on 14/11/2019.
 */
public class Warrior {
    private static final Logger LOG = LoggerFactory.getLogger(Warrior.class);

    private String name;
    private Weapon weapon;

    public Warrior(String name, Weapon weapon){
        this.name = name;
        this.weapon = weapon;
    }

    public void attack(){
        LOG.info("{} use ", this.name);
        weapon.attack();
        LOG.info("---");
    }

    public Weapon getWeapon(){
        return this.weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
}
