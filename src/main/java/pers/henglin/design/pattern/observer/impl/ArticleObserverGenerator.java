package pers.henglin.design.pattern.observer.impl;

import pers.henglin.design.pattern.observer.bean.Article;

public class ArticleObserverGenerator  extends ObserverGenerator<Article> {
    private Article article;

    @Override
    public Article getMessage() {
        return this.article;
    }

    @Override
    public void setMessage(Article message) {
        this.article = message;
    }
}
