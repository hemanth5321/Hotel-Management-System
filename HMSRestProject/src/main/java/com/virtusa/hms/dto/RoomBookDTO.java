package com.virtusa.hms.dto;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="booking")
public class RoomBookDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int booking_id;
	int room_id;
	String cust_name;
	String cust_mobile;
	String cust_email;
	String cust_aadhar;
	int  cust_count;
	int booking_days;
	String checkin;
	String checkout;
	int bill;
	
	public RoomBookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomBookDTO(int booking_id, int room_id, String cust_name, String cust_mobile, String cust_email,
			String cust_aadhar, int cust_count, int booking_days, String checkin, String checkout, int bill) {
		super();
		this.booking_id = booking_id;
		this.room_id = room_id;
		this.cust_name = cust_name;
		this.cust_mobile = cust_mobile;
		this.cust_email = cust_email;
		this.cust_aadhar = cust_aadhar;
		this.cust_count = cust_count;
		this.booking_days = booking_days;
		this.checkin = checkin;
		this.checkout = checkout;
		this.bill = bill;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_aadhar() {
		return cust_aadhar;
	}

	public void setCust_aadhar(String cust_aadhar) {
		this.cust_aadhar = cust_aadhar;
	}

	public int getCust_count() {
		return cust_count;
	}

	public void setCust_count(int cust_count) {
		this.cust_count = cust_count;
	}

	public int getBooking_days() {
		return booking_days;
	}

	public void setBooking_days(int booking_days) {
		this.booking_days = booking_days;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "RoomBook [booking_id=" + booking_id + ", room_id=" + room_id + ", cust_name=" + cust_name
				+ ", cust_mobile=" + cust_mobile + ", cust_email=" + cust_email + ", cust_aadhar=" + cust_aadhar
				+ ", cust_count=" + cust_count + ", booking_days=" + booking_days + ", checkin=" + checkin
				+ ", checkout=" + checkout + ", bill=" + bill + "]";
	}

	
}
