package com.Maker.service;


import com.Maker.model.Clinic;
import com.Maker.model.PendingRequest;
import com.Maker.model.Plan;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public interface clinicService {

    Clinic addClinic(Clinic clinic) throws IOException;
    PendingRequest requestForPlan(String username,int pId);
    List<Clinic> getAllClinics();

    Clinic getClinic(String name);

//    Clinic SetDomainName(String username, String domainName);

    Plan getActPlan(String username);


    Clinic editClinic(String username,Clinic clinic);



}
