package com.example.patientdemo.service;

import java.util.List;

import com.example.patientdemo.model.Patient;
import com.example.patientdemo.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public Patient saveUser(Patient patient) {
		try {
			patientRepository.insert(patient);
			return patient;
		} catch (Exception ex) {
			return null;
		}
	}

	public List<Patient> loadUsers() {
		try {
			List<Patient> list = patientRepository.findAll();
			return list;
		} catch (Exception ex) {
			return null;
		}
	}

    public void deleteById(String patientid) {
		patientRepository.deleteById(patientid);
    }


	public Patient updatePatient(Patient patient) 
	{
		try {
			patientRepository.save(patient);			
			return patient;
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
}