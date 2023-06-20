package com.icw.user.service.UserService.Exception;

import java.time.LocalDate;

public class ErrorDetail {

	private LocalDate timestamp;
	private String massage;
	private String description;
	public ErrorDetail(LocalDate timestamp, String massage, String description) {
		super();
		this.timestamp = timestamp;
		this.massage = massage;
		this.description = description;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public String getMassage() {
		return massage;
	}
	public String getDescription() {
		return description;
	}
	
	
}
