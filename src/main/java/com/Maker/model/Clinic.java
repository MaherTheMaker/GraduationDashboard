package com.Maker.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Clinic
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String ownerName;

	@Column(unique = true, length = 25)
	private String username;

	private String clinicName;


	private Date createDate;

	private Date updateDate;

	private String mobilePhone;

	private String clinicAddress;


	private String clinicPhone;

	private String actPlan;

	@Column(unique = true,length = 50 )
	private String clinicDomain;




	@OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ClinicPlan> clinicPlans;

	public Clinic()
	{
	}

	public Clinic(String ownerName, String username, String clinicName, Date createDate, Date updateDate, String mobilePhone, String clinicAddress, String clinicPhone, String actPlan, String clinicDomain, List<ClinicPlan> clinicPlans) {
		this.ownerName = ownerName;
		this.username = username;
		this.clinicName = clinicName;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.mobilePhone = mobilePhone;
		this.clinicAddress = clinicAddress;
		this.clinicPhone = clinicPhone;
		this.actPlan = actPlan;
		this.clinicDomain = clinicDomain;
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



	public String getClinicDomain() {
		return clinicDomain;
	}

	public void setClinicDomain(String clinicDomain) {
		this.clinicDomain = clinicDomain;
	}

	public List<ClinicPlan> getClinicPlans() {
		return clinicPlans;
	}

	public void setClinicPlans(List<ClinicPlan> clinicPlans) {
		this.clinicPlans = clinicPlans;
	}


}
