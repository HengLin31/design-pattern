package pers.henglin.design.pattern.decorator2.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by linheng on 14/11/2019.
 */
public class HolyPower extends WeaponDecorator {
    private static final Logger LOG = LoggerFactory.getLogger(HolyPower.class);

    public HolyPower(Weapon weapon) {
        super("holy", 10, weapon);
    }

    @Override
    protected void special(){
        super.special();
        LOG.info("special holy hit point 10");
    }
}
