package pers.henglin.design.pattern.decorator;

public class PermissionsConstant {
    public static final int UNKNOWN = 0;//0000
    public static final int CREATE = 1; //0001
    public static final int READ = 2;   //0010
    public static final int UPDATE = 4; //0100
    public static final int DELETE = 8; //1000

    public static final String CONTROL_ID = "control";
    public static final String UNKNOWN_ID = "unknown";
    public static final String CREATE_ID = "create";
    public static final String READ_ID = "read";
    public static final String UPDATE_ID = "update";
    public static final String DELETE_ID = "delete";
}
