package com.virtusa.hms.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emppayment")
public class EmployeePaymentsDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int epayment_id;
	String emp_name;
	String emp_role;
	@Temporal(TemporalType.DATE)
	Date epayment_date;
	int emp_salary;
	
	public EmployeePaymentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeePaymentsDTO(int epayment_id, String emp_name, String emp_role, Date epayment_date, int emp_salary) {
		super();
		this.epayment_id = epayment_id;
		this.emp_name = emp_name;
		this.emp_role = emp_role;
		this.epayment_date = epayment_date;
		this.emp_salary = emp_salary;
	}

	public int getEpayment_id() {
		return epayment_id;
	}

	public void setEpayment_id(int epayment_id) {
		this.epayment_id = epayment_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	public Date getEpayment_date() {
		return epayment_date;
	}

	public void setEpayment_date(Date epayment_date) {
		this.epayment_date = epayment_date;
	}

	public int getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(int emp_salary) {
		this.emp_salary = emp_salary;
	}

	@Override
	public String toString() {
		return "EmployeePayments [epayment_id=" + epayment_id + ", emp_name=" + emp_name + ", emp_role=" + emp_role
				+ ", epayment_date=" + epayment_date + ", emp_salary=" + emp_salary + "]";
	}

}
