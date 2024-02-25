package com.example.liveasy.liveasybackend.controllers;


import com.example.liveasy.liveasybackend.entities.Load;
import com.example.liveasy.liveasybackend.repos.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadRepository loadRepoInstance;

    //save a payload
    @PostMapping
    public String saveLoad(@RequestBody Load payload) {
        loadRepoInstance.save(payload);
        return "loads details added successfully";
    }

    //Get all loads by shipperId
    @GetMapping
    public List<Load> getAllLoads(@RequestParam UUID shipperId) {
        if (loadRepoInstance == null) {
            return null;
        }
        return loadRepoInstance.findByShipperId(shipperId);
    }

    //get a payload by loadId
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
        Optional<Load> load = loadRepoInstance.findById(loadId);
        if (load.isPresent()) {
            return ResponseEntity.ok(load.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //update a payload by loadId
    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable Long loadId, @RequestBody Load updatedLoad) {

        // Check if load exists with the given ID
        Optional<Load> existingLoad = loadRepoInstance.findById(loadId);
        if (!existingLoad.isPresent()) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if not found
        }

        // Update only the fields that are provided in the request body
        Load loadToUpdate = existingLoad.get();
        if (updatedLoad.getLoadingPoint() != null) {
            loadToUpdate.setLoadingPoint(updatedLoad.getLoadingPoint());
        }
        if (updatedLoad.getUnloadingPoint() != null) {
            loadToUpdate.setUnloadingPoint(updatedLoad.getUnloadingPoint());
        }
        if (updatedLoad.getProductType() != null) {
            loadToUpdate.setProductType(updatedLoad.getProductType());
        }
        if (updatedLoad.getTruckType() != null) {
            loadToUpdate.setTruckType(updatedLoad.getTruckType());
        }
        if (updatedLoad.getNoOfTrucks() != 0) { // Check for non-zero value
            loadToUpdate.setNoOfTrucks(updatedLoad.getNoOfTrucks());
        }
        if (updatedLoad.getWeight() != 0) { // Check for non-zero value
            loadToUpdate.setWeight(updatedLoad.getWeight());
        }
        if (updatedLoad.getComment() != null) {
            loadToUpdate.setComment(updatedLoad.getComment());
        }
        if (updatedLoad.getShipperId() != null) {
            loadToUpdate.setShipperId(updatedLoad.getShipperId());
        }
        if (updatedLoad.getDate() != null) {
            loadToUpdate.setDate(updatedLoad.getDate());
        }

        // Save the updated load
        Load savedLoad = loadRepoInstance.save(loadToUpdate);
        return ResponseEntity.ok(savedLoad);
    }

    //delete a payload
    @DeleteMapping("/{loadId}")
    public List<Load> deleteLoad(@PathVariable Long loadId) {
        loadRepoInstance.deleteById(loadId);
        return loadRepoInstance.findAll();

    }

}
