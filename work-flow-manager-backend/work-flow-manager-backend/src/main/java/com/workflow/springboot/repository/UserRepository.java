package com.workflow.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workflow.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
    public User findByEmailId(String emailId);
    public User findByEmailIdAndPassword(String emailId, String password);
}
