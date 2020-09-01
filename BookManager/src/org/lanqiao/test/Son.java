package org.lanqiao.test;

public class Son extends Father {

	@Override
	public void say() {
		System.out.println("son say");
	}
	
	public static void main(String[] args) {
		Father fa = new Son();
		fa.say();
		fa.test1();
	}
	
	public void test() {
		System.out.println("son test");
	}
	
}
