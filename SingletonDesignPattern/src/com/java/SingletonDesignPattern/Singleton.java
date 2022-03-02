package com.java.SingletonDesignPattern;

public class Singleton {

	private String str;
	private static Singleton obj = null;

	private Singleton() {
		str = "Hello I am a String part of Singleton Class.";
	}
	
	public static Singleton getInstance() {
		if(obj == null) {
			obj = new Singleton();
		}
		return obj;
	}

	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		System.out.println("singleton1: "+singleton1.hashCode());
		System.out.println("singleton2: "+singleton2.hashCode());
	}

}
