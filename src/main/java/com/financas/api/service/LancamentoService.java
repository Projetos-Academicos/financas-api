package com.financas.api.service;

import java.util.List;

import com.financas.api.dto.LancamentoDTO;

public interface LancamentoService {

	public void excluir(Long id);

	public List<LancamentoDTO> listar();

	public LancamentoDTO salvar(LancamentoDTO lancamento);

	public LancamentoDTO visualizar(Long id);
}
