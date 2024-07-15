package com.virtusa.hms.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="hotel")
public class HotelDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int hotel_id;
	String hotel_name;
	String hotel_type;
	String hotel_description;
	String hotel_address;
	Float hotel_rating;
	
	@OneToMany(targetEntity = RoomDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name="hid",referencedColumnName = "hotel_id")
    List<RoomDTO> roomList=new ArrayList<RoomDTO>();
	
	@OneToMany(targetEntity = EmployeeDTO.class,cascade = CascadeType.ALL)  
	@JsonIgnore
	@JoinColumn(name="hid",referencedColumnName = "hotel_id")
	List<EmployeeDTO> employeeList= new ArrayList<EmployeeDTO>();
	 
	
	public HotelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HotelDTO(int hotel_id, String hotel_name, String hotel_type, String hotel_description, String hotel_address,
			Float hotel_rating, List<RoomDTO> roomList, List<EmployeeDTO> employeeList) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_type = hotel_type;
		this.hotel_description = hotel_description;
		this.hotel_address = hotel_address;
		this.hotel_rating = hotel_rating;
		this.roomList = roomList;
		this.employeeList = employeeList;
	}


	public int getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}


	public String getHotel_name() {
		return hotel_name;
	}


	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}


	public String getHotel_type() {
		return hotel_type;
	}


	public void setHotel_type(String hotel_type) {
		this.hotel_type = hotel_type;
	}


	public String getHotel_description() {
		return hotel_description;
	}


	public void setHotel_description(String hotel_description) {
		this.hotel_description = hotel_description;
	}


	public String getHotel_address() {
		return hotel_address;
	}


	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}


	public Float getHotel_rating() {
		return hotel_rating;
	}


	public void setHotel_rating(Float hotel_rating) {
		this.hotel_rating = hotel_rating;
	}


	public List<RoomDTO> getRoomList() {
		return roomList;
	}


	public void setRoomList(List<RoomDTO> roomList) {
		this.roomList = roomList;
	}


	public List<EmployeeDTO> getEmployeeList() {
		return employeeList;
	}


	public void setEmployeeList(List<EmployeeDTO> employeeList) {
		this.employeeList = employeeList;
	}


	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_type=" + hotel_type
				+ ", hotel_description=" + hotel_description + ", hotel_address=" + hotel_address + ", hotel_rating="
				+ hotel_rating + ", roomList=" + roomList + ", employeeList=" + employeeList + "]";
	}

	
}
