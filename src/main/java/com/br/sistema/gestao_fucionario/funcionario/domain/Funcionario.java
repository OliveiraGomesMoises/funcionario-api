package com.br.sistema.gestao_fucionario.funcionario.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioAlteracaoRequest;
import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "UUID", name = "idFuncionario")
	private UUID idFuncionario;
	@NotBlank
	private String nome;
	@NotBlank
	private String designacao;
	@NotBlank
	private String salario;
	@NotBlank
	private String numero;
	@NotBlank
	private String endereco;
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraAlteracao;

	public Funcionario(FuncionarioRequest funcionarioRequest) {
		this.idFuncionario = UUID.randomUUID();
		this.nome = funcionarioRequest.getNome();
		this.designacao = funcionarioRequest.getDesignacao();
		this.salario = funcionarioRequest.getSalario();
		this.numero = funcionarioRequest.getNumero();
		this.endereco = funcionarioRequest.getEndereco();
		this.dataHoraCadastro = LocalDateTime.now();

	}

	public void altera(@Valid FuncionarioAlteracaoRequest funcionarioAlteracaoRequest) {
		this.nome = funcionarioAlteracaoRequest.getNome();
		this.designacao = funcionarioAlteracaoRequest.getDesignacao();
		this.salario = funcionarioAlteracaoRequest.getSalario();
		this.numero = funcionarioAlteracaoRequest.getNumero();
		this.endereco = funcionarioAlteracaoRequest.getEndereco();
		this.dataHoraAlteracao = LocalDateTime.now();

	}

}
