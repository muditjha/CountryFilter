package com.country.filter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "iso2code",
    "value"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeLevel {

    @JsonProperty("id")
    public String id;
    @JsonProperty("iso2code")
    public String iso2code;
    @JsonProperty("value")
    public String value;

}
