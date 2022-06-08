package com.Maker.service;

import com.Maker.model.ClinicPlan;
import com.Maker.model.Plan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClinicPlansService {

    List<ClinicPlan> getAllClinicPlan();
    ClinicPlan addClinicPlan(ClinicPlan clinicPlan);
    ClinicPlan confirmRequest (int id , boolean activate);
    List<ClinicPlan> getHistoryPlans(String username);


}
