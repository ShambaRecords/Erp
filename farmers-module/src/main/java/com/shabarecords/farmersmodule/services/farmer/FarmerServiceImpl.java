package com.shabarecords.farmersmodule.services.farmer;

import com.shabarecords.farmersmodule.config.mappers.DTOEntityMapper;
import com.shabarecords.farmersmodule.dto.FarmerDTO;
import com.shabarecords.farmersmodule.models.farmer.Farmer;
import com.shabarecords.farmersmodule.repository.farmer.FarmerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author : Odinga David
 * @since : 5/20/21, Thu
 */

@Service
@RequiredArgsConstructor
 class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;
    private final DTOEntityMapper mapper;

    @Override
    public Farmer getFarmer(String farmer_id) {
        return farmerRepository.getOne(farmer_id);
    }

    @Override
    public List<Farmer> getAllFarmers(PageRequest request) {
        return farmerRepository.findAll();
    }

    @Override
    public FarmerDTO updateFarmer(FarmerDTO farmer) {
        Assert.notNull(farmer, "Farmer cannot be null");
        Assert.notNull(farmer.getGrowerID(), "Please provide grower ID");

        Farmer toUpdate = getFarmer(farmer.getID());

        mapper.fromFarmerDTO(farmer, toUpdate);

        mapper.fromFarmerEntity(toUpdate, farmer);

        return addFarmer(farmer);
    }

    @Override
    public FarmerDTO addFarmer(FarmerDTO farmer) {

        Farmer farmer1 = new Farmer();
        mapper.fromFarmerDTO(farmer, farmer1);

        farmerRepository.save(farmer1);

        return farmer;
    }
}
