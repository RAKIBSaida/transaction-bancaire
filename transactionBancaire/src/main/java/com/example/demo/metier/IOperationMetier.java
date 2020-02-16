package com.example.demo.metier;

import java.util.List;

import com.example.demo.entities.Operation;

public interface IOperationMetier {
	public boolean verser(String code, double montant, Long codeBo);
	public boolean retirer(String code, double montant, Long codeBo);
	public boolean virement(String cpte1, String cpte2, double montant, Long codeBo);
	//public PageOperation getOperation(String idCompte, int page, int size);
	public List<Operation>listOperationsCompte(String idCompte);
}
