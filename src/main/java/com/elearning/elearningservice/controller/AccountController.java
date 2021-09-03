package com.elearning.elearningservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.elearningservice.handler.ResponseHandler;
import com.elearning.elearningservice.model.Accounts;
import com.elearning.elearningservice.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping({"/", "/getaccounts"})
	public ResponseEntity<Object> viewAllAcounts(Model model) {
		
		try {
            List<Accounts> result = accountService.getAllAccounts();
            logger.info("Total Results : "+result);
            
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
		
	}
	
	
    @PostMapping(value = "/addaccount")
    public ResponseEntity<Object> Post(@RequestBody Accounts account) {
        try {
        	Accounts result = accountService.saveOrUpdate(account);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }
    
    @PutMapping(value = "/updateaccount")
    public ResponseEntity<Object> update(@RequestBody Accounts account) {
        try {
        	Accounts result = accountService.saveOrUpdate(account);
            return ResponseHandler.generateResponse("Successfully Updated data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }
	
	@GetMapping("/getaccount/{userid}")
	public ResponseEntity<Object> viewAccount(@PathVariable("userid") Long userid) {
		try {
			Accounts result = accountService.getAccountsById(userid);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
		
	}
	
	 // Delete
    @DeleteMapping(value = "/deleteaccount/{userid}")
    public ResponseEntity<Object> Delete(@PathVariable("userid") Long userid) {
        try {
            accountService.delete(userid);
            return ResponseHandler.generateResponse("Deleted Successfully!!!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
	
	
}
