package com.shabarecords.farmersmodule.models.farmer;

import com.shabarecords.farmersmodule.enums.farmer.Gender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author : Odinga David
 * @since : 5/16/21, Sun
 */

@Data
@Entity
public class Farmer {
    @Id
    private String growerID;

    private String firstName;

    private String secondName;

    private String ID;

    private LocalDate dateOfBirth;

    private LocalDate dateAdded;

    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @OneToMany()
//    private List<FarmerContact> contact;
}
