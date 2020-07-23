package com.dio.live.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dio.live.response.StatusResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(methods = { RequestMethod.GET,
		RequestMethod.OPTIONS }, allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
public class RootController {

	@GetMapping(value = { "", "/", "/health" }, produces = "application/json")
	public ResponseEntity<StatusResponse> success() {
		final StatusResponse statusResponse = StatusResponse.builder().status(200).mensagem("UP").build();

		log.info("\n\n {} \n\n", statusResponse);
		return ResponseEntity.ok().body(statusResponse);
	}

	@GetMapping(value= {"/swagger-ui"})
	public String redirectToSwaggerUi() {
		return "redirect:/swagger-ui.html";
	}

	// @GetMapping("/swagger")
	// public String redirectToSwagger() {
	// 	return "redirect:".concat(apiBasePath).concat(apiContextPath);
	// }

}
