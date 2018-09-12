package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.JobTitleDAO;
import com.metacube.training.model.JobTitle;



@Repository
@Transactional
public class JobTitleDAOImpl implements JobTitleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_DELETE_JOB_TITLE = "delete from JobTitle where job_id = :job_id";
	private final String SQL_UPDATE_JOB_TITLE = "update JobTitle set job_title = :job_title where job_id = :job_id";
	private final String SQL_GET_ALL = "from JobTitle";
	private final String SQL_GET_JOB_BY_ID = "from JobTitle WHERE job_id = :job_id ";

	@Override
	public List<JobTitle> getAllJobTitle() {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	@Override
	public boolean deleteJobTitle(int id) {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_DELETE_JOB_TITLE);
		query.setParameter("job_id", id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_JOB_TITLE);
		query.setParameter("job_title", jobTitle.getJobTitle());
		query.setParameter("job_id", jobTitle.getId());
		return (query.executeUpdate() > 0);

	}

	@Override
	public void createJobTitle(JobTitle jobTitle) {
		sessionFactory.getCurrentSession().save(jobTitle);
	}

	@Override
	public JobTitle getJobTitleById(int id) {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_JOB_BY_ID);
		query.setParameter("job_id", id);
		return query.getSingleResult();
	
	}
}