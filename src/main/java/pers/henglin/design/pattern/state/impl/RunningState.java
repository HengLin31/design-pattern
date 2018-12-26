package pers.henglin.design.pattern.state.impl;

import pers.henglin.design.pattern.state.Action;
import pers.henglin.design.pattern.state.ThreadContext;

public class RunningState implements State {
    @Override
    public void handle(ThreadContext context) {
        context.log("[state] running...");
        Action action = getAction(context);
        switch(action){
            case TERMINATION:
                context.log("[action] termination...");
                context.setState(new FinishState());
                break;
            case TIMEOUT:
                context.log("[action] timeout...");
                context.setState(new ReadyState());
                break;
            case IO:
                context.log("[action]  I/O...");
                context.setState(new BlockedState());
                break;
        }
    }

    private Action getAction(ThreadContext context){
        if(null != context.getActions()){
            return context.nextAction();
        }
        return Action.random();
    }
}
