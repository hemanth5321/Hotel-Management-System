package com.virtusa.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.dto.EmpCredDTO;

@Repository
public interface EmpCredRepository extends JpaRepository<EmpCredDTO, Integer>{

	@Query
	("select u from EmpCredDTO u where u.emp_UserName=:email and u.emp_Password=:password")
	public EmpCredDTO getAuth(String email,String password);
	
}
