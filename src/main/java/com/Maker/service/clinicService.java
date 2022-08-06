package com.Maker.service;


import com.Maker.model.Clinic;
import com.Maker.model.PendingRequest;
import com.Maker.model.Plan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface clinicService {

    Clinic addClinic(Clinic clinic);
    PendingRequest requestForPlan(String username,String pName);
    List<Clinic> getAllClinics();

    Clinic getClinic(String name);

//    Clinic SetDomainName(String username, String domainName);

    Plan getActPlan(String username);



}
