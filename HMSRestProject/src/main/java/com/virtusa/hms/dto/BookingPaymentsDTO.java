package com.virtusa.hms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookpayment")
public class BookingPaymentsDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int payment_id;
	int booking_id;
	int hotel_id;
	int room_id;
	int payment_amount;
	String payment_date;
	String payment_type;
	
	public BookingPaymentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingPaymentsDTO(int payment_id, int booking_id, int hotel_id, int room_id, int payment_amount,
			String payment_date, String payment_type) {
		super();
		this.payment_id = payment_id;
		this.booking_id = booking_id;
		this.hotel_id = hotel_id;
		this.room_id = room_id;
		this.payment_amount = payment_amount;
		this.payment_date = payment_date;
		this.payment_type = payment_type;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	@Override
	public String toString() {
		return "BookingPayments [payment_id=" + payment_id + ", booking_id=" + booking_id + ", hotel_id=" + hotel_id
				+ ", room_id=" + room_id + ", payment_amount=" + payment_amount + ", payment_date=" + payment_date
				+ ", payment_type=" + payment_type + "]";
	}
	
	
}
