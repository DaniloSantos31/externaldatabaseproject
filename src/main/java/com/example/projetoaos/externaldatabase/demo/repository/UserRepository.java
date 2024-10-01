package com.example.projetoaos.externaldatabase.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoaos.externaldatabase.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
}
