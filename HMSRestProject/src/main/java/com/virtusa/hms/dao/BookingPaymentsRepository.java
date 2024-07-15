package com.virtusa.hms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.dto.BookingPaymentsDTO;

@Repository
public interface BookingPaymentsRepository extends JpaRepository<BookingPaymentsDTO, Integer> {
	
	@Query("select sum(payment_amount) from BookingPaymentsDTO where payment_date between :sd and :ed")
	public String getSunByRange(@Param("sd") String sd,@Param("ed") String ed);
	
	@Query("select sum(payment_amount) from BookingPaymentsDTO")
	public String getSum();

}
