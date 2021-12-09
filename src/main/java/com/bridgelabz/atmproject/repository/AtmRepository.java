package com.bridgelabz.atmproject.repository;

import com.bridgelabz.atmproject.entity.AtmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Purpose: Interface to retrieve the data from the database
 *
 * @author Sunil
 * @since 03/12/2021
 */
@Repository
public interface AtmRepository extends JpaRepository<AtmEntity, Integer> {
}
