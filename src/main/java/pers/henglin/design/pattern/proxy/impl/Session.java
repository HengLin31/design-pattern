package pers.henglin.design.pattern.proxy.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Session implements Service {
    private final ConcurrentHashMap<String, String> cache;

    public Session(Map<String, String> params){
        this.cache = new ConcurrentHashMap<>(params);
    }

    @Override
    public List<String> getKeys() {
        return Collections.list(cache.keys());
    }

    @Override
    public Optional<String> getValue(String key) {
        if(!cache.containsKey(key)){
            return Optional.empty();
        }
        return Optional.of(cache.get(key));
    }
}
