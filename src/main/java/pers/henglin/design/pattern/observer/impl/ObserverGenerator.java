package pers.henglin.design.pattern.observer.impl;

import pers.henglin.design.pattern.Constant;

import java.util.concurrent.LinkedBlockingQueue;

public abstract class ObserverGenerator<T> {
    private LinkedBlockingQueue<Observer> observers;
    private StringBuffer log;

    public ObserverGenerator(){
        this.observers = new LinkedBlockingQueue<>();
        this.log = new StringBuffer();
    }

    public void add(Observer observer){
        this.observers.add(observer);
    }

    public void remove(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer : this.observers){
            observer.update(this);
        }
    }

    public void sendMessage(T message){
        setMessage(message);
        notifyObservers();
    }

    public void log(String logMessage){
        this.log.append(logMessage).append(Constant.NEW_LINE);
    }

    public String getLog(){
        return this.log.toString();
    }

    protected abstract T getMessage();
    protected abstract void setMessage(T message);
}
