package com.example.demo.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IBoRepository;
import com.example.demo.dao.ICompteRepository;
import com.example.demo.dao.IOperationRepository;
import com.example.demo.entities.BO;
import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;
import com.example.demo.entities.Retrait;
import com.example.demo.entities.Versement;

@Service
public class OperationMetier implements IOperationMetier{
	
	@Autowired
	private IOperationRepository operationRepository;
	@Autowired
	private ICompteRepository compteRepository;
	@Autowired
	private IBoRepository employeRepository;
	
	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.getOne(code);
		BO emp = employeRepository.getOne(codeEmp);
		Operation o=new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setBo(emp);
		
		operationRepository.save(o);
		
		cp.setSolde(cp.getSolde()+montant);
		
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.getOne(code);
		
		if(cp.getSolde()<montant)
			throw new RuntimeException("Solde Insuffisant ! Rak ghadi fi lkhosran a chrif");
		
		BO emp = employeRepository.getOne(codeEmp);
		Operation o=new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setBo(emp);
		
		operationRepository.save(o);
		
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
		
		retirer(cpte1, montant, codeEmp);
		verser(cpte2, montant, codeEmp);
		
		return true;
	}

	//pagination des operations
	
	/*
	 * @Override public PageOperation getOperation(String idCompte, int page, int
	 * size) {//page est le Numero de la page Page<Operation>
	 * ops=operationRepository.getOperations (idCompte,new PageRequest(page, size));
	 * PageOperation pOp=new PageOperation(); pOp.setOperations(ops.getContent());
	 * pOp.setNombreOperations(ops.getNumberOfElements());
	 * pOp.setPage(ops.getNumber()); pOp.setTotalPages(ops.getTotalPages());
	 * pOp.setTotalOperations((int)ops.getTotalElements()); return pOp; }
	 */
	@Override
	public List<Operation>listOperationsCompte(String idCompte){
		return operationRepository.listOperation(idCompte);
	}
	 
	

}