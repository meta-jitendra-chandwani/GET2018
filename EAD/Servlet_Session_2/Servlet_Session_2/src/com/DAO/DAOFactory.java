package com.DAO;

public class DAOFactory {
	public static BaseDao getDaoForEntity() {
        BaseDao baseDao=null ;
        //= InMemoryProductDao.getInstance();
                      
        return baseDao;
    }
}
