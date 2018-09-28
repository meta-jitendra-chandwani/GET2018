package com.metacube.training.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Skill;

@Repository
@Transactional
public interface SkillRepository<P> extends CrudRepository<Skill, Integer> {

}
