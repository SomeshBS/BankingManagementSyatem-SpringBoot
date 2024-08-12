package com.somesh.banking.services;

import com.somesh.banking.dto.TransferRequestDto;
import com.somesh.banking.dto.TransferResponseDto;

public interface TransferService {
	
	TransferResponseDto transferFunds(TransferRequestDto requestDto);

}
