package com.ducninh.service.impl;

import com.ducninh.model.UserTourGuide;
import com.ducninh.repository.UserTourGuideRepository;
import com.ducninh.service.UserTourGuideService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTourGuideServiceImpl implements UserTourGuideService {

    @Autowired
    private UserTourGuideRepository userTourGuideRepository;

    @Override
    public Iterable<UserTourGuide> findAll() {
        return userTourGuideRepository.findAll();
    }

    @Override
    public UserTourGuide findById(Long id) {
        return userTourGuideRepository.findOne(id);
    }

    @Override
    public void save(UserTourGuide userTourGuide) {
            userTourGuideRepository.save(userTourGuide);
    }

    @Override
    public void remove(Long id) {
        userTourGuideRepository.delete(id);
    }
}
