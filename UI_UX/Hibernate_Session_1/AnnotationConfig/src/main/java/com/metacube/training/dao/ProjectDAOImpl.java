package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	/*
	 * @Autowired public ProjectDAOImpl(DataSource dataSource) { jdbcTemplate =
	 * new JdbcTemplate(dataSource); }
	 */

	public Project getProjectById(Long id) {
		System.out.println("======project id ke undr=====");
		Query<Project> query = sessionFactory.getCurrentSession().createQuery(
				"from Project where id = :id");
		query.setParameter("id", id);
		Project project = query.uniqueResult();
		return project;
	}

	public List<Project> getAllProjects() {
		System.out.println("======project all ke undr=====");
		session = sessionFactory.openSession();
		TypedQuery<Project> query = session.createQuery("FROM Project");
		List<Project> result = query.getResultList();
		session.close();
		return result;
	}

	public boolean deleteProject(Project person) {
		System.out.println("======project delete ke undr=====");
		session = sessionFactory.openSession();
		TypedQuery<Project> query = session
				.createQuery("delete from project where id = :id");
		query.setParameter(1, person.getId());
		return query.executeUpdate() > 0;
	}

	public boolean updateProject(Project person) {
		System.out.println("======project update ke undr=====");
		session = sessionFactory.openSession();
		TypedQuery<Project> query = session
				.createQuery("update project set name = :name, description = :description, start_date  = :start_date, end_date  = :end_date where id = :id");
		query.setParameter(1, person.getName());
		query.setParameter(2, person.getDescription());
		query.setParameter(3, person.getStartDate());
		query.setParameter(4, person.getEndDate());
		query.setParameter(5, person.getId());
		return query.executeUpdate() > 0;
	}

	public void createProject(Project person) {
		System.out.println("======project create ke undr=====");
		sessionFactory.getCurrentSession().save(person);
	}

}