package com.jerseyutil.domain;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
	private byte status;
	private String message,data;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

}
