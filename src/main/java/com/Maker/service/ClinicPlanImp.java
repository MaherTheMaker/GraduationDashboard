package com.Maker.service;

import com.Maker.dao.ClinicPlanRepository;
import com.Maker.dao.ClinicRepo;
import com.Maker.dao.PendingRequestRepo;
import com.Maker.dao.PlansRepo;
import com.Maker.model.Clinic;
import com.Maker.model.ClinicPlan;
import com.Maker.model.PendingRequest;
import com.Maker.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicPlanImp implements ClinicPlansService {

    @Autowired
    private ClinicPlanRepository  clinicPlanRepository;

    @Autowired
    private PendingRequestRepo pendingRequestRepo;

    @Autowired
    private ClinicRepo clinicRepo;


    @Autowired
    private PlansRepo plansRepo;

    @Override
    public List<ClinicPlan> getAllClinicPlan() {
        return clinicPlanRepository.findAll();
    }

    @Override
    public ClinicPlan addClinicPlan(ClinicPlan clinicPlan) {
        return clinicPlanRepository.save(clinicPlan);
    }


    @Override
    public ClinicPlan confirmRequest(int id, boolean activate) {
        PendingRequest pendingRequest = pendingRequestRepo.findById(id);
        if(activate){
            Clinic clinic = clinicRepo.findById(pendingRequest.getcId());
            Plan plan = plansRepo.findById(pendingRequest.getpId());
            clinic.setActPlan(plan.getpName());
            pendingRequestRepo.deleteById(id);
            return clinicPlanRepository.save(new ClinicPlan(clinic,plan,plan.getpName(),clinic.getClinicName(),null,0 ,null));
        }
        else
            return null;
    }

    @Override
    public List<ClinicPlan> getHistoryPlans(String username) {
            Clinic clinic = clinicRepo.findByUsername(username);
            return clinicPlanRepository.findAllByClinic(clinic);
    }


}
