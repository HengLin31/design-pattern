package pers.henglin.design.pattern.decorator.impl;

import pers.henglin.design.pattern.Constant;
import pers.henglin.design.pattern.decorator.PermissionsConstant;

public class Update extends PermissionsDecorator {
    private Permissions permissions;

    public Update(Permissions permissions) {
        this.permissions = permissions;
    }

    @Override
    public String id() {
        return this.permissions.id() + Constant.NODE_NEXT_POINT + PermissionsConstant.UPDATE_ID;
    }

    @Override
    public int open() {
        return this.permissions.open() | PermissionsConstant.UPDATE;
    }
}
