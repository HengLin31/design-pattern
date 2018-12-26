package pers.henglin.design.pattern.state.impl;

import pers.henglin.design.pattern.state.ThreadContext;

public class FinishState implements State {
    @Override
    public void handle(ThreadContext context) {
        context.log("[state] finish.");
        context.setIsFinish(true);
    }
}
