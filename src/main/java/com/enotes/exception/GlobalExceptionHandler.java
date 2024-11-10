/*
 * Copyright (c) 2024 Shiva
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shiva.
 * You shall not disclose or use it except in accordance with the terms of the
 * license agreement you entered into with Shiva.
 */

package com.enotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enotes.util.CommonUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerException(Exception e) {
		// return new ResponseEntity<>(e.getMessage(),
		// HttpStatus.INTERNAL_SERVER_ERROR);
		return CommonUtil.createErrorResponseMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> handleNullPointerException(Exception e) {
		// return new ResponseEntity<>(e.getMessage(),
		// HttpStatus.INTERNAL_SERVER_ERROR);
		return CommonUtil.createErrorResponseMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(Exception e) {
		// return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return CommonUtil.createErrorResponseMessage(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<?> handleValidationException(ValidationException e) {
		// return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
		return CommonUtil.createErrorResponse(e.getErrors(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ExistDataException.class)
	public ResponseEntity<?> existDataException(ExistDataException e) {
		// return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		return CommonUtil.createErrorResponseMessage(e.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e) {
		// return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		return CommonUtil.createErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
