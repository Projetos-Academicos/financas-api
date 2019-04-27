package com.financas.api.service;

import java.util.List;

import com.financas.api.model.Lancamento;

public interface LancamentoService {

	public void excluir(Long id);

	public List<Lancamento> listar();

	public Lancamento salvar(Lancamento lancamento);

	public Lancamento visualizar(Long id);
}
