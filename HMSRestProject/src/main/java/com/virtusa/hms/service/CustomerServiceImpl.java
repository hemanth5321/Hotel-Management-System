package com.virtusa.hms.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.dao.HotelRepository;
import com.virtusa.hms.dao.RoomBookRepository;
import com.virtusa.hms.dao.RoomRepository;
import com.virtusa.hms.dto.HotelDTO;
import com.virtusa.hms.dto.RoomBookDTO;
import com.virtusa.hms.exception.HmsException;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	Log log= LogFactory.getLog(CustomerServiceImpl.class);

	@Autowired
	HotelRepository hdao;
	@Autowired
	RoomRepository rdao;
	@Autowired
	RoomBookRepository bdao;
	
	public List<HotelDTO> getHotels(){
        List<HotelDTO> al=hdao.findAll();
        log.info("Hotels viewed by customer");
        return al;
    }
	
	public HotelDTO getHotel(String hname) throws HmsException {
		HotelDTO h=hdao.getHotelName(hname);
		if(h!=null) {
	        HotelDTO o=hdao.getHotelName(hname);
	        log.info("Hotel searched by name");
		    return o;
		}
		else {
			log.error("Hotel not found");
			throw new HmsException("Sorry, We don't have any hotel with name "+hname);
		}
	}
	
	/*public Hotel getHotel(String hname) throws HmsException {
		Hotel h=hdao.getHotelName(hname);
		if(h!=null) {
	        Optional<Hotel> o=hdao.getHotelByName(hname);
		    h=o.get();
		    return h;
		}
		throw new HmsException("Sorry, The hotel with name "+hname+" does not exist");
	}*/
	
	public RoomBookDTO bookRoom(int rid,RoomBookDTO rb) throws HmsException {
		String s="available";
		if(rdao.existsById(rid) && rdao.getStatus(rid).equalsIgnoreCase(s)) {
	        int days=rb.getBooking_days();
	        int rent=rdao.getRent(rid);
	        int amount=days*rent;
	        rb.setBill(amount);
	        bdao.save(rb);
	        rdao.changeStatus(rid);
	        //rdao.deleteById(rid);
	        log.info("Hotel booked by customer");
	        return rb;
		}
		else {
			log.error("Hotel not booked . Room not found");
			throw new HmsException("Sorry, Room with room id "+rid+" is not available");
		}
    }
	
	public RoomBookDTO cancelbooking(int bid) throws HmsException {
		RoomBookDTO rb=null;
		if(bdao.existsById(bid)) {
			rb=bdao.findById(bid).get();
			int r=rb.getRoom_id();
			rdao.changeStatuss(r);
	        bdao.deleteById(bid);
	        log.info("Booking cancelled");
	        return rb;
		}
		else {
			log.error("Booking not found");
			throw new HmsException("Sorry, Booking with booking id "+bid+" does not exist");
		}
    }
	
	public RoomBookDTO modifyBooking(int bid,RoomBookDTO rb) throws HmsException {
		RoomBookDTO rbook=null;
		if(bdao.existsById(bid)) {
			rbook = bdao.findById(bid).get();
			int d=rbook.getBooking_days();
			rbook.setRoom_id(rb.getRoom_id());
			rbook.setCust_name(rb.getCust_name());
			rbook.setCust_mobile(rb.getCust_mobile());
			rbook.setCust_email(rb.getCust_email());
			rbook.setCust_aadhar(rb.getCust_aadhar());
			rbook.setCust_count(rb.getCust_count());
			rbook.setBooking_days(rb.getBooking_days());
			rbook.setCheckin(rb.getCheckin());
			rbook.setCheckout(rb.getCheckout());
			int days=rb.getBooking_days();
	        int rent=(rb.getBill()/d);
	        int amount=days*rent;
			rbook.setBill(amount);
			bdao.save(rbook);
			log.info("Booking modified");
			return rbook;
		}
		else {
			log.error("Booking not found");
			throw new HmsException("Sorry, Booking with booking id "+bid+" does not exist");
		}
	}
	
	public List<RoomBookDTO> getBookings(String mobile) throws HmsException {
		List<RoomBookDTO> b=bdao.viewBooking(mobile);
		if(b==null) {
			log.error("No bookings");
			throw new HmsException("Sorry, We cannot find any bookings with mobile number "+mobile);
		}
		else {
			log.info("Bookings listed");
			return b;
		}
	}
}
