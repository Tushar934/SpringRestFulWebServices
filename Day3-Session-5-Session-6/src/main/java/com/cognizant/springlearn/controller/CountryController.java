package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/countries")
public class CountryController {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(CountryController.class);
	ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");

	@Autowired
	CountryService countryService;
	
	/**
	@GetMapping(value = "/country")
	public ResponseEntity<Country> getCountry() {
		LOGGER.info("Start getCountry()");
		Country c = (Country) ctx.getBean("in");
		LOGGER.info("End getCountry()");
		return new ResponseEntity<Country> (c,HttpStatus.OK);
	}**/

	@GetMapping
	public ResponseEntity<List<Country>> getCountries() {
		LOGGER.info("End getCountries()");
		List<Country> list = (List<Country>) ctx.getBean("countryList");
		LOGGER.info("End getCountries()");
		return new ResponseEntity<List<Country>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<Country> getCountry(@PathVariable("code") String code) throws CountryNotFoundException{
		
		Country country=countryService.getCountry(code);
		if(country!=null) {
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		throw new CountryNotFoundException();
		
	}
	
	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("Start addCountry()");
		/**
		ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
		Validator validator=(Validator) factory.getValidator();
		Set<ConstraintViolation<Country>> violations=validator.validate(country);
		List<String> errors=new ArrayList<String>();
		for(ConstraintViolation<Country> violation : violations) {
			errors.add(violation.getMessage());
		}
		if(errors.size()>0)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.toString());**/
		LOGGER.info(country.toString());
		LOGGER.info("End addCountry()");
		return country;
	}
	
	@PutMapping
	public Country updateCountry(@RequestBody Country country) throws CountryNotFoundException{
		LOGGER.info("Start");
		Country updated=countryService.updateCountry(country);
		LOGGER.info(updated.toString());
		LOGGER.info("End");
		return country;
	}

}
