package com.shabarecords.farmersmodule.controller.farmer;

import com.shabarecords.farmersmodule.config.mappers.DTOEntityMapper;
import com.shabarecords.farmersmodule.dto.FarmerContactDTO;
import com.shabarecords.farmersmodule.dto.FarmerDTO;
import com.shabarecords.farmersmodule.models.farmer.Farmer;
import com.shabarecords.farmersmodule.models.farmer.FarmerContact;
import com.shabarecords.farmersmodule.services.contact.FarmerContactService;
import com.shabarecords.farmersmodule.services.farmer.FarmerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Odinga David
 * @since : 5/20/21, Thu
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/farmers")
public class FarmerController {

    private final FarmerService farmerService;
    private final FarmerContactService contactService;
    private final DTOEntityMapper mapper;

    @GetMapping("/{farmer_id}")
    public ResponseEntity<Farmer> viewFarmer(@PathVariable String farmer_id) {
        return new ResponseEntity<>(farmerService.getFarmer(farmer_id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Farmer>> viewAllFarmer(@RequestParam int page, @RequestParam int size) {

        List<Farmer> farmers = farmerService.getAllFarmers(PageRequest.of(page, size));
        return new ResponseEntity<>(farmers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FarmerDTO> addFarmer(@RequestBody FarmerDTO farmer) {

        return new ResponseEntity<>(farmerService.addFarmer(farmer), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<FarmerDTO> updateFarmer(@RequestBody FarmerDTO farmer) {

        return new ResponseEntity<>(farmerService.updateFarmer(farmer), HttpStatus.OK);
    }


    @PostMapping("/{farmer_id}/add-contact")
    public ResponseEntity<FarmerContactDTO> addFarmerContact(
            @RequestBody FarmerContactDTO farmer_contact,
            @PathVariable String farmer_id){

        Farmer  farmer = viewFarmer(farmer_id).getBody();

        FarmerContact contact = new FarmerContact();
        mapper.fromFarmerContactDTO(farmer_contact, contact);

        contact.setFarmer(farmer);

        contact = contactService.addContact(contact);

        mapper.fromFarmerContactEntity(contact, farmer_contact);

        return new ResponseEntity<>(farmer_contact, HttpStatus.OK);
    }


    @GetMapping("/{farmer_id}/add-contact")
    public ResponseEntity<List<FarmerContactDTO>> getFarmerContacts(@PathVariable String farmer_id){

        List<FarmerContact>  contacts = contactService.getFarmerContact(farmer_id);

        return new ResponseEntity<>(mapper.map(contacts), HttpStatus.OK);
    }



}
