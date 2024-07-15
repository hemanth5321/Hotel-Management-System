package com.virtusa.hms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.dto.EmployeeDTO;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Integer>{
	
	

}
