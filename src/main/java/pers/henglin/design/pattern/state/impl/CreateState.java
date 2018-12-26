package pers.henglin.design.pattern.state.impl;

import pers.henglin.design.pattern.state.ThreadContext;

public class CreateState implements State {
    @Override
    public void handle(ThreadContext context) {
        context.log("[state] create...");
        context.setState(new ReadyState());
    }
}
