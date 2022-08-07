package com.Maker.service;



import com.Maker.cmd_prompt.my_main;
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

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
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
    public Clinic addClinic(Clinic clinic) throws IOException {
        clinic.setCreateDate(java.sql.Date.valueOf(LocalDate.now()));

        return clinicRepo.save(clinic);
    }

    @Override
    public PendingRequest requestForPlan(String username ,  int pId) {
        Clinic clinic = clinicRepo.findByUsername(username);
        System.out.println(username + clinic + pId);
//        if(clinic.getActPlan()==null) {
            Plan plan = plansRepo.findById(pId);
            return pendingRequestRepo.save(new
                    PendingRequest(clinic.getId(), plan.getId()));
//        }else
//            return null;

    }



    @Override
    public Clinic getClinic(String name) {
        return clinicRepo.findByUsername(name);
    }




    @Override
    public Plan getActPlan(String username) {
        Clinic clinic = clinicRepo.findByUsername(username);
        return plansRepo.findByPName(clinic.getActPlan());
    }

    @Override
    public Clinic editClinic(String username , Clinic clinic) {

        Clinic old= clinicRepo.findByUsername(username);
        System.out.println(username + old);
            old.setClinicAddress(clinic.getClinicAddress());
            old.setClinicName(clinic.getClinicName());
            old.setClinicPhone(clinic.getClinicPhone());
            old.setMobilePhone(clinic.getMobilePhone());
            old.setUpdateDate(java.sql.Date.valueOf(LocalDate.now()));
            return clinicRepo.save(old);
    }



}

