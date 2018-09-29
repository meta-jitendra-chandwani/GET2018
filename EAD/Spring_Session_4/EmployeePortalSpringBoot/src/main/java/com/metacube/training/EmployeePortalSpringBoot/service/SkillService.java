package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Skill;

public interface SkillService {

	List<Skill> getAllSkills();
	boolean createSkill(Skill skill);

}
