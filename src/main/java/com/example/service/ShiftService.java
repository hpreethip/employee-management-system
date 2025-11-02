package com.example.service;

import org.springframework.stereotype.Repository;

import com.example.dto.ShiftRequest;
import com.example.dto.ShiftResponse;

@Repository
public interface ShiftService {

    ShiftResponse addShift(ShiftRequest req);

}
