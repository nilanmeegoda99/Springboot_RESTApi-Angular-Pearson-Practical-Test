package com.coronapatients.model;

//Declaring the model class for a patient 
//Initializing the H2 database

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients") //Database Table name

public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ID column, assigning for auto increment
	private long id;
	
	@Column(name = "patient_name") //2nd column
	private String Patient_name;
	
	@Column(name = "address")//3rd column
	private String Patient_address;
	
	@Column(name = "c_number")//4th column
	private String Contact_no;
	
	
	//default constructor for Patient class
	public Patient() {
		super();
	}
	
	//Overload constructor for Patient class
	public Patient(long id, String patient_name, String patient_address, String contact_no) {
		super();
		this.id = id;
		Patient_name = patient_name;
		Patient_address = patient_address;
		Contact_no = contact_no;
	}
	
	//Declaring Getters and Setters
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPatient_name() {
		return Patient_name;
	}
	public void setPatient_name(String patient_name) {
		Patient_name = patient_name;
	}
	public String getPatient_address() {
		return Patient_address;
	}
	public void setPatient_address(String patient_address) {
		Patient_address = patient_address;
	}
	public String getContact_no() {
		return Contact_no;
	}
	public void setContact_no(String contact_no) {
		Contact_no = contact_no;
	}
	

}
