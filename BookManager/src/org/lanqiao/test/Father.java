package org.lanqiao.test;

public class Father {

	public void say() {
		System.out.println("father say");
	}
	
	public static void main(String[] args) {
		Father fa = new Son();
		fa.say();
		fa.test1();
	}
	
	public void test1() {
		System.out.println("father test1");
	}
	
}
