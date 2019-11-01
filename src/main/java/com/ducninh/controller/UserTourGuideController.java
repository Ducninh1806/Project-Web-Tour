package com.ducninh.controller;

import com.ducninh.model.UserTourGuide;
import com.ducninh.service.UserTourGuideService;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserTourGuideController {

    @Autowired
    private UserTourGuideService userTourGuideService;

    @GetMapping("/tourGuides")
    public ResponseEntity<List<UserTourGuide>> findAllUserTourGuide(){
        List<UserTourGuide> userTourGuideList =(List<UserTourGuide>) userTourGuideService.findAll();
        if(userTourGuideList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userTourGuideList, HttpStatus.OK);
    }

    @GetMapping("/tourGuide/{id}")
    public ResponseEntity<UserTourGuide> findByIdTourGuide (@PathVariable("id") Long id){
        UserTourGuide userTourGuide = userTourGuideService.findById(id);
        if (userTourGuide == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userTourGuide, HttpStatus.OK);
    }

    @PostMapping("/tourGuide")
    public ResponseEntity<UserTourGuide> createUserTourGuide(@RequestBody UserTourGuide userTourGuide){
        userTourGuideService.save(userTourGuide);
        return new ResponseEntity<>(userTourGuide, HttpStatus.OK);
    }

    @PutMapping("/tourGuide/{id}")
    public ResponseEntity<UserTourGuide> updateUserTourGuide (@PathVariable("id") Long id, @RequestBody UserTourGuide userTourGuide){
        UserTourGuide currentUserTourGuide = userTourGuideService.findById(id);
        if ( currentUserTourGuide == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentUserTourGuide.setFirstName(userTourGuide.getFirstName());
        currentUserTourGuide.setLastName(userTourGuide.getLastName());
        currentUserTourGuide.setAccount(userTourGuide.getAccount());
        currentUserTourGuide.setPassword(userTourGuide.getPassword());
        currentUserTourGuide.setEmail(userTourGuide.getEmail());
        currentUserTourGuide.setAddress(userTourGuide.getAddress());

        return new ResponseEntity<>(currentUserTourGuide, HttpStatus.OK);
    }

    @DeleteMapping("/tourGuide/{id}")
    public ResponseEntity<UserTourGuide> deleteUserTourGuide(@PathVariable Long id){
        UserTourGuide userTourGuide = userTourGuideService.findById(id);
        if (userTourGuide == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userTourGuideService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
