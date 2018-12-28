package pers.henglin.design.pattern.proxy.impl;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<String> getKeys();
    Optional<String> getValue(String key);
}
