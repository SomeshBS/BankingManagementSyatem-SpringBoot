package com.somesh.banking.services;

import java.util.List;

import com.somesh.banking.customexceptions.AccountNotExistException;
import com.somesh.banking.customexceptions.InsufficientBalanceException;
import com.somesh.banking.dto.AccountDTO;

public interface AccountService {
	
	AccountDTO createAccount(AccountDTO accountDTO);
	AccountDTO getAccountById(long id) throws AccountNotExistException;
	AccountDTO deposite(long id, double amount) throws AccountNotExistException;
	AccountDTO withdraw(long id, double amount) throws InsufficientBalanceException, AccountNotExistException;
	List<AccountDTO> getAllAccount();
	void deleteAccount(long id);
}
