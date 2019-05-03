package com.financas.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.api.model.Status;
import com.financas.api.service.StatusService;

@RestController
@CrossOrigin
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private StatusService service;

	@PutMapping("/{id}")
	public Status editar(@Valid @RequestBody Status status , @PathVariable Long id) {
		status.setId(id);
		return this.service.salvar(status);
	}

	@GetMapping
	public List<Status> listar(){
		return this.service.listar();
	}

	@PostMapping
	public Status salvar(@Valid @RequestBody Status status) {
		return this.service.salvar(status);
	}

	@GetMapping("/{id}")
	public Status visualizar(@PathVariable Long id) {
		return this.service.visualizar(id);
	}
}
