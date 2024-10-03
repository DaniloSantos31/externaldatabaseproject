package com.example.projetoaos.externaldatabase.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.projetoaos.externaldatabase.demo.exception.UserNotFoundException;
import com.example.projetoaos.externaldatabase.demo.model.User;
import com.example.projetoaos.externaldatabase.demo.repository.UserRepository;

public class UserService {
    @Autowired
    public UserRepository userRepository;

    public Optional<User> getUserById(Long id) throws UserNotFoundException{
        Optional <User> opUser = userRepository.findById(id);
        if(opUser.isEmpty()){
            throw new UserNotFoundException("User " + id + " not found");
        }
        return userRepository.findById(id);
    }
    
    public void addUser(User user){
        userRepository.save(user);
    }

    public boolean deleteUserById(Long id){
        Optional<User> opUser = userRepository.findById(id);
        if(opUser.isEmpty()){
            return false;
        }
        User u = opUser.get();
        userRepository.delete(u);
        return true;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public boolean updateNameById(Long id, String newName){
        Optional<User> opUser = userRepository.findById(id);
        if(opUser.isEmpty()){
            return false;
        }
        User u = opUser.get();
        u.setName(newName);
        return true;
    }
}
