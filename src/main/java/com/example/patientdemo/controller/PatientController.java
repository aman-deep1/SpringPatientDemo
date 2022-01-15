package com.example.patientdemo.controller;

import java.util.List;
import java.util.Optional;

import com.example.patientdemo.model.Patient;
import com.example.patientdemo.repository.PatientRepository;
import com.example.patientdemo.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientRepository patientRepository;

	@PostMapping("/save")
	public ResponseEntity saveUser(@RequestBody Patient patient) {
		System.out.println(patient);
		Patient newPatient = patientService.saveUser(patient);
		if (newPatient == null)
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		else
			return ResponseEntity.ok(newPatient);
	}

	@GetMapping("/load")
	public ResponseEntity loadUsers() {
		List<Patient> list = patientService.loadUsers();
		return ResponseEntity.ok(list);
	}

	@DeleteMapping("/del/{patientId}")
	public String deletePatient(@PathVariable String patientId) {
		System.out.println(patientId);
	//	patientService.deleteById(patientid);
	patientRepository.deleteById(patientId);
		return "Patient deleted: " + patientId;
	}

	@GetMapping("/findAll/{patientId}")
	public Optional<Patient> getPatient(@PathVariable String patientId){
		return patientRepository.findById(patientId);
	}

	@PutMapping("/update")
	public ResponseEntity updatePatient(@RequestBody Patient patient) 
	{		
		Patient newPatient = patientService.updatePatient(patient);	
		if(newPatient==null)
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);		
		else
			return ResponseEntity.ok(newPatient);
	}
}