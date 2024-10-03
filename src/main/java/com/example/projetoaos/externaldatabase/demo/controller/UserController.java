package com.example.projetoaos.externaldatabase.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoaos.externaldatabase.demo.model.User;
import com.example.projetoaos.externaldatabase.demo.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value="api/user/")
@AllArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("all/")
    public List<User> getUser(){
        return userService.getAll();
    }

    @GetMapping("{id}/")
    public Optional <User> getUserById(@PathVariable("id") Long id) throws Exception{
        try{
            return userService.getUserById(id);
        } catch(Exception e ) {
            return null;
        }
    }

    @PostMapping("add/")
    public void insertUser(@RequestBody User user){
        userService.addUser(user);
    }
    
    @DeleteMapping("user/{id}")
public void deleteUserById(@PathVariable("id") Long id) throws Exception{
        try {
            userService.deleteUserById(id);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @PutMapping("user/{id}")
    public boolean updateTitleUserById(@PathVariable Long id, @RequestParam String newName) throws Exception{
        try{
           return userService.updateNameById(id, newName);
        } catch(Exception e){
            return false;
        }
    }
    
}
