package com.ducninh.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titleTour;
    private int isDate;
    private String content;
    private Long price;
    private String tourPriceIncluded;
    private String tourPriceIsNotIncluded;
    private String tourPriceOfChildren;
    private String surcharge;

    public Tour() {
    }

    public Tour(String titleTour, int isDate, String content, Long price, String tourPriceIncluded, String tourPriceIsNotIncluded, String tourPriceOfChildren, String surcharge) {
        this.titleTour = titleTour;
        this.isDate = isDate;
        this.content = content;
        this.price = price;
        this.tourPriceIncluded = tourPriceIncluded;
        this.tourPriceIsNotIncluded = tourPriceIsNotIncluded;
        this.tourPriceOfChildren = tourPriceOfChildren;
        this.surcharge = surcharge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleTour() {
        return titleTour;
    }

    public void setTitleTour(String titleTour) {
        this.titleTour = titleTour;
    }

    public int getIsDate() {
        return isDate;
    }

    public void setIsDate(int isDate) {
        this.isDate = isDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTourPriceIncluded() {
        return tourPriceIncluded;
    }

    public void setTourPriceIncluded(String tourPriceIncluded) {
        this.tourPriceIncluded = tourPriceIncluded;
    }

    public String getTourPriceIsNotIncluded() {
        return tourPriceIsNotIncluded;
    }

    public void setTourPriceIsNotIncluded(String tourPriceIsNotIncluded) {
        this.tourPriceIsNotIncluded = tourPriceIsNotIncluded;
    }

    public String getTourPriceOfChildren() {
        return tourPriceOfChildren;
    }

    public void setTourPriceOfChildren(String tourPriceOfChildren) {
        this.tourPriceOfChildren = tourPriceOfChildren;
    }

    public String getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(String surcharge) {
        this.surcharge = surcharge;
    }
}
