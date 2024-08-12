package com.somesh.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somesh.banking.customexceptions.AccountNotExistException;
import com.somesh.banking.customexceptions.InsufficientBalanceException;
import com.somesh.banking.dto.AccountDTO;
import com.somesh.banking.dto.TransferRequestDto;
import com.somesh.banking.dto.TransferResponseDto;
import com.somesh.banking.services.AccountService;
import com.somesh.banking.services.TransferService;
import com.somesh.banking.services.impl.TransferServiceImpl;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransferService trService;

	/*
	 * public AccountController(AccountService accountService) { this.accountService
	 * = accountService; }
	 */
	//Add Account REST API
	@PostMapping
	public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
		return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
	}
	
	
	//Get Account REST API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable long id) throws AccountNotExistException{
		AccountDTO accountDTO = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDTO);
	}
	
	//Deposit REST API
	@PutMapping ("/{id}/deposite")
	public ResponseEntity<AccountDTO> deposite(@PathVariable long id, @RequestBody Map<String, Double> request) throws AccountNotExistException{
		double amount=request.get("amount");
		AccountDTO accountDTO = accountService.deposite(id, amount);
		return ResponseEntity.ok(accountDTO);
	}
	
	//withdraw REST API
	@PutMapping ("/{id}/withdraw")
	public ResponseEntity<AccountDTO> withdraw(@PathVariable long id, @RequestBody Map<String,Double> request) throws InsufficientBalanceException, AccountNotExistException{
		double amount = request.get("amount");
		AccountDTO accountDTO=accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDTO);
	}
	
	//Get All accounts details
	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAllAccounts(){
		List<AccountDTO> accounts = accountService.getAllAccount();
		return ResponseEntity.ok(accounts);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccountt(@PathVariable long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account deleted successfully");
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<TransferResponseDto> transferMoney(@RequestBody TransferRequestDto tRequestDto){
		TransferResponseDto tResponseDto = trService.transferFunds(tRequestDto);
		return ResponseEntity.ok(tResponseDto);
		
		
	}

}
