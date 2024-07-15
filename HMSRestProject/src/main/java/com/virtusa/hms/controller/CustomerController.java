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

import com.virtusa.hms.dto.HotelDTO;
import com.virtusa.hms.dto.RoomBookDTO;
import com.virtusa.hms.exception.HmsException;
import com.virtusa.hms.service.ICustomerService;

@RestController
@RequestMapping("/customercontrol")
public class CustomerController {
	
	@Autowired
	ICustomerService service;

	@GetMapping("gethotels")
	public List<HotelDTO> getHotels() {
		return service.getHotels();
	}
	
	@GetMapping("/hname/{h1}")
	public HotelDTO getHotel(@PathVariable("h1") String hname) throws HmsException {
		return service.getHotel(hname);
	}
	
	@PostMapping("bookroom/{rid}")
	public RoomBookDTO bookRoom(@PathVariable("rid") int rid, @RequestBody RoomBookDTO rb) throws HmsException {
		return service.bookRoom(rid,rb);
	}
	
	@DeleteMapping("cancelbooking/{bid}")
	public RoomBookDTO cancelbooking(@PathVariable("bid") int bid) throws HmsException {
	    return service.cancelbooking(bid);
	}
	
	@PutMapping("modbooking/{bid}")
	public RoomBookDTO modifyBooking(@PathVariable("bid") int bid,@RequestBody RoomBookDTO rb) throws HmsException {
		return service.modifyBooking(bid,rb);
	}
	
	@GetMapping("viewbookings/{mbl}")
	public List<RoomBookDTO> viewBookings(@PathVariable("mbl") String mobile) throws HmsException {
		return service.getBookings(mobile);
	}
}
