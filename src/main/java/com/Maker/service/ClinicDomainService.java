package com.Maker.service;

import com.Maker.model.ClinicDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicDomainService {

    ClinicDomain addDomain(ClinicDomain clinicDomain);
    ClinicDomain getClinicDomain(String clinicName);
}
