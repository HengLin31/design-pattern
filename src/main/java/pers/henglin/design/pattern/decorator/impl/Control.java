package pers.henglin.design.pattern.decorator.impl;

import pers.henglin.design.pattern.decorator.PermissionsConstant;

public class Control implements Permissions {
    @Override
    public String id() {
        return PermissionsConstant.CONTROL_ID;
    }

    @Override
    public int open() {
        return PermissionsConstant.UNKNOWN;
    }
}
