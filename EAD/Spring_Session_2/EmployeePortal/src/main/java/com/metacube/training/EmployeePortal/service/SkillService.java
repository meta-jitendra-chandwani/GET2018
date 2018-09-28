package com.metacube.training.EmployeePortal.service;

import java.util.List;

import com.metacube.training.EmployeePortal.model.Skill;

public interface SkillService {

	List<Skill> getAllSkills();
	boolean createSkill(Skill skill);

}
