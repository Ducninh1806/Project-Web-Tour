package com.ducninh.service.impl;

import com.ducninh.model.Tour;
import com.ducninh.repository.TourRepository;
import com.ducninh.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;

public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public Iterable<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public Tour findById(Long id) {
        return tourRepository.findOne(id);
    }

    @Override
    public void save(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public void remove(Long id) {
        tourRepository.delete(id);
    }
}
