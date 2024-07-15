package com.virtusa.hms.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="employee")
public class EmployeeDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int emp_id;
	String emp_name;
	String emp_address;
	int emp_salary;
	String emp_role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cred_ref")
    EmpCredDTO empcred;
	
	@OneToMany(targetEntity = EmployeePaymentsDTO.class, cascade = CascadeType.ALL)
	//@JsonIgnore
	@JoinColumn(name="eid",referencedColumnName = "emp_id")
    List<EmployeePaymentsDTO> payList=new ArrayList<EmployeePaymentsDTO>();

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(int emp_id, String emp_name, String emp_address, int emp_salary, String emp_role, EmpCredDTO empcred,
			List<EmployeePaymentsDTO> payList) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_address = emp_address;
		this.emp_salary = emp_salary;
		this.emp_role = emp_role;
		this.empcred = empcred;
		this.payList = payList;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public int getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(int emp_salary) {
		this.emp_salary = emp_salary;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	public EmpCredDTO getEmpcred() {
		return empcred;
	}

	public void setEmpcred(EmpCredDTO empcred) {
		this.empcred = empcred;
	}

	public List<EmployeePaymentsDTO> getPayList() {
		return payList;
	}

	public void setPayList(List<EmployeePaymentsDTO> payList) {
		this.payList = payList;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_address=" + emp_address
				+ ", emp_salary=" + emp_salary + ", emp_role=" + emp_role + ", empcred=" + empcred + ", payList="
				+ payList + "]";
	}

	
}
