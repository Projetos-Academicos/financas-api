package com.financas.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.api.model.Lancamento;
import com.financas.api.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService service;

	@PutMapping
	public Lancamento editar(@Valid @RequestBody Lancamento lancamento) {
		return this.service.salvar(lancamento);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		this.service.excluir(id);
	}

	@GetMapping
	public List<Lancamento> listar(){
		return this.service.listar();
	}

	@PostMapping
	public Lancamento salvar(@Valid @RequestBody Lancamento lancamento) {
		return this.service.salvar(lancamento);
	}

	@GetMapping("/{id}")
	public Lancamento visualizar(@PathVariable Long id) {
		return this.service.visualizar(id);
	}

}
