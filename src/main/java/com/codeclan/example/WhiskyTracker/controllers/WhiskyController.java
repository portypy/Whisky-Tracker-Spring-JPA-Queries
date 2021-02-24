package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    // example queries:
    //                  localhost:8080/whiskies?year=1991
    //                  localhost:8080/whiskies?distillery=Macallan&&age=25
    public ResponseEntity<List<Whisky>> findWhiskies(
            @RequestParam (name="year", required = false) Integer year,
            @RequestParam (name="age", required = false) Integer age,
            @RequestParam (name="distillery", required = false) String distillery){
        if (year != null ) {
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        } else if (age != null && distillery != null) {
            return new ResponseEntity<>(whiskyRepository.findWhiskiesByDistilleryNameAndAge(distillery, age), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }


}
