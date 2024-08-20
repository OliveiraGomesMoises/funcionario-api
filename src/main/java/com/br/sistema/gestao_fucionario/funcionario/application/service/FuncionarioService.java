package com.br.sistema.gestao_fucionario.funcionario.application.service;

import java.util.List;
import java.util.UUID;

import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioAlteracaoRequest;
import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioDetalhadoResponse;
import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioListResponse;
import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioRequest;
import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioResponse;

import jakarta.validation.Valid;

public interface FuncionarioService {

	FuncionarioResponse funcionarioCriado(FuncionarioRequest funcionarioRequest);

	List<FuncionarioListResponse> buscaTodosFuncionarios();

	void patchAlteraFuncionario(UUID idFuncionario, @Valid FuncionarioAlteracaoRequest funcionarioAlteracaoRequest);

	FuncionarioDetalhadoResponse buscaFuncionarioAtravesId(UUID idFuncionario);

	void DeletaFuncionarioAtravesId(UUID idFuncionario);

}
