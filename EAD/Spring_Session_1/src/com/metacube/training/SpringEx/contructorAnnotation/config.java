package com.metacube.training.SpringEx.contructorAnnotation;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.training.SpringEx.contructorAnnotation.SpellChecker;
import com.metacube.training.SpringEx.contructorAnnotation.TextEditor;

@Configuration
public class config {
	
	@Bean(name="texteditor")
	public TextEditor getTextEditor(){
		return new TextEditor(getSpellChecker(),"jitendra");
	}
	
	@Bean(name="spellChecker")
	public SpellChecker getSpellChecker(){
		return new SpellChecker();
	}
	
}
