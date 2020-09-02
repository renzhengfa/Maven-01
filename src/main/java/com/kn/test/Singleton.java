package com.kn.test;

//懒汉式单例类.在调用的时候才实例化自己
 public class Singleton {

    /**
     * 所有的对象实现实例化都是走的构造方法,类默认有一个无参构造方法,要使用有参构造方法必须自己定义,
     * 故我们将无参构造方法私有化了,外部对象无法调用构造方法了从而实现单例模式。
     * 构造方法私有化,其它类无法访问到该构造方法
     */
     private Singleton(){}

     private static Singleton singleton = null;

     //静态工厂
    public static Singleton getInstance(){
        if (singleton == null){
            return new Singleton();
        }
        return singleton;
    }

}
