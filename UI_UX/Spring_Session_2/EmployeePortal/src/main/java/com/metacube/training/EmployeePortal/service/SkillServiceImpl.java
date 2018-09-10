package com.metacube.training.EmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortal.dao.SkillDAO;
import com.metacube.training.EmployeePortal.model.Skill;
import com.metacube.training.EmployeePortal.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	SkillDAO skillDAO;

	@Override
	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}

	@Override
	public boolean createSkill(Skill skill) {
		return skillDAO.createSkill(skill);
		
	}

}
