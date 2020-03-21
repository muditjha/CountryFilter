package com.country.filter.mapper;

import com.country.filter.model.Country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountryResponseMapper {
    public static List<Country> mapResponseEntityArrayToCountyList(Object[] countryArray){
        List<Object> countryList = Arrays.stream(countryArray).skip(1).collect(Collectors.toList());
        return new ArrayList<Country>();
    }
}
