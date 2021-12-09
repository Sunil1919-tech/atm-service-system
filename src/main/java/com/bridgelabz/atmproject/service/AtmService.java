package com.bridgelabz.atmproject.service;

import com.bridgelabz.atmproject.dto.AtmDto;
import com.bridgelabz.atmproject.entity.AtmEntity;
import com.bridgelabz.atmproject.repository.AtmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Purpose: to demonstrate service operations of the atm
 *
 * @author Sunil
 * @since 03/12/2021
 */
@Service
@RestController
public class AtmService {
    private static final String ADDED_SUCCESSFULLY = "Atm added Successfully";
    private static final String ATM_UPDATED_SUCCESSFULLY = "Atm details Updated..!";
    private static final String CARD_DELETED = "Atm Card Deleted Successfully";

    @Autowired
    private AtmRepository atmRepo;

    @Autowired
    private ModelMapper mapper;

    /**
     * purpose: method to get all atm details that have been added to the dataBase
     *
     * @return List of the atmRecords
     */
    public List<AtmDto> getAllAtm() {
        return atmRepo
                .findAll()
                .stream()
                .map(atmEntity -> mapper.map(atmEntity, AtmDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Purpose: method to Add the atm Entity into the dataBase
     *
     * @param atmDto : class initialized with the atm parameters
     * @return : atmEntity that we have added
     */
    public String addAtm(AtmDto atmDto) {
        AtmEntity atmEntity = mapper.map(atmDto, AtmEntity.class);
        atmRepo.save(atmEntity);
        return ADDED_SUCCESSFULLY;
    }

    /**
     * method to update the Atm Entity from the database using ID to find the entity
     *
     * @param id:    int value to find the required entity to Update
     * @param atmDto : class initialized with the atm parameters
     * @return: atmEntity
     */
    public String updateAtm(int id, AtmDto atmDto) {
        Optional<AtmEntity> atmCardList = atmRepo.findById(id);
        if (atmCardList.isPresent()) {
            AtmEntity atmEntity = atmCardList.get();
            mapper.map(atmDto, atmEntity);
            atmRepo.save(atmEntity);
            return ATM_UPDATED_SUCCESSFULLY;
        }
        return "there is no such card with id : " + id;
    }

    /**
     * method to delete the atmEntity from the dataBase using Id
     *
     * @param id: int value to find the required entity to Delete
     * @return: deleted message
     */
    public String deleteCardDetails(int id) {
        AtmEntity deleteCard = atmRepo.findById(id).get();
        atmRepo.delete(deleteCard);
        return CARD_DELETED;
    }
}