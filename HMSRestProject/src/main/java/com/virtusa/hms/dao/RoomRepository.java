package com.virtusa.hms.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.virtusa.hms.dto.RoomDTO;

public interface RoomRepository extends JpaRepository<RoomDTO, Integer> {
	
	@Query("select room_rent from RoomDTO where room_id=:rent")
	 public int getRent(int rent);
	
	@Query("select status from RoomDTO where room_id=:rent")
	 public String getStatus(int rent);
	
	@Transactional
	@Modifying
	@Query("update RoomDTO set status='booked' where room_id=:rent")
	 public void changeStatus(int rent);
	
	@Transactional
	@Modifying
	@Query("update RoomDTO set status='available' where room_id=:rent")
	 public void changeStatuss(int rent);

}
