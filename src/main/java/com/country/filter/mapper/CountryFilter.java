package com.country.filter.mapper;

import com.country.filter.model.Country;
import com.country.filter.model.CountryFilterResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountryFilter {
    public static List<CountryFilterResponse> filterResponsesForCountryList(List<Country> countryList,String region,
                                                                            String incomeLevel, String lendingType){
        List<CountryFilterResponse> countryFilterResponse= new ArrayList<>();
        List<Country> filteredCountryList = new ArrayList<>();

        if(region!=null){
            Predicate<Country> byRegion = country -> country.getRegion().value.equals(region);
            filteredCountryList = countryList.stream().filter(byRegion).collect(Collectors.toList());
        }
        if(incomeLevel!=null){
            Predicate<Country> byIncomeLevel = country -> country.getIncomeLevel().value.equals(incomeLevel);
            filteredCountryList = countryList.stream().filter(byIncomeLevel).collect(Collectors.toList());
        }
        if(lendingType!=null){
            Predicate<Country> byLendingType = country -> country.getLendingType().value.equals(lendingType);
            filteredCountryList = countryList.stream().filter(byLendingType).collect(Collectors.toList());
        }

        for(Country country: filteredCountryList){
            CountryFilterResponse response = new CountryFilterResponse();
            response.setCapital(country.getCapitalCity());
            response.setCountry(country.getName());
            countryFilterResponse.add(response);
        }
        return countryFilterResponse;
    }
}
