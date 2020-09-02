package com.kn.test.reflect;

/**
 * 静态代理
 */
public class StaticPrinterProxy implements IPrinter {

    private IPrinter iPrinter;

    public StaticPrinterProxy() {
        //父类引用指向子类对象（多态）
        this.iPrinter = new Printer();
    }

   //静态代理
    @Override
    public void print() {
        System.out.println("打印前事件处理？？？");
        iPrinter.print();
        System.out.println("打印后事件处理？？？");
    }

}
