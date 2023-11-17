package com.infy.infytvseries.api;


import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.infytvseries.dto.UserDTO;
import com.infy.infytvseries.exception.SeriesBookingException;
import com.infy.infytvseries.service.SeriesBookingService;
@RestController
@RequestMapping(value = "/api")
@Validated
public class SeriesBookingAPI {
    @Autowired
	private SeriesBookingService seriesBookingService;
	
    @PostMapping(value = "/user", consumes = "application/json")
	public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserDTO userDTO) throws SeriesBookingException
	{
		UserDTO dto = seriesBookingService.registerUser(userDTO);
			return new ResponseEntity<UserDTO>(dto, HttpStatus.CREATED);
		
	}
    @GetMapping(value = "/user/{email}")
	public ResponseEntity<UserDTO>getDetailsByUserEmail(@PathVariable @Pattern( regexp = "[A-Za-z0-9]+@(gmail|infy)[.](com)",message = "{user.email.invalid}")@Valid String email) throws SeriesBookingException 
	{
		UserDTO dtos = seriesBookingService.getDetailsByUserEmail(email);
		return new ResponseEntity<UserDTO>(dtos, HttpStatus.OK);
		
		
	}
}
