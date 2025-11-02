package com.example.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.example.constant.SkillName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
@Table
public class Skill {

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name", unique = true)
    @Enumerated(EnumType.STRING)
    private SkillName name;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "created_at")
    private ZonedDateTime CreatedAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

}
