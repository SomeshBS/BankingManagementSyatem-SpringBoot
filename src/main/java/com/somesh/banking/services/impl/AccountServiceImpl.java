package com.somesh.banking.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
//hello

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somesh.banking.customexceptions.AccountNotExistException;
import com.somesh.banking.customexceptions.InsufficientBalanceException;
import com.somesh.banking.dto.AccountDTO;
import com.somesh.banking.entities.Account;
import com.somesh.banking.mapper.AccountMapper;
import com.somesh.banking.repository.AccountRepository;
import com.somesh.banking.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accRepository;

	
	/*
	 * public AccountServiceImpl(AccountRepository accRepository) {
	 * this.accRepository = accRepository; }
	 */

	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		Account account = AccountMapper.mapToAccount(accountDTO);
		Account saveAccount = accRepository.save(account);
		return AccountMapper.mapToAccountDTO(saveAccount);
	}

	@Override
	public AccountDTO getAccountById(long id) throws AccountNotExistException {
		Account account  = accRepository.findById(id).orElseThrow(() -> new AccountNotExistException("Account does not exists"));
		return AccountMapper.mapToAccountDTO(account);
	}
	
	@Override
	public List<AccountDTO> getAllAccount() {
		List<Account> accounts = accRepository.findAll();
		
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDTO(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(long id) {
		Account account = accRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		accRepository.deleteById(id);
	}

	@Override
	public AccountDTO deposite(long id, double amount) throws AccountNotExistException {
		Account account
		= accRepository.findById(id).orElseThrow(( )-> new AccountNotExistException("Account does not exists"));
		double total = account.getBalence() + amount;
		account.setBalence(total);
		Account savedAccount = accRepository.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public AccountDTO withdraw(long id, double amount) throws InsufficientBalanceException, AccountNotExistException {
		Account account = accRepository.findById(id).orElseThrow(()->new AccountNotExistException("Account does not exists"));
		if(account.getBalence() < amount) {
			throw new InsufficientBalanceException("Insufficient amount");
		}
		double total = account.getBalence()-amount;
		account.setBalence(total);
		Account savedAccount = accRepository.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}


	

}
