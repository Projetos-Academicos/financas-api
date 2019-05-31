package com.financas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.api.model.Status;
import com.financas.api.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository repository;

	public void excluir(Long id) {
		this.repository.deleteById(id);
	}

	public List<Status> listar() {
		return this.repository.findAll();
	}

	public Status salvar(Status status) {
		return this.repository.save(status);
	}

	public Status visualizar(Long id) {
		return this.repository.findById(id).get();
	}

}
