package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.springlearn.service.CountryService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Country;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);
    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public Country getCountryIndia() {

        LOGGER.info("START");

        ApplicationContext springContext =
                new ClassPathXmlApplicationContext("country.xml");

        Country SelectedCountry =
                springContext.getBean("country", Country.class);

        LOGGER.debug("{}", SelectedCountry);

        LOGGER.info("END");

        return SelectedCountry;
     
    }
    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        ApplicationContext springContext =
                new ClassPathXmlApplicationContext("country.xml");

        @SuppressWarnings("unchecked")
        List<Country> allCountries =
                (List<Country>) springContext.getBean("countryList");

        LOGGER.info("END");

        return allCountries;
    }
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        LOGGER.info("START");

        Country selectedCountry = countryService.getCountry(code);

        LOGGER.info("END");

        return selectedCountry;
    }
}
