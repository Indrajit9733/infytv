package com.infy.infytvseries.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.infytvseries.dto.UserDTO;
import com.infy.infytvseries.entity.User;
import com.infy.infytvseries.exception.SeriesBookingException;
import com.infy.infytvseries.repository.UserRepository;
import com.infy.infytvseries.validator.UserValidator;
@Service(value = "")
@Transactional
public class SeriesBookingServiceImpl implements SeriesBookingService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO registerUser(UserDTO userDTO) throws SeriesBookingException {
		UserValidator.validateUser(userDTO);
	List<User> users =	userRepository.findByEmailAndSeriesName(userDTO.getEmail(), userDTO.getSeriesName());
	if(users != null) {
		throw new SeriesBookingException("Service.USER_ALREADY_PRESENT");
	}
		
		User u = new User();
		u.setEmail(userDTO.getEmail());
		u.setUserName(userDTO.getSeriesName());
		u.setRegDate(userDTO.getRegDate());
		u.setSeriesName(userDTO.getSeriesName());
		u.setSeriesType(userDTO.getSeriesType());		
		 userRepository.save(u);
		 userDTO.setRegistrationId(u.getRegistrationId());
		 return userDTO;
		 
	}
	
	
	

	@Override
	public UserDTO getDetailsByUserEmail(String email) throws SeriesBookingException {
		// TODO Auto-generated method stub
		return null;
	}

}
