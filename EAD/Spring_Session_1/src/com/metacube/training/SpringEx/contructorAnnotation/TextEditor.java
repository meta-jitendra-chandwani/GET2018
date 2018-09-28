package com.metacube.training.SpringEx.contructorAnnotation;

/**
 * class containing methods for texteditor functionality
 * created on September 04, 2018
 */
public class TextEditor {
	
	private SpellChecker spellChecker = null;
	private String word = "";
	
	public TextEditor(SpellChecker spellChecker,String word) {
		this.spellChecker = spellChecker;
		this.word = word;
	}
	
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	
	public String getWord() {
		return word;
	}
	
	
	public void check() {
		System.out.println(spellChecker.checkSpelling()+" of "+getWord());
	}
	
}