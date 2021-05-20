package com.shabarecords.farmersmodule.services.farmer;

import com.shabarecords.farmersmodule.dto.FarmerDTO;
import com.shabarecords.farmersmodule.models.farmer.Farmer;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author : Odinga David
 * @since : 5/20/21, Thu
 */
public interface FarmerService {

    Farmer getFarmer(String farmer_id);

    List<Farmer> getAllFarmers(PageRequest request);

    FarmerDTO updateFarmer(FarmerDTO farmer);

    FarmerDTO addFarmer(FarmerDTO farmer);

}
