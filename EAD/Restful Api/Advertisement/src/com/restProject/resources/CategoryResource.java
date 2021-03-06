package com.restProject.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.restProject.enums.Status;
import com.restProject.facade.CategoryFacade;
import com.restProject.models.Category;

@Path("/CategoryResource")
public class CategoryResource {
	CategoryFacade categoryFacade=CategoryFacade.getInstance();
	
	/**
	 * getAllCategories -  get all category
	 * @return Response in form of json 
	 */
	@GET
	@Path("/GetAllCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategories() {
		System.out.println("asdsadds");
		List<Category> categoryList=categoryFacade.getAll();
		if(categoryList.size()==0){
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found").build();
		}
		else{
			Gson gson = new Gson();
			String categoryJson=gson.toJson(categoryList);
			return Response.ok(categoryJson, MediaType.APPLICATION_JSON).build();
		}
	}
	
	/**
	 * insertCategory - insert new Category
	 * @param category - new category
	 * @return Response 
	 */
	@POST
	@Path("/InsertCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCategory(Category category){
		if(category.getId()==0 || category.getCategoryName()==""){
			return Response.serverError().entity("Invalid Input").build();
		}else{
			Status status = categoryFacade.createCategory(category);
			String message = "";
			if(status==Status.CREATED){
				Gson gson = new Gson();
				message = gson.toJson(status.CREATED.toString());
				return Response.ok(message,MediaType.APPLICATION_JSON).build();
			}else{
				return Response.status(Response.Status.EXPECTATION_FAILED).build();
			}
		}
	}
	
	@PUT
	@Path("/UpdateCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(Category category){
		if(category.getId()==0 || category.getCategoryName()==""){
			return Response.serverError().entity("id could'nt be null").build();
		}else{
			if(isCategoryExist(category.getId())){
				Gson gson = new Gson();
				String message = gson.toJson(categoryFacade.updateCategory(category).toString());
				return Response.ok(message, MediaType.APPLICATION_JSON).build();
			}else{
				return Response.serverError().entity("id does not exist:").build();
			}
		}
	}
	
	/**
	 * To whether category is exist or not in database
	 * @param id - category id
	 * @return	true if exist else false
	 */
	private boolean isCategoryExist(int id){
		boolean isCategoryExistFlag = false;
		List<Category> listOfCategories = categoryFacade.getAll();
		for(Category category: listOfCategories){
			if(category.getId()==id){
				isCategoryExistFlag = true;
				break;
			}
		}
		return isCategoryExistFlag;
	}	
}