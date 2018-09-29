package com.metacube.training.SpringEx.constructorAnnotationAutowire;

public class SpellChecker {
	String name;

	public SpellChecker(String name) {
		super();
		this.name = name;
	}

	public String checkSpelling() {
		return "HI " + name + "Checking spelling";
	}

}
