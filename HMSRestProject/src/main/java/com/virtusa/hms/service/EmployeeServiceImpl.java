package com.virtusa.hms.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.dao.BookingPaymentsRepository;
import com.virtusa.hms.dao.EmployeeRepository;
import com.virtusa.hms.dao.HotelRepository;
import com.virtusa.hms.dao.RoomBookRepository;
import com.virtusa.hms.dao.RoomRepository;
import com.virtusa.hms.dto.BookingPaymentsDTO;
import com.virtusa.hms.dto.EmployeeDTO;
import com.virtusa.hms.dto.HotelDTO;
import com.virtusa.hms.dto.RoomDTO;
import com.virtusa.hms.dto.RoomBookDTO;
import com.virtusa.hms.exception.HmsException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	Log log= LogFactory.getLog(EmployeeServiceImpl.class);

	@Autowired
	HotelRepository hdao;
	@Autowired
	RoomRepository rdao;
	@Autowired
	EmployeeRepository edao;
	@Autowired
	RoomBookRepository bdao;
	@Autowired
	BookingPaymentsRepository bpdao;
	
	public void addRoom(int hid,RoomDTO r) throws HmsException {
		HotelDTO h=null;
		if(hdao.existsById(hid)) {
			h=hdao.findById(hid).get();
			List<RoomDTO> rl= h.getRoomList();
			rl.add(r);
			hdao.save(h);
			log.info("Room added by employee");
		}
		else {
			log.error("Hotel not found to add room");
			throw new HmsException("Sorry, The hotel with hotel id "+hid+" does not exist");
		}
    }
	
	public RoomDTO deleteRoom(int rid) throws HmsException {
		RoomDTO r=null;
		if(rdao.existsById(rid)) {
			r=rdao.findById(rid).get();
	        rdao.deleteById(rid);
	        log.info("Room deleted by employee");
	        return r;
		}
		else {
			log.error("Room not found");
			throw new HmsException("Sorry, Room with Room id "+rid+" does not exist");
		}
    }
	
	public RoomDTO modifyRoom(int rid,RoomDTO r) throws HmsException {
		RoomDTO roomDTO=null;
		if(rdao.existsById(rid)) {
			roomDTO = rdao.findById(rid).get();
			roomDTO.setRoom_number(r.getRoom_number());
			roomDTO.setRoom_type(r.getRoom_type());
			roomDTO.setRoom_description(r.getRoom_description());
			roomDTO.setRoom_rent(r.getRoom_rent());
			rdao.save(roomDTO);
			log.info("Room details modified by employee");
			return roomDTO;
		}
		else {
			log.error("Room not found");
			throw new HmsException("Sorry, Room with Room id "+rid+" does not exist");
		}
	}
	
	public RoomDTO getRoom(int rid) throws HmsException {
		RoomDTO r=null;
		if(rdao.existsById(rid)) {
	        Optional<RoomDTO> o=rdao.findById(rid);
		    r=o.get();
		    log.info("Room searched by employee");
		    return r;
		}
		else {
			log.error("Room not found");
			throw new HmsException("Sorry, Room with Room id "+rid+" does not exist");
		}
	}
	
	public List<RoomDTO> getRooms(){
        List<RoomDTO> al=rdao.findAll();
        log.info("Rooms listed");
        return al;
    }
	
	public RoomBookDTO getBooking(int bid) throws HmsException {
		RoomBookDTO rb=null;
		if(bdao.existsById(bid)) {
	        Optional<RoomBookDTO> o=bdao.findById(bid);
		    rb=o.get();
		    log.info("Bookings viewed by employee");
		    return rb;
		}
		else {
			log.error("Booking not found");
			throw new HmsException("Sorry,There is no booking with booking id "+bid);
		}
	}
	
	public List<RoomBookDTO> getBookings(){
        List<RoomBookDTO> bl=bdao.findAll();
        log.info("Bookings listed");
        return bl;
    }
	
	public EmployeeDTO getEmployee(int eid) throws HmsException {
		EmployeeDTO e=null;
		if(edao.existsById(eid)) {
	        Optional<EmployeeDTO> o=edao.findById(eid);
		    e=o.get();
		    log.info("Employee viewed his details");
		    return e;
		}
		else {
			log.error("No employee exist");
			throw new HmsException("Sorry, Employee with Employee id "+eid+" does not exist");
		}
	}
	
	public void addPayment(BookingPaymentsDTO bp) {
        bpdao.save(bp);
        log.info("Booking payment added");
    }
	
	public BookingPaymentsDTO deletePayment(int pid) throws HmsException {
		BookingPaymentsDTO bp=null;
		if(bpdao.existsById(pid)) {
	        bp=bpdao.findById(pid).get();
	        bpdao.deleteById(pid);
	        log.info("Booking payment deleted");
	        return bp;
		}
		else {
			log.error("Payment not found");
			throw new HmsException("Sorry, Payment with payment id "+pid+" does not exist");
		}
    }
	
	public BookingPaymentsDTO modifyPayment(int pid,BookingPaymentsDTO bp) throws HmsException {
		BookingPaymentsDTO bps=null;
		if(bpdao.existsById(pid)) {
			bps = bpdao.findById(pid).get();
			bps.setBooking_id(bp.getBooking_id());
			bps.setHotel_id(bp.getHotel_id());
			bps.setRoom_id(bp.getRoom_id());
			bps.setPayment_amount(bp.getPayment_amount());
			bps.setPayment_date(bp.getPayment_date());
			bps.setPayment_type(bp.getPayment_type());
			bpdao.save(bps);
			log.info("Payment modified");
			return bps;
		}
		else {
			log.error("Booking not found");
			throw new HmsException("Sorry, Payment with payment id "+pid+" does not exist");
		}
	}
	
	public BookingPaymentsDTO getPayment(int pid) throws HmsException {
		BookingPaymentsDTO bp=null;
		if(bpdao.existsById(pid)) {
	        Optional<BookingPaymentsDTO> o=bpdao.findById(pid);
		    bp=o.get();
		    log.info("Payment searched");
		    return bp;
		}
		else {
			log.error("Payment not found");
			throw new HmsException("Sorry, Payment with payment id "+pid+" does not exist");
		}
	}
	
	public List<BookingPaymentsDTO> getPayments(){
        List<BookingPaymentsDTO> bp=bpdao.findAll();
        log.info("Payments listed");
        return bp;
    }
}
