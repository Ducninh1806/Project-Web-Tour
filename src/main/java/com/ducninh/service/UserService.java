package com.ducninh.service;

import com.ducninh.model.User;

public interface UserService  {

    Iterable<User>findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);




}
