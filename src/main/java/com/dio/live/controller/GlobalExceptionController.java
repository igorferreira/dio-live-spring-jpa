package com.dio.live.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.dio.live.exception.JornadaTrabalhoNaoEncontradaException;
import com.dio.live.response.StatusResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { Throwable.class })
	public StatusResponse erroDesconhecidoHandler(Throwable ex) {

		log.error("\n\n Erro não tratado! \n\n", ex);

		return StatusResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.mensagem(ex.getMessage()).build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { NoHandlerFoundException.class })
	public StatusResponse noHandlerFoundExceptionHandler(NoHandlerFoundException ex) {

		log.error("\n\n Rota nao implementada! \n\n", ex);

		return StatusResponse.builder().status(HttpStatus.BAD_REQUEST.value()).mensagem(ex.getMessage()).build();
	}

	@ExceptionHandler(JornadaTrabalhoNaoEncontradaException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public StatusResponse JornadaTrabalhoNaoEncontradoExceptionHandler(JornadaTrabalhoNaoEncontradaException ex) {

		log.error("\n\n JornadaTrabalhoNaoEncontradaException! ", ex);

		return StatusResponse.builder().status(HttpStatus.NOT_FOUND.value()).mensagem(ex.getMessage())
				.build();
	}
}
