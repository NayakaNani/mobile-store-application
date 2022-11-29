package com.example.demo.responseenity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class AppResponse {

	public Integer statusCode;
	public Object data;
//	public List<AppError> errorList;
	public AppResponse(Integer statusCode, Object data) {
		this.statusCode = statusCode;
		this.data = data;
	}
	
//	public AppResponse(Integer statusCode,List<AppError> errorList) {
//		this.statusCode = statusCode;
//		this.errorList = errorList;
//	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

//	public List<AppError> getErrorList() {
//		return errorList;
//	}
//
//	public void setErrorList(List<AppError> errorList) {
//		this.errorList = errorList;
//	}
}
