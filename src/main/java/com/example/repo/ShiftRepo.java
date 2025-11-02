package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Shift;

@Repository
public interface ShiftRepo extends CrudRepository<Shift, String> {

}
