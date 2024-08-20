package com.br.sistema.gestao_fucionario.funcionario.repository;

import java.util.List;
import java.util.UUID;

import com.br.sistema.gestao_fucionario.funcionario.domain.Funcionario;

public interface FuncionarioRepository {

	Funcionario salvaFuncionario(Funcionario funcionario);

	List<Funcionario> buscaTodosFuncionarios();

	Funcionario buscaFuncionarioAtravesId(UUID idFuncionario);

	void deletaFuncionario(Funcionario funcionario);



}
