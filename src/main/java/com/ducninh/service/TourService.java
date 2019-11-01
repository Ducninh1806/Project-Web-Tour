package com.ducninh.service;

import com.ducninh.model.Tour;

public interface TourService {

    Iterable<Tour> findAll();

    Tour findById(Long id);

    void save(Tour tour);

    void remove(Long id);





}
