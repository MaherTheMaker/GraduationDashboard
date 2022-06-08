package com.Maker.dao;

import com.Maker.model.Clinic;
import com.Maker.model.ClinicDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicDomainRepo extends JpaRepository<ClinicDomain,Integer> {
    ClinicDomain findByClinic(Clinic clinic);
}
