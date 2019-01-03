package pers.henglin.design.pattern.decorator.impl;

import pers.henglin.design.pattern.Constant;
import pers.henglin.design.pattern.decorator.PermissionsConstant;

public class Delete extends PermissionsDecorator {
    private Permissions permissions;

    public Delete(Permissions permissions) {
        this.permissions = permissions;
    }

    @Override
    public String id() {
        return this.permissions.id() + Constant.NODE_NEXT_POINT + PermissionsConstant.DELETE_ID;
    }

    @Override
    public int open() {
        return this.permissions.open() | PermissionsConstant.DELETE;
    }
}
