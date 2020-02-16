package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPERATIONS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Operation implements Serializable{
	
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Date dateOperation;
private double montant;

@ManyToOne
@JoinColumn(name="IdCompte")
private Compte compte;
@ManyToOne
@JoinColumn(name="CODE_BO")
private BO Bo;

public Operation() {
	super();
}
public Operation(Date dateOperation, double montant, Compte compte) {
	super();
	this.dateOperation = dateOperation;
	this.montant = montant;
	this.compte = compte;
}


public Date getDateOperation() {
	return dateOperation;
}
public void setDateOperation(Date dateOperation) {
	this.dateOperation = dateOperation;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}
public BO getBo() {
	return Bo;
}
public void setBo(BO Bo) {
	this.Bo = Bo;
}

}
