package com.country.filter.model;
/**
 * @author mudit jha
 *
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
         "id",
         "iso2Code",
         "name",
         "region",
         "adminregion",
         "incomeLevel",
         "lendingType",
         "capitalCity",
         "longitude",
         "latitude" })

public class Country {

@JsonProperty("id")
public String id;
@JsonProperty("iso2Code")
public String iso2Code;
@JsonProperty("name")
public String name;
@JsonProperty("region")
public Region region;
@JsonProperty("adminregion")
public Adminregion adminregion;
@JsonProperty("incomeLevel")
public IncomeLevel incomeLevel;
@JsonProperty("lendingType")
public LendingType lendingType;
@JsonProperty("capitalCity")
public String capitalCity;
@JsonProperty("longitude")
public String longitude;
@JsonProperty("latitude")
public String latitude;

}
