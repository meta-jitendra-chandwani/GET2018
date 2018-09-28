package com.restProject.factory;

import com.restProject.dao.BaseDao;
import com.restProject.dao.MySQLAdvertismentDao;
import com.restProject.dao.MySQLCategoryDao;
import com.restProject.enums.DBType;
import com.restProject.enums.EntityName;

public class DaoFactory {
	public static BaseDao getDaoForEntity(DBType dbName, EntityName entity) {
		BaseDao baseDao = null;

		switch (entity) {
		case ADVERTISMENT:
			switch (dbName) {
			case MY_SQL:
				baseDao = MySQLAdvertismentDao.getInstance();
				break;
			default:
				break;
			}
			break;
		case CATEGORY:
			switch (dbName) {
			case MY_SQL:
				baseDao = MySQLCategoryDao.getInstance();
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		return baseDao;
	}
}