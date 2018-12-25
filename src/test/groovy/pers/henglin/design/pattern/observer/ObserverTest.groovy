package pers.henglin.design.pattern.observer

import pers.henglin.design.pattern.observer.bean.Article
import pers.henglin.design.pattern.observer.impl.AlertObserver
import pers.henglin.design.pattern.observer.impl.ArticleObserverGenerator
import pers.henglin.design.pattern.observer.impl.NewsObserver
import pers.henglin.design.pattern.observer.impl.ObserverGenerator
import pers.henglin.design.pattern.observer.impl.StringObserverGenerator
import spock.lang.Specification

class ObserverTest extends Specification {
    def "test AlertObserver"() {
        setup:
        ObserverGenerator<String> stringObserverGenerator = new StringObserverGenerator()
        stringObserverGenerator.add(new AlertObserver("user 1"))
        stringObserverGenerator.add(new AlertObserver("user 2"))
        stringObserverGenerator.add(new AlertObserver("user 3"))

        when:
        stringObserverGenerator.sendMessage("message 1")
        stringObserverGenerator.sendMessage("message 2")

        then:
        stringObserverGenerator.getLog() == new File(getClass().getResource('/AlertObserver.txt').toURI()).text
    }

    def "test ArticleObserver"() {
        setup:
        ObserverGenerator<Article> articleObserverGenerator = new ArticleObserverGenerator()
        articleObserverGenerator.add(new NewsObserver("user 1"))
        articleObserverGenerator.add(new NewsObserver("user 2"))
        articleObserverGenerator.add(new NewsObserver("user 3"))

        when:
        articleObserverGenerator.sendMessage(new Article("title 1", "message 1"))
        articleObserverGenerator.sendMessage(new Article("title 2", "message 2"))
        articleObserverGenerator.sendMessage(new Article("title 3", "message 3"))

        then:
        articleObserverGenerator.getLog() == new File(getClass().getResource('/ArticleObserver.txt').toURI()).text
    }
}
