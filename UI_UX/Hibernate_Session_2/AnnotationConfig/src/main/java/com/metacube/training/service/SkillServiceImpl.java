package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;
import com.metacube.training.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
    private SkillRepository<Skill> skillRepository;

	@Override
	public List<Skill> getAllSkills() {
		return (List<Skill>) skillRepository.findAll();
	}

	@Override
	public void createSkill(Skill skill) {
		skillRepository.save(skill);
	}
}