package pers.henglin.design.pattern.state.impl;

import pers.henglin.design.pattern.state.ThreadContext;

public class ReadyState implements State {
    @Override
    public void handle(ThreadContext context) {
        context.log("[state] ready...");
        context.setState(new RunningState());
    }
}
