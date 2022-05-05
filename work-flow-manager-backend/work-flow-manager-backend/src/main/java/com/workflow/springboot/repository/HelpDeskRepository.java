package com.workflow.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workflow.springboot.model.HelpDesk;

@Repository
public interface HelpDeskRepository extends JpaRepository <HelpDesk, Integer> {

}
