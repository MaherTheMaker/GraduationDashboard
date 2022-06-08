package com.Maker.service;

import com.Maker.model.Plan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface planService {

    Plan addPlan(Plan plan);
    Plan getPlan(String name);
    List<Plan> getAllPlans();
}
