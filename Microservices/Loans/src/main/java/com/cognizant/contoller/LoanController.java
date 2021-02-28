package com.cognizant.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Loan;


@RestController
public class LoanController {

	@GetMapping("/loans/{number}")
	public Loan getAccountById(@PathVariable("number") int number) {
		Loan ac = new Loan(number, "Cars", 400000,4325,18);
		return ac;
	}
}
