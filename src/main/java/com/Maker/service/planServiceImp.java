package com.Maker.service;



import com.Maker.dao.PlansRepo;
import com.Maker.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class planServiceImp implements planService {

    @Autowired
    private PlansRepo planRepo;


    @Override
    public Plan addPlan(Plan plan) {
        return planRepo.save(plan);
    }

    @Override
    public Plan getPlan(String name) {
        return  planRepo.findByPName(name);
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepo.findAll();
    }

}
