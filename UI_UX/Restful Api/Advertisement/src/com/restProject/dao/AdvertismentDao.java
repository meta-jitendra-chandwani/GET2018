package com.restProject.dao;

import java.util.List;

import com.restProject.models.Advertisment;

public interface AdvertismentDao extends BaseDao<Advertisment> {
	public List<Advertisment> GetByCategoryId(int category_id);
	public boolean deleteAdvertisment(int id);
	
}