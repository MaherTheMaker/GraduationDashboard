package com.Maker.controller;

import com.Maker.dao.ClinicDomainRepo;
import com.Maker.dao.ClinicPlanRepository;
import com.Maker.dao.ClinicRepo;
import com.Maker.dao.PendingRequestRepo;
import com.Maker.model.*;
import com.Maker.service.ClinicDomainService;
import com.Maker.service.ClinicPlansService;
import com.Maker.service.clinicService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping("/clinicPlan")
public class AdminAPI {


    @Autowired
    private ClinicPlansService clinicPlansService;

    @Autowired
    private ClinicPlanRepository clinicPlanRepository;

    @Autowired
    private ClinicRepo clinicRepo;


    @Autowired
    private clinicService clinicService;

    @Autowired
    private ClinicPlanRepository clinicPlanRepo;

    @Autowired
    private PendingRequestRepo pendingRequestRepo;


    @Autowired
    private ClinicDomainService clinicDomainService;


    @GetMapping("/all")
    private ResponseEntity<List<ClinicPlan>> getAllClinicPlan () {
        return ResponseEntity.ok().body(clinicPlansService.getAllClinicPlan());
    }



    @PostMapping("/add")
    private ResponseEntity<ClinicPlan> addClinicPlan (@RequestBody ClinicPlan clinicPlan) {
        return ResponseEntity.ok().body(clinicPlansService.addClinicPlan(clinicPlan));
    }


    @GetMapping("/getPendingRequest")
    private ResponseEntity<List<PendingRequest>> getPendingRequest ()
    {
        return ResponseEntity.ok().body(pendingRequestRepo.findAll());
    }

    @PostMapping("/confirm/{id}/{activate}")
    private ResponseEntity<ClinicPlan> confirmRequest (@PathVariable int id , @PathVariable boolean activate) {
        return ResponseEntity.ok().body(clinicPlansService.confirmRequest(id,activate));
    }


    @GetMapping("/activePLan/{clinicUsername}")
    private ResponseEntity<Plan> getActPlan(@PathVariable String clinicUsername){
        return ResponseEntity.ok().body(clinicService.getActPlan(clinicUsername));
    }

    @GetMapping("/getPlansClinic/{id}")
    private ResponseEntity<List<Plan>> getClinicPlan(@PathVariable int id )
    {

        Clinic clinic = clinicRepo.findById(id);
        int i = 0 ;
        List<Plan> plans  = new ArrayList<>();
        List<ClinicPlan> clinicPlansList = new ArrayList<>();
        clinicPlansList = clinicPlanRepository.findAllByClinic(clinic);
        while (i <= clinicPlansList.size()-1)
        {
            plans.add(clinicPlansList.get(i).getPlan());
            i++;
        }
        return ResponseEntity.ok().body(plans);
    }




    @PostMapping("/CreateClinic")
    public ResponseEntity<Clinic> addClinic(@RequestBody Clinic clinic){
        return ResponseEntity.ok().body(clinicService.addClinic(clinic));
    }



    @GetMapping("/getClinic/{username}")
    public ResponseEntity<Clinic> getPlan(@PathVariable String username){
        return ResponseEntity.ok().body(clinicService.getClinic(username));
    }


    @GetMapping("/addDomainToClinic/{username}")
    public ResponseEntity<ClinicDomain> setDomain(@PathVariable String username,@RequestBody ClinicDomain clinicDomain)
    {
       Clinic clinic = clinicRepo.findByUsername(username);
       clinicDomain.setClinic(clinic);
       return ResponseEntity.ok().body(clinicDomainService.addDomain(clinicDomain));

    }

    @GetMapping("/clinicDomain/{username}")
    public ResponseEntity<ClinicDomain> getDomain(@PathVariable String username){

        return ResponseEntity.ok().body(clinicDomainService.getClinicDomain(username));
    }



    @GetMapping("/clinicPlansHistory/{username}")
    public ResponseEntity<List<ClinicPlan>> getPlansHistory(@PathVariable String username){
        return ResponseEntity.ok().body(clinicPlansService.getHistoryPlans(username));
    }
    
}
