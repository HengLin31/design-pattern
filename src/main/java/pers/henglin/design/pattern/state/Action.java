package pers.henglin.design.pattern.state;

import java.util.Random;

public enum Action {
    TERMINATION, IO, TIMEOUT;

    public static Action random(){
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
