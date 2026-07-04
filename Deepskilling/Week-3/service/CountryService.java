package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;

@Service
public class CountryService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryService.class);

    @SuppressWarnings("unchecked")
    public Country getCountry(String code) {

        LOGGER.info("Searching country for code {}", code);

        ApplicationContext springContext =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countryList =
                (List<Country>) springContext.getBean("countryList");

        for (Country currentCountry : countryList) {

            if (currentCountry.getCode().equalsIgnoreCase(code)) {
                return currentCountry;
            }
        }
        return null;
    }
}