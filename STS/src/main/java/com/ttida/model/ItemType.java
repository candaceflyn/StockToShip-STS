package com.ttida.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_type")
public class ItemType {

    @Id
    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @Column(name = "category")
    private String category;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "country_origin")
    private String countryOrigin;

    public ItemType() {
    }

    public ItemType(String itemCode, String description, String unitOfMeasure, String category,
                    String dimensions, String manufacturer, String countryOrigin) {
        this.itemCode = itemCode;
        this.description = description;
        this.unitOfMeasure = unitOfMeasure;
        this.category = category;
        this.dimensions = dimensions;
        this.manufacturer = manufacturer;
        this.countryOrigin = countryOrigin;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }
}
