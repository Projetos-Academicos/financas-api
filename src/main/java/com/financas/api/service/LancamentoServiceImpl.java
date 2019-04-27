package com.financas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.api.model.Lancamento;
import com.financas.api.repository.LancamentoRepository;

@Service
public class LancamentoServiceImpl implements LancamentoService{

	@Autowired
	private LancamentoRepository repository;

	@Override
	public void excluir(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public List<Lancamento> listar() {
		return this.repository.findAll();
	}

	@Override
	public Lancamento salvar(Lancamento lancamento) {
		return this.repository.save(lancamento);
	}

	@Override
	public Lancamento visualizar(Long id) {
		return this.repository.findById(id).get();
	}

}
