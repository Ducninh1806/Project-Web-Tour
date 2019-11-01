package com.ducninh.service;

import com.ducninh.model.UserTourGuide;

public interface UserTourGuideService {

    Iterable<UserTourGuide> findAll();

    UserTourGuide findById(Long id);

    void save (UserTourGuide userTourGuide);

    void remove(Long id);


}
