package com.TaxiApp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.TaxiApp.Rider;
import com.TaxiApp.repository.Rider.JdbcRiderRepository;
import com.TaxiApp.repository.Rider.RiderRepository;


@RestController
@CrossOrigin
@RequestMapping
public class RiderController {
	@Autowired
	RiderRepository riderRepository;
	@Autowired
	JdbcRiderRepository jrb;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Qualifier("jdbcRiderRepository") // Test JdbcTemplate

	@GetMapping(path = "/")
	String test() {

		return "testing";
	}
	
	// add rider
	@PostMapping(path = "rider/addrider")
	void createRider(@RequestBody Rider rider) {

		riderRepository.save(rider);
	}

	// view all riders
	@GetMapping(path = "rider/viewallrider")
	public List<Rider> getalluser() {

		return riderRepository.findAll();

	}

	// add rider
		@PostMapping(path = "rider/update")
		public String UpdateRider(Rider rider) {
			try {
				//book.setPrice(new BigDecimal("99.99"));
		    rider.setName("madu");	
			riderRepository.update(rider);
			return "update user";
			}
			catch(Exception e) {
				return "Update fail";
			}
		}
}
