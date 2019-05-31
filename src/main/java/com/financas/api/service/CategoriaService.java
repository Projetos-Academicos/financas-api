package com.financas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.api.model.Categoria;
import com.financas.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public void excluir(Long id) {
		this.repository.deleteById(id);
	}

	public List<Categoria> listar() {
		return this.repository.findAll();
	}

	public Categoria salvar(Categoria categoria) {
		return this.repository.save(categoria);
	}

	public Categoria visualizar(Long id) {
		return this.repository.findById(id).get();
	}
}
