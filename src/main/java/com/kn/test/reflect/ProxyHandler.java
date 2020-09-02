package com.kn.test.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

    //被代理对象
    private Object obj;

    //将被代理的对象传入获得它的类加载器和实现接口作为Proxy.newProxyInstance方法的参数。
    public Object newProxyInstance(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),this);
    }

    //动态代理
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理之前的事情
        System.out.println("动态代理前面处理事务！！！");
        return method.invoke(obj, args);
    }

}
