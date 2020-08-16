package com.cocktailbar.cocktail_service.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "garnishes")
public class Garnish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garnish_id_seq")
    @SequenceGenerator(name = "garnish_id_seq", sequenceName = "garn_seq", allocationSize = 1)
    @Column(name = "garnish_id")
    private Long garnish_id;

    @Column(name = "garnish_name")
    private String garnish_name;

    @Column(name = "garnish_category")
    private String garnish_category;

    Garnish() {}

    Garnish(String garnish_name,String garnish_category) {
        this.garnish_name = garnish_name;
        this.garnish_category = garnish_category;
    }

    public Long getGarnishId() {
        return this.garnish_id;
    }

    public String getGarnishName() {
        return this.garnish_name;
    }

    public String getGarnishCategory() {
        return this.garnish_category;
    }

    public void setGarnishId(Long ingredient_id) {
        this.garnish_id = ingredient_id;
    }

    public void setGarnishName(String ingredient_name) {
        this.garnish_name = ingredient_name;
    }

    public void setGarnishCategory(String ingredient_category) {
        this.garnish_category = ingredient_category;
    }

    @Override
    public boolean equals(Object o) {

        if(this == o)
            return true;
        if (!(o instanceof Garnish))
            return false;
        Garnish garnish = (Garnish) o;
        return Objects.equals(this.garnish_id, garnish.garnish_id) &&
                Objects.equals(this.garnish_name, garnish.garnish_name) &&
                Objects.equals(this.garnish_category, garnish.garnish_category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.garnish_id, this.garnish_name, this.garnish_category);
    }

    @Override
    public String toString() {
        return "Ingredient{" + "id=" + this.garnish_id + ", name='"
                + this.garnish_name + '\'' + ", category='" +
                this.garnish_category + '\'' + '}';
    }
}