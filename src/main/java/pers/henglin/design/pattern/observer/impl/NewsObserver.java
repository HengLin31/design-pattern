package pers.henglin.design.pattern.observer.impl;

import pers.henglin.design.pattern.observer.bean.Article;

public class NewsObserver implements Observer {
    private String userId;

    public NewsObserver(String userId){
        this.userId = userId;
    }

    @Override
    public void update(ObserverGenerator observerGenerator) {
        Article message = (Article) observerGenerator.getMessage();
        observerGenerator.log("[NewsObserver] userId: " + this.userId + " get msg: " + message.toString());
    }
}
