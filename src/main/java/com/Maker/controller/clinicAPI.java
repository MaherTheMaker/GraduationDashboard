package com.Maker.controller;



import com.Maker.dao.ClinicRepo;
import com.Maker.model.Clinic;

import com.Maker.model.PendingRequest;
import com.Maker.service.clinicService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clinic")
public class clinicAPI {

    @Autowired
    private  clinicService  clinicService;

    @Autowired
    private ClinicRepo clinicRepo;




    //Todo WebService
    @PostMapping("/requestForPlan")
    public ResponseEntity<PendingRequest> requestPlan(@RequestBody pendingRequestFrom form){
            return ResponseEntity.ok().body(clinicService.requestForPlan(form.getUsername(),form.getPlanName()));
    }

    //Todo WebService
    @PostMapping("/getClinic/{username}")
    public ResponseEntity<Clinic> getPlan(@PathVariable String username){
       return ResponseEntity.ok().body(clinicService.getClinic(username));
    }



}


@Data
class pendingRequestFrom
{
    private String username;
    private String planName;
}




