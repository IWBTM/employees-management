package com.COMTRUE.demo.advice;

import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

	String message;

	@ExceptionHandler(value = HibernateException.class)
	public ResponseEntity<?> hibernateException(HibernateException e) {

		message = "이미 존재하는 직원 번호입니다.";
		System.err.println("HibernateException 발생 ~~");

		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(message);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e) {

		message = "전화번호와 이메일의 형식을 맞춰주세요. ex) 010-1234-5678, abc@abc.com";
		System.err.println("ConstraintViolationException 발생 ~~");
		System.err.println(message);

		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(message);
	}
}
