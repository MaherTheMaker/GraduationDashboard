package com.Maker.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Clinic
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private boolean isActive;
	private String ownerName;



	@Column(unique = true, length = 25)
	private String username;
	@Column(unique = false, length = 100)
	private String clinicName;


	private Date createDate;

	private Date updateDate;

	@NotNull
	private String email;


	private String mobilePhone;

	@Column(length = 200)
	private String clinicAddress;


	private String domainName;


	private String clinicPhone;

	private String actPlan;


	@OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ClinicPlan> clinicPlans;

	public Clinic()
	{
	}

	public Clinic(boolean isActive, String ownerName, String username, String clinicName, Date createDate, Date updateDate, String email, String mobilePhone, String clinicAddress, String domainName, String clinicPhone, String actPlan, List<ClinicPlan> clinicPlans) {
		this.isActive = isActive;
		this.ownerName = ownerName;
		this.username = username;
		this.clinicName = clinicName;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.clinicAddress = clinicAddress;
		this.domainName = domainName;
		this.clinicPhone = clinicPhone;
		this.actPlan = actPlan;
		this.clinicPlans = clinicPlans;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getActPlan() {
		return actPlan;
	}

	public void setActPlan(String actPlan) {
		this.actPlan = actPlan;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getClinicPhone() {
		return clinicPhone;
	}

	public void setClinicPhone(String clinicPhone) {
		this.clinicPhone = clinicPhone;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}




	public List<ClinicPlan> getClinicPlans() {
		return clinicPlans;
	}

	public void setClinicPlans(List<ClinicPlan> clinicPlans) {
		this.clinicPlans = clinicPlans;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}



}
