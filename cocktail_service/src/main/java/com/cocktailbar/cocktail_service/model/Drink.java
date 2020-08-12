package com.cocktailbar.cocktail_service.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "drinks")
public class Drink {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long drink_id;


}