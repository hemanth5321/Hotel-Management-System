package com.virtusa.hms.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.dao.BookingPaymentsRepository;
import com.virtusa.hms.dao.EmpCredRepository;
import com.virtusa.hms.dao.EmpPaymentsRepository;
import com.virtusa.hms.dao.EmployeeRepository;
import com.virtusa.hms.dao.HotelRepository;
import com.virtusa.hms.dao.RoomRepository;
import com.virtusa.hms.dto.BookingPaymentsDTO;
import com.virtusa.hms.dto.EmpCredDTO;
import com.virtusa.hms.dto.EmployeeDTO;
import com.virtusa.hms.dto.EmployeePaymentsDTO;
import com.virtusa.hms.dto.HotelDTO;
import com.virtusa.hms.dto.RoomDTO;
import com.virtusa.hms.exception.HmsException;

@Service
public class AdminServiceImpl implements IAdminService {
	
	Log log= LogFactory.getLog(AdminServiceImpl.class);

	@Autowired
	HotelRepository hdao;
	@Autowired
	RoomRepository rdao;
	@Autowired
	EmployeeRepository edao;
	@Autowired
	EmpCredRepository cdao;
	@Autowired
	EmpPaymentsRepository epdao;
	@Autowired
	BookingPaymentsRepository bpdao;
	
	public String getSunByRange(String sd,String ed) {
		return "The sum of booking payment in the range is : "+bpdao.getSunByRange(sd, ed);
		
	}
	
	public String getSum() {
		return "The total booking amount is : "+bpdao.getSum();
	}
	
	public void addHotel(HotelDTO h) {
        hdao.save(h);
		log.info("New hotel added");
    }
	
	public HotelDTO deleteHotel(int hid) throws HmsException {
		HotelDTO h=null;
		if(hdao.existsById(hid)) {
			h=hdao.findById(hid).get();
			hdao.deleteById(hid);
			log.info("Hotel deleted");
			return h;
		}
		else {
			log.error("Hotel not found to delete");
			throw new HmsException("Sorry, The hotel with hotel id "+hid+" does not exist");
		}
    }
	
	public HotelDTO modifyHotel(int hid,HotelDTO h) throws HmsException {
		HotelDTO hotelDTO=null;
		if(hdao.existsById(hid)) {
			hotelDTO = hdao.findById(hid).get();
			hotelDTO.setHotel_name(h.getHotel_name());
			hotelDTO.setHotel_type(h.getHotel_type());
			hotelDTO.setHotel_description(h.getHotel_description());
			hotelDTO.setHotel_address(h.getHotel_address());
			hotelDTO.setHotel_rating(h.getHotel_rating());
			hdao.save(hotelDTO);
			log.info("Hotel modified");
			return hotelDTO;
		}
		else {
			log.error("Hotel not found to modify");
			throw new HmsException("Sorry, The hotel with hotel id "+hid+" does not exist");
		}
	}
	
	public HotelDTO getHotel(int hid) throws HmsException {
		HotelDTO h=null;
		if(hdao.existsById(hid)) {
			Optional<HotelDTO> o=hdao.findById(hid);
			h=o.get();
			log.info("Hotel searched by id");
			return h;
		}
		else {
			log.error("Hotel not found to modify");
			throw new HmsException("Sorry, The hotel with hotel id "+hid+" does not exist");
		}
	}
	
	public List<HotelDTO> getHotels(){
        List<HotelDTO> al=hdao.findAll();
		log.info("Hotels are listed");
        return al;
    }
	
	public void addRoom(int hid,RoomDTO r) throws HmsException {
		HotelDTO h=null;
		if(hdao.existsById(hid)) {
			h=hdao.findById(hid).get();
			List<RoomDTO> rl= h.getRoomList();
			rl.add(r);
			hdao.save(h);
			log.info("Room added");
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
	        log.info("Room deleted");
	        return r;
		}
		else {
			log.error("Room not found to delete");
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
			log.info("Room details modified");
			return roomDTO;
		}
		else {
			log.error("Room not found to modify");
			throw new HmsException("Sorry, Room with Room id "+rid+" does not exist");
		}
	}
	
