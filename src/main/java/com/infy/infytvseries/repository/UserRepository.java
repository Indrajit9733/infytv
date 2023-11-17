package com.infy.infytvseries.repository;


import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.infy.infytvseries.entity.User;



public interface UserRepository  extends CrudRepository<User, Integer>{
	
	 List<User> findByEmail(String email);
	List< User >findByEmailAndSeriesName(String email , String seriesName);

}
