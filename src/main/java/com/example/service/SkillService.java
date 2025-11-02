package com.example.service;

import org.springframework.stereotype.Repository;

import com.example.dto.SkillRequest;
import com.example.dto.SkillResponse;

@Repository
public interface SkillService {

    SkillResponse createSkill(SkillRequest req);

}
