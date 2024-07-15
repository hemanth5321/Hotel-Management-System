package com.virtusa.hms.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.virtusa.hms.dto.ErrorInfoDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(HmsException.class)
	public @ResponseBody ErrorInfoDTO getHmsException(HmsException e,HttpServletRequest req) {
		
		return new ErrorInfoDTO(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		
	}

}
