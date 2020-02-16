package com.example.demo.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Operation;

public interface IOperationRepository extends JpaRepository<Operation,Long>{
	
	//Requete hql
	@Query("select o from Operation o where o.compte.codeCompte=:x  ")//order by o.dateOperation desc
	//public Page<Operation> getOperations(@Param("x") String code,Pageable pageable);
	public List<Operation>listOperation(@Param("x") String idCompte);

}