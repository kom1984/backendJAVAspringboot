package com.parkauto.parkauto.controller;

import com.parkauto.parkauto.entity.User;
import com.parkauto.parkauto.entity.Vehicule;
import com.parkauto.parkauto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> direBonjour(){
        return ResponseEntity.ok("Bonjour user");
    }
    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user= userService.getUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    /*@DeleteMapping("/users/idUser")
    public ResponseEntity<User> deleteUser(@Validated @PathVariable(name="idUser") Long idUser){
        User user = userService.getUserById(idUser);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(user);
        return ResponseEntity.ok().body(user);
    }*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteUser(@PathVariable("id") long idUser) {
        userService.deleteUser(idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
