package com.metacube.training.SpringEx.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
public static void main(String[] args) {
		
		ApplicationContext applicationContextSingleton = new ClassPathXmlApplicationContext("personSingleton.xml");
		ApplicationContext applicationContextPrototype = new ClassPathXmlApplicationContext("personPrototype.xml");

		System.out.println("Singleton\n");
		Person person = (Person)applicationContextSingleton.getBean("person");
		person.show();
		person.setAge(21);
		Person person1 = (Person)applicationContextSingleton.getBean("person");
		person1.show();
		System.out.println("\nPrototype\n");
		Person person2 = (Person)applicationContextPrototype.getBean("person");
		person2.show();
		person.setAge(21);
		Person person3 = (Person)applicationContextPrototype.getBean("person");
		person3.show();			
		
	}

}
