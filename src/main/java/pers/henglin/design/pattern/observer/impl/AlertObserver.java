package pers.henglin.design.pattern.observer.impl;

public class AlertObserver implements Observer {
    private String userId;

    public AlertObserver(String userId){
        this.userId = userId;
    }

    @Override
    public void update(ObserverGenerator observerGenerator) {
        String message = (String) observerGenerator.getMessage();
        observerGenerator.log("[AlertObserver] userId: " + this.userId + " get message: " + message);
    }
}