	public RoomDTO getRoom(int rid) throws HmsException {
		RoomDTO r=null;
		if(rdao.existsById(rid)) {
	        Optional<RoomDTO> o=rdao.findById(rid);
		    r=o.get();
		    log.info("Room searched by id");
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
	
	public void addEmployee(int hid,EmployeeDTO e) throws HmsException {
		HotelDTO h=null;
		if(hdao.existsById(hid)) {
			h=hdao.findById(hid).get();
			List<EmployeeDTO> el= h.getEmployeeList();
			el.add(e);
			hdao.save(h);
			log.info("Employee added");
		}
		else {
			log.error("Hotel not found to add employee");
			throw new HmsException("Sorry, The hotel with hotel id "+hid+" does not exist");
		}
    }
	
	public EmployeeDTO deleteEmployee(int eid) throws HmsException {
		EmployeeDTO e=null;
		if(edao.existsById(eid)) {
			e=edao.findById(eid).get();
	        edao.deleteById(eid);
	        log.info("Employee deleted");
	        return e;
		}
		else {
			log.error("Employee not found to delete");
			throw new HmsException("Sorry, Employee with Employee id "+eid+" does not exist");
		}
    }
	
	public EmployeeDTO modifyEmployee(int eid,EmployeeDTO e) throws HmsException {
		EmployeeDTO emp=null;
		if(edao.existsById(eid)) {
			emp = edao.findById(eid).get();
			emp.setEmp_name(e.getEmp_name());
			emp.setEmp_address(e.getEmp_address());
			emp.setEmp_salary(e.getEmp_salary());
			emp.setEmp_role(e.getEmp_role());
			edao.save(emp);
			log.info("Employee details modified");
			return emp;
		}
		else {
			log.error("Employee not found to modify");
			throw new HmsException("Sorry, Employee with Employee id "+eid+" does not exist");
		}
	}
	
	public EmpCredDTO modifyEmpCred(int rid,EmpCredDTO e) throws HmsException {
		EmpCredDTO emp=null;
		if(cdao.existsById(rid)) {
			emp = cdao.findById(rid).get();
			emp.setEmp_UserName(e.getEmp_UserName());
			emp.setEmp_Password(e.getEmp_Password());
			emp.setEmp_role(e.getEmp_role());
			cdao.save(emp);
			log.info("Employee credentials modified");
			return emp;
		}
		else {
			log.error("Employee cred not found to modify");
			throw new HmsException("Sorry, Employee cred with reference id "+rid+" does not exist");
		}
	}
	
	public EmployeeDTO getEmployee(int eid) throws HmsException {
		EmployeeDTO e=null;
		if(edao.existsById(eid)) {
	        Optional<EmployeeDTO> o=edao.findById(eid);
		    e=o.get();
		    log.info("Employee searched by id");
		    return e;
		}
		else {
			log.error("Employee not found");
			throw new HmsException("Sorry, Employee with Employee id "+eid+" does not exist");
		}
	}
	
	public List<EmployeeDTO> getEmployees(){
        List<EmployeeDTO> al=edao.findAll();
        log.info("Employees listed");
        return al;
    }
	
	
	/*
	 * public void addEmpCred(int eid,EmpCred ec) { Employee
	 * e=edao.findById(eid).get(); EmpCred el=e.setEmpcred(ec); cdao.save(el);
	 * 
	 * }
	 */

	public void addEmpCred(EmpCredDTO ec) {
		
		/*
		 * el.setEmp_id(ec.getEmp_id()); el.setEmp_UserName(ec.getEmp_UserName());
		 * el.setEmp_Password(ec.getEmp_Password()); el.setEmp_role(ec.getEmp_role());
		 */
		cdao.save(ec);
	}
	
	
	public void addEmpPay(int eid,EmployeePaymentsDTO ep) throws HmsException {
		EmployeeDTO e=null;
		if(edao.existsById(eid)) {
			e=edao.findById(eid).get();
			List<EmployeePaymentsDTO> epl= e.getPayList();
			epl.add(ep);
			epdao.save(ep);
			log.info("Employee payment added");
		}
		else {
			log.error("Employee not found");
			throw new HmsException("Sorry, Employee with Employee id "+eid+" does not exist");
		}
    }
	
	public EmployeePaymentsDTO deleteEmppay(int pid) throws HmsException {
		EmployeePaymentsDTO ep=null;
		if(epdao.existsById(pid)) {
			ep=epdao.findById(pid).get();
	        epdao.deleteById(pid);
	        log.info("Employee payment deleted");
	        return ep;
		}
		else {
			log.error("Employee payment not found to delete");
			throw new HmsException("Sorry, Employee Payment with Payment id "+pid+" does not exist");
		}
    }
	
	public EmployeePaymentsDTO modifyEmpPay(int pid,EmployeePaymentsDTO ep) throws HmsException {
		EmployeePaymentsDTO emp=null;
		if(epdao.existsById(pid)) {
			emp = epdao.findById(pid).get();
			emp.setEmp_name(ep.getEmp_name());
			emp.setEmp_role(ep.getEmp_role());
			emp.setEpayment_date(ep.getEpayment_date());
			emp.setEmp_salary(ep.getEmp_salary());
			epdao.save(emp);
			log.info("Employee payment details modified");
			return emp;
		}
		else {
			log.error("Employee payment  not found to modify");
			throw new HmsException("Sorry, Employee Payment with Payment id "+pid+" does not exist");
		}
	}
	
	public EmployeePaymentsDTO getEmpPay(int pid) throws HmsException {
		EmployeePaymentsDTO ep=null;
		if(epdao.existsById(pid)) {
	        Optional<EmployeePaymentsDTO> o=epdao.findById(pid);
		    ep=o.get();
		    log.info("Employee payment searched by id");
		    return ep;
		}
		else {
			log.error("Employee payment not found");
			throw new HmsException("Sorry, Employee Payment with Payment id "+pid+" does not exist");
		}
	}
	
	public List<EmployeePaymentsDTO> getEmpPays(){
        List<EmployeePaymentsDTO> al=epdao.findAll();
        log.info("Employee payments listed");
        return al;
    }
	
	public BookingPaymentsDTO getPayment(int pid) throws HmsException {
		BookingPaymentsDTO bp=null;
		if(bpdao.existsById(pid)) {
	        Optional<BookingPaymentsDTO> o=bpdao.findById(pid);
		    bp=o.get();
		    log.info("Employee payment searched by id");
		    return bp;
		}
		else {
			log.error("Booking payment not found");
			throw new HmsException("Sorry, Booking Payment with Payment id "+pid+" does not exist");
		}
	}
	
	public List<BookingPaymentsDTO> getPayments(){
        List<BookingPaymentsDTO> bp=bpdao.findAll();
        log.info("Employee payments listed");
        return bp;
    }
}
