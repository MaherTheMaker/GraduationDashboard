package com.Maker.service;

import com.Maker.dao.ClinicDomainRepo;
import com.Maker.dao.ClinicRepo;
import com.Maker.model.Clinic;
import com.Maker.model.ClinicDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicDomainServiceImp implements ClinicDomainService{

    @Autowired
    private ClinicDomainRepo clinicDomainRepo;

    @Autowired
    private ClinicRepo clinicRepo;

    @Override
    public ClinicDomain addDomain(ClinicDomain clinicDomain) {
        return clinicDomainRepo.save(clinicDomain);
    }

    @Override
    public ClinicDomain getClinicDomain(String clinicUsername) {
        Clinic clinic = clinicRepo.findByUsername(clinicUsername);
        return clinicDomainRepo.findByClinic(clinic);
    }
}
