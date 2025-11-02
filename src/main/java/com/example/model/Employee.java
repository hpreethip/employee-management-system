package com.example.model;

import java.time.ZonedDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
@Table
public class Employee {

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "contract_type_id")
    private String contractTypeId;

    @Column(name = "shift_ids")
    private List<String> shiftIds;

    @Column(name = "created_at")
    private ZonedDateTime CreatedAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

}
