package com.virtusa.hms.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import com.virtusa.hms.dto.EmpCredDTO;
import com.virtusa.hms.dto.EmployeeDTO;
import com.virtusa.hms.dto.EmployeePaymentsDTO;
import com.virtusa.hms.dto.HotelDTO;
import com.virtusa.hms.dto.RoomDTO;
import com.virtusa.hms.exception.HmsException;
import com.virtusa.hms.service.IAdminService;

@RestController
@RequestMapping("/admincontrol")
public class AdminController {
	
	Log log= LogFactory.getLog(AdminController.class);
	
	@Autowired
	IAdminService service;
	
	@GetMapping("getsumrange/{sd}/{ed}")
	public String getSunByRange(@PathVariable("sd") String sd,@PathVariable("ed") String ed) {
		return service.getSunByRange(sd, ed);
	}
	
	@GetMapping("getsum")
	public String getSum() {
		return service.getSum();
	}
	
	@PostMapping("addhotel")
	public HotelDTO addHotel(@RequestBody HotelDTO h) {
		service.addHotel(h);
		return h;
	}
	 
	@GetMapping("gethotelid/{hid}")
	public HotelDTO getHotelById(@PathVariable("hid") int hid) throws HmsException {
	    return service.getHotel(hid);
	}
	
	@GetMapping("gethotels")
	public List<HotelDTO> getHotels() {
		log.info("Hotels are viewed");
		return service.getHotels();
	}
	
	@DeleteMapping("delhotel/{hid}")
	public HotelDTO delHotel(@PathVariable("hid") int hid) throws HmsException {
	    return service.deleteHotel(hid);
	}
	 
	@PutMapping("modhotel/{hid}")
	public HotelDTO modifyHotel(@PathVariable("hid") int hid,@RequestBody HotelDTO h) throws HmsException {
		return service.modifyHotel(hid,h);
	}
	 
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
	
	@PutMapping("addemployee/{hid}")
	public EmployeeDTO addEmployee(@PathVariable("hid") int hid, @RequestBody EmployeeDTO e) throws HmsException {
		service.addEmployee(hid,e);
		return e;
	}
		 
	@GetMapping("getemployeeid/{eid}")
	public EmployeeDTO getEmployeeById(@PathVariable("eid") int eid) throws HmsException {
         return service.getEmployee(eid);
	}
		
	@GetMapping("getemployees")
	public List<EmployeeDTO> getEmployees() {
		return service.getEmployees();
	}
		
	@DeleteMapping("delemployee/{eid}")
	public EmployeeDTO delEmployee(@PathVariable("eid") int eid) throws HmsException {
		return service.deleteEmployee(eid);
	}
		 
	@PutMapping("modemployee/{eid}")
	public EmployeeDTO modifyEmployee(@PathVariable("eid") int eid,@RequestBody EmployeeDTO e) throws HmsException {
		return service.modifyEmployee(eid,e);
	}
	
	@PutMapping("modempcred/{rid}")
	public EmpCredDTO modifyEmpCred(@PathVariable("rid") int rid,@RequestBody EmpCredDTO e) throws HmsException {
		return service.modifyEmpCred(rid,e);
	}
	
	@PutMapping("addempcred")
	public EmpCredDTO addEmpCred(@RequestBody EmpCredDTO e) {
		service.addEmpCred(e);
		return e;
	}
	
	@PutMapping("addemppay/{eid}")
	public EmployeePaymentsDTO addEmpPay(@PathVariable("eid") int eid, @RequestBody EmployeePaymentsDTO ep) throws HmsException {
		service.addEmpPay(eid,ep);
		return ep;
	}
	
	@GetMapping("getemppayid/{eid}")
	public EmployeePaymentsDTO getEmpPayById(@PathVariable("eid") int pid) throws HmsException {
         return service.getEmpPay(pid);
	}
		
	@GetMapping("getemppays")
	public List<EmployeePaymentsDTO> getEmppays() {
		return service.getEmpPays();
	}
		
	@DeleteMapping("delemppay/{pid}")
	public EmployeePaymentsDTO delEmpPay(@PathVariable("pid") int pid) throws HmsException {
		return service.deleteEmppay(pid);
	}
		 
	@PutMapping("modemppay/{pid}")
	public EmployeePaymentsDTO modifyEmpPays(@PathVariable("pid") int pid,@RequestBody EmployeePaymentsDTO ep) throws HmsException {
		return service.modifyEmpPay(pid, ep);
	}
	
	@GetMapping("getpaymentid/{pid}")
	public BookingPaymentsDTO getPaymentById(@PathVariable("pid") int pid) throws HmsException {
	    return service.getPayment(pid);
	}
	
	@GetMapping("getpayments")
	public List<BookingPaymentsDTO> getPayments() {
		return service.getPayments();
	}
}