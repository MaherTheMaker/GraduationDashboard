package com.Maker.controller;

import com.Maker.model.Plan;
import com.Maker.service.planService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")

public class planAPI {

    @Autowired
    private planService planService;

    @GetMapping("/all")
    public ResponseEntity<List<Plan>>getPlans(){
        return ResponseEntity.ok().body(planService.getAllPlans());
    }

    @PostMapping("/save")
    public ResponseEntity<Plan> addPlan(@RequestBody Plan plan){
        return ResponseEntity.ok().body(planService.addPlan(plan));
    }

    @GetMapping("/getPlan/{pName}")
    public ResponseEntity<Plan> getPlan(@PathVariable String pName){
        return ResponseEntity.ok().body(planService.getPlan(pName));
    }


}
