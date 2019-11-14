package pers.henglin.design.pattern.decorator2.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by linheng on 14/11/2019.
 */
public class WeaponDecorator implements Weapon {
    private static final Logger LOG = LoggerFactory.getLogger(WeaponDecorator.class);

    protected String name;
    protected int hitPoint;
    protected Weapon weapon;

    public WeaponDecorator(String name, int hitPoint, Weapon weapon){
        this.name = name;
        this.hitPoint = hitPoint;
        this.weapon = weapon;
    }

    @Override
    public String getName() {
        return name + " " + weapon.getName();
    }

    @Override
    public int getHitPoint() {
        return hitPoint + weapon.getHitPoint();
    }

    @Override
    public void attack() {
        LOG.info("{} hit point {}", getName(), getHitPoint());
        this.special();
    }

    protected void special(){
        if(weapon instanceof WeaponDecorator){
            WeaponDecorator deco = (WeaponDecorator) weapon;
            deco.special();
        }
    }
}
