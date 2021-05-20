package com.shabarecords.farmersmodule.dto;

import com.shabarecords.farmersmodule.enums.farmer.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author : Odinga David
 * @since : 5/20/21, Thu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerContactDTO {

    private BigDecimal code;

    private String value;

    private ContactType type;
}
