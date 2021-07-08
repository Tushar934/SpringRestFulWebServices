package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("")
public class CountryController {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(CountryController.class);
	ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");

	@Autowired
	CountryService countryService;
	
	@GetMapping(value = "/country")
	public Country getCountry() {
		LOGGER.info("Start");
		Country c = (Country) ctx.getBean("in");
		LOGGER.info("End");
		return c;
	}

	@GetMapping("/countries")
	public List<Country> getCountries() {
		LOGGER.info("End");
		List<Country> list = (List<Country>) ctx.getBean("countryList");
		LOGGER.info("End");
		return list;
	}
	
	@GetMapping(value="/countries/{code}")
	public ResponseEntity<Country> getCountry(@PathVariable("code") String code) throws CountryNotFoundException{
		
		Country country=countryService.getCountry(code);
		if(country!=null) {
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		throw new CountryNotFoundException();
		
	}

}
