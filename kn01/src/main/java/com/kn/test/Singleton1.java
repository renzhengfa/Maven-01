package com.kn.test;

//饿汉式单例类.在加载类时实例化自己
public class Singleton1 {

    private Singleton1() {}

    /**
     * 当final修饰一个基本数据类型时，表示该基本数据类型的值一旦在初始化后便不能发生变化；
     * 如果final修饰一个引用类型时，则在对其初始化之后便不能再让其指向其他对象了，但该引用所指向的对象的内容是可以发生变化的。
     * 本质上是一回事，因为引用的值是一个地址，final要求值，即地址的值不发生变化。
     */
    private static final Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getInstance() {
        synchronized (Singleton1.class){
            return singleton1;
        }
    }

}
