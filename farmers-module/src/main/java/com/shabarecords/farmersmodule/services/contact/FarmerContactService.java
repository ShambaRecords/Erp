package com.shabarecords.farmersmodule.services.contact;

import com.shabarecords.farmersmodule.models.farmer.FarmerContact;

import java.util.List;

/**
 * @author : Odinga David
 * @since : 5/20/21, Thu
 */
public interface FarmerContactService {

    List<FarmerContact> getFarmerContact(String farmer_id);

    FarmerContact addContact(FarmerContact contact);


}
