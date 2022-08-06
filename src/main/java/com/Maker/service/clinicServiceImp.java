package com.Maker.service;



import com.Maker.dao.ClinicRepo;
import com.Maker.dao.PendingRequestRepo;
import com.Maker.dao.PlansRepo;
import com.Maker.model.Clinic;
import com.Maker.model.PendingRequest;
import com.Maker.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class clinicServiceImp implements clinicService {


    @Autowired
    private ClinicRepo clinicRepo;

    @Autowired
    private PlansRepo plansRepo;

    @Autowired
    private PendingRequestRepo pendingRequestRepo;

    @Override
    public List<Clinic> getAllClinics() {
        return clinicRepo.findAll();
    }

    @Override
    public Clinic addClinic(Clinic clinic) {
        return clinicRepo.save(clinic);
    }

    @Override
    public PendingRequest requestForPlan(String username ,  String planName) {
        Clinic clinic = clinicRepo.findByUsername(username);
        if(clinic.getActPlan()==null) {
            Plan plan = plansRepo.findByPName(planName);

            return pendingRequestRepo.save(new
                    PendingRequest(clinic.getId(), plan.getId()));
        }else
            return null;
    }



    @Override
    public Clinic getClinic(String name) {
        return clinicRepo.findByUsername(name);
    }

//    @Override
//    public Clinic SetDomainName(String username, String domainName) {
//        Clinic clinic = clinicRepo.findByUsername(username);
//        if(clinic!=null)
//        {
//            clinic.setDomainName(domainName);
//           return clinicRepo.save(clinic);
//        }
//       throw new RuntimeException(username + " not found");
//    }
//

    @Override
    public Plan getActPlan(String username) {
        Clinic clinic = clinicRepo.findByUsername(username);
        return plansRepo.findByPName(clinic.getActPlan());
    }


}

