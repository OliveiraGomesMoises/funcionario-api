package com.br.sistema.gestao_fucionario.funcionario.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import com.br.sistema.gestao_fucionario.funcionario.domain.Funcionario;

import lombok.Value;

@Value
public class FuncionarioDetalhadoResponse {
	private UUID idFuncionario;
	private String nome;
	private String designacao;
	private String salario;
	private String numero;
	private String endereco;
	private LocalDateTime dataHoraCadastro;
	
	
	public FuncionarioDetalhadoResponse(Funcionario funcionario) {
		this.idFuncionario = funcionario.getIdFuncionario();
		this.nome = funcionario.getNome();
		this.designacao = funcionario.getDesignacao();
		this.salario = funcionario.getSalario();
		this.numero = funcionario.getNumero();
		this.endereco = funcionario.getEndereco();
		this.dataHoraCadastro = funcionario.getDataHoraAlteracao();
	}


	
	
	
	
	
	
	
}
