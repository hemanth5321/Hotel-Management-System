package com.virtusa.hms.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.virtusa.hms.dto.BookingPaymentsDTO;
import com.virtusa.hms.dto.EmpCredDTO;
import com.virtusa.hms.dto.EmployeeDTO;
import com.virtusa.hms.dto.EmployeePaymentsDTO;
import com.virtusa.hms.dto.HotelDTO;
import com.virtusa.hms.dto.RoomDTO;
import com.virtusa.hms.exception.HmsException;

@Component
public interface IAdminService {

	public void addHotel(HotelDTO h);
	public HotelDTO deleteHotel(int hid) throws HmsException;
	public HotelDTO modifyHotel(int hid,HotelDTO h) throws HmsException;
	public HotelDTO getHotel(int hid) throws HmsException;
	public List<HotelDTO> getHotels();
	
	public void addRoom(int hid,RoomDTO r) throws HmsException;
	public RoomDTO deleteRoom(int rid) throws HmsException;
	public RoomDTO modifyRoom(int rid,RoomDTO r) throws HmsException;
	public RoomDTO getRoom(int rid) throws HmsException;
	public List<RoomDTO> getRooms();
	
	public void addEmployee(int hid,EmployeeDTO e) throws HmsException;
	public EmployeeDTO deleteEmployee(int eid) throws HmsException;
	public EmployeeDTO modifyEmployee(int eid,EmployeeDTO e) throws HmsException;
	public EmployeeDTO getEmployee(int eid) throws HmsException;
	public List<EmployeeDTO> getEmployees();
	public EmpCredDTO modifyEmpCred(int rid,EmpCredDTO e) throws HmsException;
	
	public void addEmpPay(int eid,EmployeePaymentsDTO ep) throws HmsException;
	public EmployeePaymentsDTO deleteEmppay(int pid) throws HmsException;
	public EmployeePaymentsDTO modifyEmpPay(int pid,EmployeePaymentsDTO ep) throws HmsException;
	public EmployeePaymentsDTO getEmpPay(int pid) throws HmsException;
	public List<EmployeePaymentsDTO> getEmpPays();
	
	public BookingPaymentsDTO getPayment(int pid) throws HmsException;
	public List<BookingPaymentsDTO> getPayments();
	public void addEmpCred(EmpCredDTO ec);
	public String getSunByRange(String sd,String ed);
	public String getSum();
}
