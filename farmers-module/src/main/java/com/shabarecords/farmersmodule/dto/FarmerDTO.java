package com.shabarecords.farmersmodule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shabarecords.farmersmodule.enums.farmer.Gender;
import com.shabarecords.farmersmodule.models.farmer.FarmerContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author : Odinga David
 * @since : 5/20/21, Thu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerDTO {


    @JsonProperty("grower_id")
    private String growerID;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("second_name")
    private String secondName;

    @JsonProperty("ID")
    private String ID;

    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;

    @JsonProperty("date_added")
    private LocalDate dateAdded;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("contact")
    private List<FarmerContact> contact;
}
