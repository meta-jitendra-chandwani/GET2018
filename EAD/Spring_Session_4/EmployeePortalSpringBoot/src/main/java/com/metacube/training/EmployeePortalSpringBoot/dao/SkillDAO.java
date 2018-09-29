package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Skill;

public interface SkillDAO {
	
	List<Skill> getAllSkills();
	boolean createSkill(Skill skill);
}