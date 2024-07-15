package com.virtusa.hms.service;

import java.util.List;

import com.virtusa.hms.dto.HotelDTO;
import com.virtusa.hms.dto.RoomBookDTO;
import com.virtusa.hms.exception.HmsException;

public interface ICustomerService {
	
	public List<HotelDTO> getHotels();
	public HotelDTO getHotel(String hname) throws HmsException;
	public RoomBookDTO bookRoom(int rid,RoomBookDTO rb) throws HmsException;
	public RoomBookDTO cancelbooking(int bid) throws HmsException;
	public RoomBookDTO modifyBooking(int bid,RoomBookDTO rb) throws HmsException;
	public List<RoomBookDTO> getBookings(String mobile) throws HmsException;

}
