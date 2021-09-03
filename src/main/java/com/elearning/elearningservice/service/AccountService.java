package com.elearning.elearningservice.service;

import java.util.List;

import com.elearning.elearningservice.model.Accounts;

public interface AccountService {

	List<Accounts> getAllAccounts();
	Accounts getAccountsById(Long id);
	Accounts saveOrUpdate(Accounts account);
	void delete(Long id);   
}
