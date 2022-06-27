package io.umaid.springbootquickstarter.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import io.umaid.springbootquickstarter.exception.domain.ApiExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = ResponseStatusException.class)
	public final ResponseEntity<ApiExceptionResponse> handleExceptionResponse(HttpServletRequest request,
			ResponseStatusException response) {
		ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse();
		apiExceptionResponse.setMessage(response.getReason());
		apiExceptionResponse.setStatus(response.getStatus().value());
		return ResponseEntity.status(response.getStatus()).body(apiExceptionResponse);

	}

}
