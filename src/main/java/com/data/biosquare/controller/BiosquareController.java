package com.data.biosquare.controller;

import com.data.biosquare.exception.ResourceNotFoundException;
import com.data.biosquare.model.Biosquare;
import com.data.biosquare.repository.BiosquareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class BiosquareController {

    @Autowired
    private BiosquareRepository biosquareRepository;

        /**************************
         * @return GET all RECORDS
         **************************/

    @GetMapping("/biosquares")
    public List<Biosquare> findAll() {
        return this.biosquareRepository.findAll();
    }

        /***************************
         * @return GET RECORD by ID
         ***************************/

    @GetMapping("/biosquares/{id}")
    public ResponseEntity<Biosquare> findBiosquareById(@PathVariable("id") Long Id) throws ResourceNotFoundException {

        Biosquare biosquare = biosquareRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("biosquare not found for this id"));
        return ResponseEntity.ok(biosquare);
    }

        /****************************
         * @return CREATE new RECORD
         ****************************/

    @PostMapping("/biosquares")
    public Biosquare createBiosquares(@RequestBody Biosquare biosquare) {
        return biosquareRepository.save(biosquare);
    }

        /******************************
         * @return UPDATE exist RECORD
         ******************************/

    @PutMapping("/biosquares/{id}")
    public ResponseEntity<Biosquare> updatedBiosquare(@PathVariable("id") Long Id, @Validated @RequestBody Biosquare biosquareDetails) throws ResourceNotFoundException {
        Biosquare biosquare = biosquareRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("biosquare not found for this id"));

        biosquare.setLandcode(biosquareDetails.getLandcode());
        biosquare.setLandname(biosquareDetails.getLandname());
        biosquare.setRegion(biosquareDetails.getRegion());
        biosquare.setPopulation(biosquareDetails.getPopulation());
        biosquare.setLandarea(biosquareDetails.getLandarea());
        biosquare.setLandmap(biosquareDetails.getLandmap());

        final Biosquare updatedBiosquare = biosquareRepository.save(biosquare);
        return ResponseEntity.ok(updatedBiosquare);
    }

        /************************
         * @return DELETE RECORD
         ************************/

    @DeleteMapping("biosquares/{id}")
    public Map<String,Boolean> deleteBiosquare(@PathVariable("id") Long Id) throws ResourceNotFoundException {

        Biosquare biosquare = biosquareRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("biosquare not found for this id"));

        this.biosquareRepository.delete(biosquare);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);

        return response;
    }

}
