package pers.henglin.design.pattern.proxy.impl;

import com.google.gson.Gson;
import pers.henglin.design.pattern.Constant;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogHandler implements InvocationHandler {
    private static final String BEFORE = "before";
    private static final String AFTER = "after";

    private Gson gson = new Gson();
    private StringBuilder log = new StringBuilder();
    private Object delegate;

    public Object bind(Object delegate){
        this.delegate = delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        appendLog(BEFORE, method, args);
        Object result = method.invoke(delegate, args);
        appendLog(AFTER, method, args);
        return result;
    }

    public String getLog(){
        return log.toString();
    }

    private void appendLog(String prefix, Method method, Object[] args){
        this.log.append(prefix)
                .append(" invoke method: ")
                .append(method.getName())
                .append(", param: ")
                .append(gson.toJson(args))
                .append(Constant.NEW_LINE);
    }
}
