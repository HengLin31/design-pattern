package pers.henglin.design.pattern.state;

import pers.henglin.design.pattern.Constant;
import pers.henglin.design.pattern.state.impl.CreateState;
import pers.henglin.design.pattern.state.impl.State;

import java.util.List;

public class ThreadContext {
    private StringBuilder log;
    private State state;
    private boolean isFinish;

    private int actionIndex;
    private List<Action> actions;

    public ThreadContext(List<Action> actions){
        this.log = new StringBuilder();
        this.state = new CreateState();
        this.isFinish = false;

        this.actionIndex = 0;
        this.actions = actions; //if (null == actions) then use random
    }

    public void log(String logMessage){
        this.log.append(logMessage).append(Constant.NEW_LINE);
    }

    public String getLog(){
        return this.log.toString();
    }

    public void change(){
        this.state.handle(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setIsFinish(boolean isFinish) {
        this.isFinish = isFinish;
    }

    public List<Action> getActions(){
        return actions;
    }

    public Action nextAction(){
        if(actionIndex < actions.size()){
            return actions.get(actionIndex++);
        }
        return Action.TERMINATION;
    }
}
