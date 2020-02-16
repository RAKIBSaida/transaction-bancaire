package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*
 * BO:c'est le charge clientele qui gere les transactions 
 */

public class BO implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeBO;
	
	public BO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getCodeBO() {
		return codeBO;
	}
	public void setCodeBO(Long codeBO) {
		this.codeBO = codeBO;
	}
	
	
	
}
