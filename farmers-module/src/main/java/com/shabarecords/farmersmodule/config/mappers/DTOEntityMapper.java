package com.shabarecords.farmersmodule.config.mappers;

import com.shabarecords.farmersmodule.dto.FarmerContactDTO;
import com.shabarecords.farmersmodule.dto.FarmerDTO;
import com.shabarecords.farmersmodule.models.farmer.Farmer;
import com.shabarecords.farmersmodule.models.farmer.FarmerContact;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Odinga David
 * @since : 5/12/21, Wed
 */

@Component
@Mapper(componentModel = "spring")
public interface DTOEntityMapper {

    DTOEntityMapper INSTANCE = Mappers.getMapper(DTOEntityMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromFarmerDTO(FarmerDTO source, @MappingTarget Farmer target);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromFarmerEntity(Farmer source, @MappingTarget FarmerDTO target);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromFarmerContactDTO(FarmerContactDTO source, @MappingTarget FarmerContact target);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromFarmerContactEntity(FarmerContact source, @MappingTarget FarmerContactDTO target);

    List<FarmerContactDTO> map(List<FarmerContact> contacts);
}
