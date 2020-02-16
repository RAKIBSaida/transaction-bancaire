package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPTES")
@Inheritance (strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Cpte",discriminatorType=DiscriminatorType.STRING,length=2)

public abstract class Compte implements Serializable {
	@Id
	private String idCompte;
	private double solde;
	
	
	@OneToMany(mappedBy="compte",fetch = FetchType.LAZY)
	private Collection<Operation> operations;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdCompte() {
		return idCompte;
	}

	public void setIdCompte1(String idCompte) {
		this.idCompte = idCompte;
	}
	public double getSolde() { 
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde; 
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	

}