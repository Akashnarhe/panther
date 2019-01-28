package com.demoh2.example.controlleradvisor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class ExceptionAdvisor {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvisor.class);

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String exceptionNullPointer(HttpServletRequest httpServletReques, Exception e) {
		logger.info("NullPointerException " + httpServletReques.getRequestURL());
		String builder = "NullPointerException " + httpServletReques.getRequestURL();
		return builder;
	}
}
