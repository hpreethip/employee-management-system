package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Skill;

@Repository
public interface SkillRepo extends CrudRepository<Skill, String> {

}
