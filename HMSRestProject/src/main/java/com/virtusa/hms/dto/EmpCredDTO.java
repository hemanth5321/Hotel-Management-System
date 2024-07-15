package com.virtusa.hms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="empcred")
public class EmpCredDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ref_id;
	String emp_UserName;
	String emp_Password;
	String emp_role;
	
	
	public EmpCredDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmpCredDTO(int ref_id, String emp_UserName, String emp_Password, String emp_role) {
		super();
		this.ref_id = ref_id;
		this.emp_UserName = emp_UserName;
		this.emp_Password = emp_Password;
		this.emp_role = emp_role;
	}


	public int getRef_id() {
		return ref_id;
	}


	public void setRef_id(int ref_id) {
		this.ref_id = ref_id;
	}


	public String getEmp_UserName() {
		return emp_UserName;
	}


	public void setEmp_UserName(String emp_UserName) {
		this.emp_UserName = emp_UserName;
	}


	public String getEmp_Password() {
		return emp_Password;
	}


	public void setEmp_Password(String emp_Password) {
		this.emp_Password = emp_Password;
	}


	public String getEmp_role() {
		return emp_role;
	}


	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}


	@Override
	public String toString() {
		return "EmpCred [ref_id=" + ref_id + ", emp_UserName=" + emp_UserName + ", emp_Password=" + emp_Password
				+ ", emp_role=" + emp_role + "]";
	}

	
}
