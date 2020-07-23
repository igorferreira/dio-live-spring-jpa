package com.dio.live.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dio.live.exception.JornadaTrabalhoNaoEncontradaException;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.response.StatusResponse;
import com.dio.live.service.JornadaService;

@RestController
@CrossOrigin(methods = {
	RequestMethod.GET,
	RequestMethod.POST,
	RequestMethod.DELETE,
	RequestMethod.PUT,
	RequestMethod.OPTIONS }, allowCredentials = "true", origins = "*", maxAge = 3600)
@RequestMapping(value = "/jornada", produces = MediaType.APPLICATION_JSON_VALUE)
public class JornadaTrabalhoController {

	@Autowired
	JornadaService jornadaService;

	@PostMapping
	public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaService.save(jornadaTrabalho);
	}

	@GetMapping()
	public List<JornadaTrabalho> findAll() {
		return jornadaService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<JornadaTrabalho> findByIdJornada(@PathVariable("id") Long id) throws JornadaTrabalhoNaoEncontradaException {
		Optional<JornadaTrabalho> jornadaTrabalho = jornadaService.findById(id);
		if (jornadaTrabalho.isPresent()) {
			return ResponseEntity.ok(jornadaTrabalho.get());
		} else {
			throw new JornadaTrabalhoNaoEncontradaException("Jornada " + id + " não encontrada!");
//			return ResponseEntity.notFound().build();
//			return new ResponseEntity(
//					 StatusResponse.builder()
//					 .status(HttpStatus.NOT_FOUND.value())
//					 .mensagem("Jornada não encontrada!").build().toString(),
//					HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaService.update(jornadaTrabalho);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteJornada(@PathVariable("id") Long id) {
		try {
			jornadaService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST.value())
					.contentType(MediaType.APPLICATION_JSON)
					.body(StatusResponse.builder()
							.status(HttpStatus.BAD_REQUEST.value())
							.mensagem(e.getMessage())
							.build());
		}

	}


}
