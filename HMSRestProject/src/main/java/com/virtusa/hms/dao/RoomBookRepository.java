package com.virtusa.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.dto.RoomBookDTO;

@Repository
public interface RoomBookRepository extends JpaRepository<RoomBookDTO, Integer> {

	@Query("select b from RoomBookDTO b where b.cust_mobile=:mbl")
	 public List<RoomBookDTO> viewBooking(@Param("mbl") String mobile);
}
