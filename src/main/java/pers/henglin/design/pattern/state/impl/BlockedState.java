package pers.henglin.design.pattern.state.impl;

import pers.henglin.design.pattern.state.ThreadContext;

public class BlockedState implements State {
    @Override
    public void handle(ThreadContext context) {
        context.log("[state] blocked...");
        context.setState(new ReadyState());
    }
}
