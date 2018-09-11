package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillService {

	List<Skill> getAllSkills();
	boolean createSkill(Skill skill);

}
