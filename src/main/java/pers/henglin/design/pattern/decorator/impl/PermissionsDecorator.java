package pers.henglin.design.pattern.decorator.impl;

import pers.henglin.design.pattern.decorator.PermissionsConstant;

public abstract class PermissionsDecorator implements Permissions {
    @Override
    public String id() {
        return PermissionsConstant.UNKNOWN_ID;
    }

    @Override
    public int open() {
        return PermissionsConstant.UNKNOWN;
    }
}
