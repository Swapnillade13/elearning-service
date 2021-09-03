package com.elearning.elearningservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elearning.elearningservice.model.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long>{
	
	Accounts findByUserId(Long id);
	
}