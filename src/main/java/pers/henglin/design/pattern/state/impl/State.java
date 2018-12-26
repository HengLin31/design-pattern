package pers.henglin.design.pattern.state.impl;

import pers.henglin.design.pattern.state.ThreadContext;

public interface State {
    void handle(ThreadContext context);
}
