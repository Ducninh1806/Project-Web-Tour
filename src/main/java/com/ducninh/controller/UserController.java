package com.ducninh.controller;

import com.ducninh.model.Tour;
import com.ducninh.model.User;
import com.ducninh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> userList(){
        List<User> users = (List<User>) userService.findAll();
        if (users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id ){
        User user = userService.findById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user ){
        User currentUser = userService.findById(id);
        if (currentUser == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setAccount(user.getAccount());
        currentUser.setPassword(user.getPassword());
        currentUser.setEmail(user.getEmail());

        userService.save(currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Tour> deleteUser(@PathVariable Long id){
        User user = userService.findById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
