package com.infy.infytvseries.validator;

import java.time.LocalDate;

import com.infy.infytvseries.dto.UserDTO;
import com.infy.infytvseries.exception.SeriesBookingException;

public class UserValidator {
	
	public UserValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void validateUser(UserDTO userDTO) throws SeriesBookingException
	{
	 if(!isValidRegDate(userDTO.getRegDate())) {
		 throw new SeriesBookingException("UserValidator.INVALID_REG_DATE");
	 }
	}

	public static Boolean isValidRegDate(LocalDate regDate) {
//		if((regDate.isAfter(LocalDate.now().plusDays(10))  && regDate.isBefore(LocalDate.now()))){
//			return false;
//		}
//		else {
//			return 
//					true;
//		}
	  
		LocalDate today = LocalDate.now();
		
		if(regDate.isAfter(today.plusDays(10)) || regDate.isBefore(today)) {
			return false;
		}
		else {
			return 
					true;
		}
	}
}
