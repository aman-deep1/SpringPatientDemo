package com.example.patientdemo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ResponseData {

    private String msg;
	private Object data;
	private boolean status;
    
}
