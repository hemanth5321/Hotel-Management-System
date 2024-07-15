package com.virtusa.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.dto.BookingPaymentsDTO;
import com.virtusa.hms.dto.EmployeeDTO;
import com.virtusa.hms.dto.RoomDTO;
import com.virtusa.hms.dto.RoomBookDTO;
import com.virtusa.hms.exception.HmsException;
import com.virtusa.hms.service.IEmployeeService;

@RestController
@RequestMapping("/employeecontrol")
public class EmployeeController {
	
	@Autowired
	IEmployeeService service;
	
	@PutMapping("addroom/{hid}")
	public RoomDTO addRoom(@PathVariable("hid") int hid, @RequestBody RoomDTO r) throws HmsException {
		service.addRoom(hid,r);
		return r;
	}
		 
	@GetMapping("getroomid/{rid}")
	public RoomDTO getRoomById(@PathVariable("rid") int rid) throws HmsException {
         return service.getRoom(rid);
	}
		
	@GetMapping("getrooms")
	public List<RoomDTO> getRooms() {
		return service.getRooms();
	}
		
	@DeleteMapping("delroom/{rid}")
	public RoomDTO delRoom(@PathVariable("rid") int rid) throws HmsException {
		return service.deleteRoom(rid);
	}
		 
	@PutMapping("modroom/{rid}")
	public RoomDTO modifyRoom(@PathVariable("rid") int rid,@RequestBody RoomDTO r) throws HmsException {
		return service.modifyRoom(rid,r);
	}

	@GetMapping("getbookingid/{bid}")
	public RoomBookDTO getBookingById(@PathVariable("bid") int bid) throws HmsException {
	    return service.getBooking(bid);
	}
	
	@GetMapping("getbookings")
	public List<RoomBookDTO> getBookings() {
		return service.getBookings();
	}
	
	@GetMapping("getdetails/{eid}")
	public EmployeeDTO getEmployeeById(@PathVariable("eid") int eid) throws HmsException {
         return service.getEmployee(eid);
	}
	
	@PostMapping("addpayment")
	public BookingPaymentsDTO addPayment(@RequestBody BookingPaymentsDTO bp) {
		service.addPayment(bp);
		return bp;
	}
	
	@GetMapping("getpaymentid/{pid}")
	public BookingPaymentsDTO getPaymentById(@PathVariable("pid") int pid) throws HmsException {
	    return service.getPayment(pid);
	}
	
	@GetMapping("getpayments")
	public List<BookingPaymentsDTO> getPayments() {
		return service.getPayments();
	}
	
	@DeleteMapping("delpayment/{pid}")
	public BookingPaymentsDTO delPayment(@PathVariable("pid") int pid) throws HmsException {
	    return service.deletePayment(pid);
	}
	 
	@PutMapping("modpayment/{pid}")
	public BookingPaymentsDTO modifyPayment(@PathVariable("pid") int pid,@RequestBody BookingPaymentsDTO bp) throws HmsException {
		return service.modifyPayment(pid,bp);
	}
}
