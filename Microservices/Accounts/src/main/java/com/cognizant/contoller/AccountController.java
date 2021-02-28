package com.cognizant.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Account;

@RestController
public class AccountController {

	@GetMapping("/accounts/{number}")
	public Account getAccountById(@PathVariable("number") int number) {
		Account ac = new Account(number, "savings", 234343);
		return ac;
	}
}
