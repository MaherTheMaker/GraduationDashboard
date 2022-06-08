package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ClinicDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "clinic_id",unique = true)
    private Clinic clinic;

    @Column(unique = true,length = 100)
    private String Domain;

    public ClinicDomain(Clinic clinic, String domain) {
        this.clinic = clinic;
        Domain = domain;
    }

    public ClinicDomain() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }
}
