package pers.henglin.design.pattern.decorator2.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by linheng on 14/11/2019.
 */
public class FirePower extends WeaponDecorator {
    private static final Logger LOG = LoggerFactory.getLogger(FirePower.class);

    public FirePower(Weapon weapon) {
        super("fire", 5, weapon);
    }

    @Override
    protected void special(){
        super.special();
        LOG.info("special fire hit point 5");
    }
}
