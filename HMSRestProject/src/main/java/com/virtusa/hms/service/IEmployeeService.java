package com.virtusa.hms.service;

import java.util.List;

import com.virtusa.hms.dto.BookingPaymentsDTO;
import com.virtusa.hms.dto.EmployeeDTO;
import com.virtusa.hms.dto.RoomBookDTO;
import com.virtusa.hms.dto.RoomDTO;
import com.virtusa.hms.exception.HmsException;

public interface IEmployeeService {
	
	public void addRoom(int hid,RoomDTO r) throws HmsException;
	public RoomDTO deleteRoom(int rid) throws HmsException;
	public RoomDTO modifyRoom(int rid,RoomDTO r) throws HmsException;
	public RoomDTO getRoom(int rid) throws HmsException;
	public List<RoomDTO> getRooms();
	
	public RoomBookDTO getBooking(int bid) throws HmsException;
	public List<RoomBookDTO> getBookings();
	public EmployeeDTO getEmployee(int eid) throws HmsException;
	
	public void addPayment(BookingPaymentsDTO bp);
	public BookingPaymentsDTO deletePayment(int pid) throws HmsException;
	public BookingPaymentsDTO modifyPayment(int pid,BookingPaymentsDTO bp) throws HmsException;
	public BookingPaymentsDTO getPayment(int pid) throws HmsException;
	public List<BookingPaymentsDTO> getPayments();

}
