package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillDAO {
	
	List<Skill> getAllSkills();
	void createSkill(Skill skill);

}