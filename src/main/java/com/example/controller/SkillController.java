package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.RequestUri;
import com.example.dto.SkillRequest;
import com.example.dto.SkillResponse;
import com.example.service.SkillService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping(value = RequestUri.SKILL, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SkillResponse> createSkill(@RequestBody SkillRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(skillService.createSkill(req));
    }

}
