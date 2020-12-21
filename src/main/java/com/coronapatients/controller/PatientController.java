package com.coronapatients.controller;

//assigning CRUD operations in the controller class

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronapatients.exception.ResourceNotFoundException;
import com.coronapatients.model.Patient;
import com.coronapatients.repository.PatientRepository;



@CrossOrigin(origins = "http://localhost:4200") //to avoid conflicts between backend and frontend ports
@RestController
@RequestMapping("/rest/v2") //declaring the base
public class PatientController {

	//declaring the repository
	@Autowired 
	private PatientRepository patientrepository;
	
	// GET method to return all patients
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientrepository.findAll();
	}
	
	
	//POST method to add a new patient
	
	@PostMapping("/patients")
	public Patient createPatient(@Valid @RequestBody Patient patient)
	{
		return patientrepository.save(patient);
	}
	
	//GET method to return a patient for a specific patient id
	
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getEmployeeById(@PathVariable(value = "id") Long patientId)
			throws ResourceNotFoundException {
		Patient patient = patientrepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
		return ResponseEntity.ok().body(patient);
	}
	
	//PUT method to update a patient
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Long patientId,
			@Valid @RequestBody Patient patientDetails) throws ResourceNotFoundException {
		Patient patient = patientrepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found :: " + patientId));

		
		patient.setPatient_name(patientDetails.getPatient_name());
		patient.setPatient_address(patientDetails.getPatient_address());
		patient.setContact_no(patientDetails.getContact_no());
		
		final Patient updatedPatient = patientrepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}
	
	//DELETE method to delete a patient
	
	@DeleteMapping("/patients/{id}")
	public Map<String, Boolean> deletePatient(@PathVariable(value = "id") Long patientId)
			throws ResourceNotFoundException {
		Patient patient = patientrepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));

		patientrepository.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
