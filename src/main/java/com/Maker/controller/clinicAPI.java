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

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clinic")
public class clinicAPI {

    @Autowired
    private  clinicService  clinicService;

    @Autowired
    private ClinicRepo clinicRepo;





    @PostMapping("/requestForPlan")
    public ResponseEntity<PendingRequest> requestPlan(@RequestBody pendingRequestFrom form){
        System.out.println(form.getUsername() + form.getPlanId());
            return ResponseEntity.ok().body(clinicService.requestForPlan(form.getUsername(),form.getPlanId()));
    }


    @PostMapping("/getClinic/{username}")
    public ResponseEntity<Clinic> getPlan(@PathVariable String username){
       return ResponseEntity.ok().body(clinicService.getClinic(username));
    }

    @PostMapping("/editClinic/{username}")
    public ResponseEntity<Clinic> editClinic(@PathVariable String username , @RequestBody Clinic clinic){
        return ResponseEntity.ok().body(clinicService.editClinic(username, clinic));
    }

    @PostMapping("/CreateClinic")
    public ResponseEntity<Clinic> addClinic(@RequestBody Clinic clinic) throws IOException {
        return ResponseEntity.ok().body(clinicService.addClinic(clinic));
    }

}


@Data
class pendingRequestFrom
{
    private String username;
    private int planId;
}




