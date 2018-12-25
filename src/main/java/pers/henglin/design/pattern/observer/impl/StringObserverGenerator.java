package pers.henglin.design.pattern.observer.impl;

public class StringObserverGenerator extends ObserverGenerator<String> {
    private String message;

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
