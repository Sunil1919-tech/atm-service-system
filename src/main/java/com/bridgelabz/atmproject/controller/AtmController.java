package com.bridgelabz.atmproject.controller;

import com.bridgelabz.atmproject.dto.AtmDto;
import com.bridgelabz.atmproject.service.AtmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose: this class is to perform various HTTP methods
 *
 * @author Sunil
 * @since 03/12/2021
 */
@Slf4j
@Controller
@RequestMapping(value = "/atm")
public class AtmController {

    @Autowired
    private AtmService atmService;

    /**
     * purpose: to get all the atm card details from the dataBase using @GetMapping method
     *
     * @return: atmService to list of atm card details
     */
    @GetMapping(value = "/atm")
    public ResponseEntity<List<AtmDto>> getAllAtm() {
        log.info("All the Atm records in the Database");
        return new ResponseEntity<>(atmService.getAllAtm(), HttpStatus.OK);
    }

    /**
     * Purpose: to store or add data into the dataBase using @PostMapping Http method and validating the atmDto
     *
     * @param atmDto: this class initialized with the atm parameters
     * @return :AtmService to add atm details
     */
    @PostMapping(value = "/atm")
    public ResponseEntity<String> addAtm(@Valid @RequestBody AtmDto atmDto) {
        log.info("Uploaded the Atm details in the database");
        return new ResponseEntity<>(atmService.addAtm(atmDto), HttpStatus.OK);
    }

    /**
     * Purpose: to Update the data from the dataBase using @PutMapping Http method
     *
     * @param id:    integer value,  the atmEntity where we assign the atmCard details to particular ID
     * @param atmDto : class initialized with the atm parameters
     * @return : atmService to Updated data
     */
    @PutMapping("/atm/{id}")
    public ResponseEntity<String> editAtm(
            @PathVariable(value = "id") int id,
            @RequestBody AtmDto atmDto
    ) {
        log.info("Updated the Atm details of given id in Atm System");
        return new ResponseEntity<>(atmService.updateAtm(id, atmDto), HttpStatus.OK);
    }

    /**
     * Purpose: to delete the data from the dataBase Using the ID
     *
     * @param id: integer value,  the atmEntity where we assign the atmCard details to particular ID
     * @return: atmService to delete the data from the dataBase
     */
    @DeleteMapping(value = "/atm/{id}")
    public ResponseEntity<String> deleteAtmCard(
            @PathVariable(value = "id") int id
    ) {
        log.info("Deleted Atm details of given ID ");
        return new ResponseEntity<>(atmService.deleteCardDetails(id), HttpStatus.OK);
    }
}
