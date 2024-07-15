package com.virtusa.hms.dto;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="room")
public class RoomDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int room_id;
	String room_number;
	String room_type;
	String room_description;
	int room_rent;
	String status;
	
	
	public RoomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomDTO(int room_id, String room_number, String room_type, String room_description, int room_rent,
			String status) {
		super();
		this.room_id = room_id;
		this.room_number = room_number;
		this.room_type = room_type;
		this.room_description = room_description;
		this.room_rent = room_rent;
		this.status = status;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getRoom_description() {
		return room_description;
	}

	public void setRoom_description(String room_description) {
		this.room_description = room_description;
	}

	public int getRoom_rent() {
		return room_rent;
	}

	public void setRoom_rent(int room_rent) {
		this.room_rent = room_rent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_number=" + room_number + ", room_type=" + room_type
				+ ", room_description=" + room_description + ", room_rent=" + room_rent + ", status=" + status + "]";
	}

	
}
