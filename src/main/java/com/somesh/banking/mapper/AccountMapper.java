package com.somesh.banking.mapper;

import com.somesh.banking.dto.AccountDTO;
import com.somesh.banking.entities.Account;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class AccountMapper {

	public static Account mapToAccount(AccountDTO accountDTO) {
		Account account = new Account(
				accountDTO.getId(), 
				accountDTO.getAccountHolderName(), 
				accountDTO.getBalence()
				);
		return account;
	}

	public static AccountDTO mapToAccountDTO(Account account) {
		AccountDTO accountDTO = new AccountDTO(
				account.getId(), 
				account.getAccountHolderName(), 
				account.getBalence()
				);
		return accountDTO;
	}

}
