package com.kn.test.reflect;

public class TestProxy {

    public static void main(String[] args) {
        //测试静态代理
        StaticPrinterProxy proxy = new StaticPrinterProxy();
        proxy.print();

        System.out.println("-------------------------------------------------");
        ProxyHandler proxyHandler = new ProxyHandler();
        IPrinter printer = (IPrinter) proxyHandler.newProxyInstance(new Printer());
        printer.print();

    }

}
