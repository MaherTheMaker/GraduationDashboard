package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clinic_plans")
public class ClinicPlan implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "clinic_id")
	@JsonIgnore
	private Clinic clinic;

	@ManyToOne
	@JoinColumn(name = "plan_id")
	@JsonIgnore
	private Plan plan;



	private String clinicName;

	private String planName;

	@Column(name = "payment_Date")
	private Date paymentDate;


	@Column(name = "payment_Id")
	private int paymentId ;

	@Column(name = "active_Date")
	private Date activeDate;

	public ClinicPlan() {
	}

	public ClinicPlan(Clinic clinic, Plan plan, String clinicName, String planName, Date paymentDate, int paymentId, Date activeDate) {
		this.clinic = clinic;
		this.plan = plan;
		this.clinicName = clinic.getClinicName();
		this.planName = plan.getpName();
		this.paymentDate = paymentDate;
		this.paymentId = paymentId;
		this.activeDate = activeDate;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Clinic getClinic()
	{
		return clinic;
	}

	public void setClinic(Clinic clinic)
	{
		this.clinic = clinic;
	}

	public Plan getPlan()
	{
		return plan;
	}

	public void setPlan(Plan plan)
	{
		this.plan = plan;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
}
