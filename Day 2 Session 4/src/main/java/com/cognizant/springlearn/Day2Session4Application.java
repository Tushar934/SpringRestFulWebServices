package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class Day2Session4Application {

private static final Logger LOGGER = LoggerFactory.getLogger(Day2Session4Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Day2Session4Application.class, args);
		//System.out.println("Running");
//		displayDate();
//		displayCountry();
		//displayCountries();
	}
	
	public static void displayDate() {
		
		LOGGER.info("START");
		 ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		 try {
			Date date=format.parse("11/10/1999");
			LOGGER.debug(date.toString());
			//System.out.println("Date is: "+date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		 LOGGER.info("END");
	}
	
	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.debug("Country : {}", anotherCountry.toString());
	}
	
	public static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");	
		ArrayList<Country> countries=context.getBean("countryList",java.util.ArrayList.class);
		LOGGER.debug("List: {}", countries);
		LOGGER.info("END");
	}
}
