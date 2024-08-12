package com.somesh.banking.dto;

public class TransferResponseDto {

	private String status;
	private String Message;

	public TransferResponseDto() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
