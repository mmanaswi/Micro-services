package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {


	private int number;
	private String type;
	private double loan;
	private int emi;
	private int tenure;
}
