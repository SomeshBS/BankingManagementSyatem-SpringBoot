package com.somesh.banking.customexceptions;

public class AccountNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7352008625878943966L;

	public AccountNotExistException(String message) {
		super(message);
	}
	
}
