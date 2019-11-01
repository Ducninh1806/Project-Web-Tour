package com.ducninh.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name =  "province")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String provinceName;

    @OneToMany(targetEntity = Tour.class)
    private List<Tour> tours;

    public Province() {
    }

    public Province(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
}
