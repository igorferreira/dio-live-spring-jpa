package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;

@Service
public class JornadaService {

	JornadaRepository jornadaRepository;

	@Autowired
	public JornadaService(JornadaRepository jornadaRepository) {
		this.jornadaRepository = jornadaRepository;
	}

	public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
		return jornadaRepository.save(jornadaTrabalho);
	}

	public void delete(Long id) {
		jornadaRepository.delete(JornadaTrabalho.builder().id(id).build());
	}

	public Optional<JornadaTrabalho> findById(Long id) {
		return jornadaRepository.findById(id);
	}

	public List<JornadaTrabalho> findAll() {
		return jornadaRepository.findAll();
	}

	public JornadaTrabalho update(JornadaTrabalho jornadaTrabalho) {
		return jornadaRepository.save(jornadaTrabalho);
	}
}

