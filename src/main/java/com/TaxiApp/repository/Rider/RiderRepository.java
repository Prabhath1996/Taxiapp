package com.TaxiApp.repository.Rider;

import java.util.List;

import com.TaxiApp.Rider;

public interface RiderRepository {

	 int count();

	    int save(Rider rider);

	    int update(Rider rider);

	    int deleteById(Long id);

	    List<Rider> findAll();
	    
	    List<String> getAllUser();
	 
	}
	

