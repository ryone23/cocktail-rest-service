package com.cocktailbar.cocktail_service.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "drinks")
public class Drink implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drink_id_seq")
    @SequenceGenerator(name = "drink_id_seq", sequenceName = "drink_seq", allocationSize = 1)
    private Long drink_id;

    private String drink_name;
    private String drink_desc;
    private String drink_glass;
    private String drink_mix_method;
    private boolean drink_strain;
    private boolean drink_ice_in_glass;
    private boolean drink_isIBA;

    Drink () {}

    Drink(String drink_name, String drink_desc, String drink_glass,
          String drink_mix_method, boolean drink_strain,
          boolean drink_ice_in_glass, boolean drink_isIBA) {

        this.drink_name = drink_name;
        this.drink_desc = drink_desc;
        this.drink_glass = drink_glass;
        this.drink_mix_method = drink_mix_method;
        this.drink_strain = drink_strain;
        this.drink_ice_in_glass = drink_ice_in_glass;
        this.drink_isIBA = drink_isIBA;
    }

    public Long getDrinkId() {
        return drink_id;
    }

    public String getDrinkName() {
        return drink_name;
    }

    public String getDrinkDesc() {
        return drink_desc;
    }

    public String getDrinkGlass() {
        return drink_glass;
    }

    public String getDrinkMixMethod() {
        return drink_mix_method;
    }

    public boolean isDrinkStrain() {
        return drink_strain;
    }

    public boolean isDrinkIceInGlass() {
        return drink_ice_in_glass;
    }

    public boolean isDrinkIsIBA() {
        return drink_isIBA;
    }

    public void setDrinkId(Long drink_id) {
        this.drink_id = drink_id;
    }

    public void setDrinkName(String drink_name) {
        this.drink_name = drink_name;
    }

    public void setDrinkDesc(String drink_desc) {
        this.drink_desc = drink_desc;
    }

    public void setDrinkGlass(String drink_glass) {
        this.drink_glass = drink_glass;
    }

    public void setDrinkMixMethod(String drink_mix_method) {
        this.drink_mix_method = drink_mix_method;
    }

    public void setDrinkStrain(boolean drink_strain) {
        this.drink_strain = drink_strain;
    }

    public void setDrinkIceInGlass(boolean drink_ice_in_glass) {
        this.drink_ice_in_glass = drink_ice_in_glass;
    }

    public void setDrinkIsIBA(boolean drink_isIBA) {
        this.drink_isIBA = drink_isIBA;
    }

    @Override
    public boolean equals(Object o) {

        if(this == o)
            return true;
        if (!(o instanceof Drink))
            return false;
        Drink drink = (Drink) o;
        return  Objects.equals(this.drink_id, drink.drink_id) &&
                Objects.equals(this.drink_name, drink.drink_name) &&
                Objects.equals(this.drink_desc, drink.drink_desc) &&
                Objects.equals(this.drink_glass, drink.drink_glass) &&
                Objects.equals(this.drink_mix_method, drink.drink_mix_method) &&
                Objects.equals(this.drink_strain, drink.drink_strain) &&
                Objects.equals(this.drink_ice_in_glass, drink.drink_ice_in_glass) &&
                Objects.equals(this.drink_isIBA, drink.drink_isIBA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.drink_id, this.drink_name, this.drink_desc,
                this.drink_glass, this.drink_mix_method, this.drink_strain,
                this.drink_ice_in_glass, this.drink_isIBA);
    }

    @Override
    public String toString() {
        return "Drink{" + "id=" + this.drink_id + ", name='"
                + this.drink_name + '\'' + ", description='" +
                this.drink_desc + '\'' + ", glass ='" +
                this.drink_glass + '\'' + ", mix method='" +
                this.drink_mix_method + '\'' + ", strain='" +
                this.drink_strain + '\'' + ", ice in glass='" +
                this.drink_ice_in_glass + '\'' + ", is IBA='" +
                this.drink_isIBA + '\'' + '}';
    }


}