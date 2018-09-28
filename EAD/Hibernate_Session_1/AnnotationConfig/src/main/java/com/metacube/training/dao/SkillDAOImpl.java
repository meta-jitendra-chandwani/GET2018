package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Skill;

@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final String GET_ALL_Skill_Query = "from Skill";

	
	@Override
	public List<Skill> getAllSkills() {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession()
				.createQuery(GET_ALL_Skill_Query);
		return query.getResultList();
	}

	@Override
	public void createSkill(Skill skill) {
		sessionFactory.getCurrentSession().save(skill);
	}
}