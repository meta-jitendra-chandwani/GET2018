package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EmployeePortal.model.Skill;

public interface SkillDAO {

	List<Skill> getAllSkills();
	boolean createSkill(Skill skill);

}
