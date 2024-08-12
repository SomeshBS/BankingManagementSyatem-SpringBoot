package com.somesh.banking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somesh.banking.dto.TransferRequestDto;
import com.somesh.banking.dto.TransferResponseDto;
import com.somesh.banking.entities.Account;
import com.somesh.banking.repository.AccountRepository;
import com.somesh.banking.services.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	AccountRepository accRepository;

	@Override
	public TransferResponseDto transferFunds(TransferRequestDto requestDto) {
		TransferResponseDto responseDto = new TransferResponseDto();

		Account fromAccount = accRepository.findById(requestDto.getFromAccountId())
				.orElseThrow(() -> new RuntimeException());
		Account toAccount = accRepository.findById(requestDto.getToAccountId())
				.orElseThrow(() -> new RuntimeException());

		if (fromAccount == null || toAccount == null) {
			responseDto.setStatus("FAIL");
			responseDto.setMessage("Account(s) not found");
			return responseDto;
		}

		if (fromAccount.getBalence() < requestDto.getAmount()) {
			responseDto.setStatus("FAIL");
			responseDto.setMessage("Requested amount is greated than the current amount");
			return responseDto;
		}

		fromAccount.setBalence(fromAccount.getBalence() - requestDto.getAmount());
		toAccount.setBalence(toAccount.getBalence() + requestDto.getAmount());

		accRepository.save(fromAccount);
		accRepository.save(toAccount);

		responseDto.setStatus("SUCCESS");
		responseDto.setMessage("Money transfered successfully");

		return responseDto;
	}

}
