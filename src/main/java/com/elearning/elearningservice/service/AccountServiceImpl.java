package com.elearning.elearningservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.elearningservice.model.Accounts;
import com.elearning.elearningservice.repository.AccountsRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountsRepository accountsRepository;
	
	public List<Accounts> getAllAccounts() {
		return accountsRepository.findAll();
	}

	public Accounts getAccountsById(Long id) {
		return accountsRepository.findByUserId(id);
	}

	public Accounts saveOrUpdate(Accounts account) {
		return accountsRepository.save(account);
	}

	public void delete(Long id) {
		accountsRepository.deleteById(id);
	}

}
