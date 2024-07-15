package com.virtusa.hms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.dto.HotelDTO;

@Repository
public interface HotelRepository extends JpaRepository<HotelDTO, Integer> {
	
	 @Query("select h from HotelDTO h where h.hotel_name=:h1")
	 public Optional<HotelDTO> getHotelByName(@Param("h1") String hname);

	 @Query("select h from HotelDTO h where h.hotel_name=:h1")
	 public HotelDTO getHotelName(@Param("h1") String hname);
	 
}
