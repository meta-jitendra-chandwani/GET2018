package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.SkillDAO;
import com.metacube.training.model.Skill;
import com.metacube.training.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	SkillDAO skillDAO;

	@Override
	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}

	@Override
	public void createSkill(Skill skill) {
		skillDAO.createSkill(skill);
	}
}