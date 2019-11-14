package pers.henglin.design.pattern.decorator2.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by linheng on 14/11/2019.
 */
public class Sword implements Weapon {
    private static final Logger LOG = LoggerFactory.getLogger(Sword.class);

    private String name = "sword";
    private int hitPoint = 10;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHitPoint() {
        return this.hitPoint;
    }

    @Override
    public void attack() {
        LOG.info("{} hit point {}", this.name, this.hitPoint);
    }
}
