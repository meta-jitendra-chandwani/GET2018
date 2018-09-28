package com.restProject.facade;

import java.util.List;

import com.restProject.enums.Status;
import com.restProject.models.Category;
import com.restProject.service.CategoryServices;

public class CategoryFacade {
	private static CategoryFacade categoryFacade = new CategoryFacade();
	private CategoryServices categoryServices = CategoryServices.getInstance();
	
	public static CategoryFacade getInstance(){
		return categoryFacade;
	}
	
	public List<Category> getAll(){
		return categoryServices.getAllCategories();
	}
	
	public Status createCategory(Category category){
		return categoryServices.createCategory(category);
	}
	
	public Status updateCategory(Category category){
		return categoryServices.updateCategory(category);
	}
	
}