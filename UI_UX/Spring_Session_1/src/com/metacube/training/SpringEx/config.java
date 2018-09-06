package com.metacube.training.SpringEx;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.training.SpringEx.contructorAnnotation.SpellChecker;
import com.metacube.training.SpringEx.contructorAnnotation.TextEditor;

@Configuration
public class config {
	
	@Bean
	public TextEditor getTextEditor(){
		return new TextEditor(getSpellChecker(),"jitendra");
	}
	
	@Bean
	public SpellChecker getSpellChecker(){
		return new SpellChecker();
	}
	
}
