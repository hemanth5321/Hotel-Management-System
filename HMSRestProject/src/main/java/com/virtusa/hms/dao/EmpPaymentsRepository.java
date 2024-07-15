package com.virtusa.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.dto.EmployeePaymentsDTO;

@Repository
public interface EmpPaymentsRepository extends JpaRepository<EmployeePaymentsDTO, Integer>{

}
