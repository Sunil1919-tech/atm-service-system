package com.bridgelabz.atmproject.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * Purpose: to manage the entities in the database
 *
 * @author Sunil
 * @since 03/12/2021
 */
@Entity
@Table(name = "atm")
@Data
public class AtmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(unique = true)
    @Pattern(regexp = "^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$",
            message = "Not Valid!!, Card Number Should be 16 digits")
    private String cardNumber;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]{3,15}$", message = "Card name not valid, min characters should be 3 ")
    private String cardName;

    @NotNull
    @Pattern(regexp = "^[0-9]{3}$", message = "Invalid..!, CVV should be 3 digits")
    private String cvv;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
