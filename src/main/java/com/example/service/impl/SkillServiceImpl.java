package com.example.service.impl;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.SkillRequest;
import com.example.dto.SkillResponse;
import com.example.model.Skill;
import com.example.repo.SkillRepo;
import com.example.service.SkillService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public SkillResponse createSkill(SkillRequest req) {

        Skill s = new Skill();
        s.setName(req.getName());
        s.setRate(req.getRate());
        s.setCreatedAt(ZonedDateTime.now());
        s.setUpdatedAt(ZonedDateTime.now());
        s = skillRepo.save(s);

        return objectMapper.convertValue(s, SkillResponse.class);
    }

}
