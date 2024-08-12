package com.somesh.banking.dto;

public class AccountDTO {

	private long id;
	private String accountHolderName;
	private double balence;

	public AccountDTO() {
		super();
	}

	public AccountDTO(long id, String accountHolderName, double balence) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balence = balence;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalence() {
		return balence;
	}

	public void setBalence(double balence) {
		this.balence = balence;
	}
	
	

}
