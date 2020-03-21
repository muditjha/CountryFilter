package com.country.filter.controller;

import com.country.filter.mapper.CountryFilter;
import com.country.filter.mapper.CountryResponseMapper;
import com.country.filter.model.Country;
import com.country.filter.model.CountryFilterResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryFilterController {
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ResponseEntity<List<CountryFilterResponse>> filterCountry (@RequestParam(value = "countrycode") String name,
                                                  @RequestParam(value = "region", required = false) String region,
                                                  @RequestParam(value = "incomeLevel", required = false) String incomeLevel,
                                                  @RequestParam(value = "lendingType", required = false) String lendingType) {
        List<CountryFilterResponse> response = new ArrayList<>();
        if(region==null && incomeLevel==null&&lendingType==null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://api.worldbank.org/v2/country?format=json",Object[].class);
        List<Country> countryList= CountryResponseMapper.mapResponseEntityArrayToCountyList(responseEntity.getBody());
        response = CountryFilter.filterResponsesForCountryList(countryList, region, incomeLevel, lendingType);
        System.out.println(responseEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
