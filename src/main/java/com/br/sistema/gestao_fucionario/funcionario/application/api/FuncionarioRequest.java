package com.br.sistema.gestao_fucionario.funcionario.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
@Value
public class FuncionarioRequest {
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
}
