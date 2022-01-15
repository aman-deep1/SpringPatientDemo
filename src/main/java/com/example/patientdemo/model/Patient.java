package com.example.patientdemo.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@AllArgsConstructor
@ToString

public class Patient 
{
	@Id
	private String patientId;
	private String patientName;
	private String patientPhone;
	private Integer patientAge;
	private String patientGender;

}
