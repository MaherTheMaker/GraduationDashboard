package com.Maker.controller;
import com.Maker.cmd_prompt.my_main;
import com.Maker.dao.ClinicPlanRepository;
import com.Maker.dao.ClinicRepo;
import com.Maker.dao.PendingRequestRepo;
import com.Maker.model.*;
import com.Maker.service.ClinicPlansService;
import com.Maker.service.clinicService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
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
    private ResponseEntity<ClinicPlan> confirmRequest (@PathVariable int id , @PathVariable boolean activate) throws IOException {
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







    @GetMapping("/getClinic/{username}")
    public ResponseEntity<Clinic> getPlan(@PathVariable String username){
        return ResponseEntity.ok().body(clinicService.getClinic(username));
    }




    @GetMapping("/clinicPlansHistory/{username}")
    public ResponseEntity<List<ClinicPlan>> getPlansHistory(@PathVariable String username){
        return ResponseEntity.ok().body(clinicPlansService.getHistoryPlans(username));
    }

    @GetMapping("/Deploy/{username}")
    public String Deploy(@PathVariable String username) throws IOException {
//        my_main.RunDeploy(username);
        return "Done";
    }

}

@Data
class DomainName {
    String domainName;
        }
