package com.br.sistema.gestao_fucionario.funcionario.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.br.sistema.gestao_fucionario.funcionario.domain.Funcionario;

import lombok.Value;
@Value
public class FuncionarioListResponse {
	private UUID idFuncionario;
	private String nome;
	private String designacao;
	private String salario;
	private String numero;
	private String endereco;

	public static List<FuncionarioListResponse> converte(List<Funcionario> funcionarios) {
		return funcionarios.stream()
				.map(FuncionarioListResponse::new)
				.collect(Collectors
				.toList());
	}

	public FuncionarioListResponse(Funcionario funcionario) {
		this.idFuncionario = funcionario.getIdFuncionario();
		this.nome = funcionario.getNome();
		this.designacao = funcionario.getDesignacao();
		this.salario = funcionario.getSalario();
		this.numero = funcionario.getNumero();
		this.endereco = funcionario.getEndereco();
	}
	
}
