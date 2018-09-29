package com.metacube.training.SpringEx.contructorAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);

		TextEditor textEditor = (TextEditor) ctx.getBean("texteditor");
		textEditor.check();
	}
}