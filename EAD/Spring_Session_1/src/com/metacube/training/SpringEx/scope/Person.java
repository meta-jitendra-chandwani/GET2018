package com.metacube.training.SpringEx.scope;

public class Person {
	private int age;

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	public void show(){
		System.out.println("Person - Age : "+ age);
	}
}
