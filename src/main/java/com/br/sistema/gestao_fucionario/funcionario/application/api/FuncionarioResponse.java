package com.br.sistema.gestao_fucionario.funcionario.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class FuncionarioResponse {
	private UUID idFuncionario;
}
