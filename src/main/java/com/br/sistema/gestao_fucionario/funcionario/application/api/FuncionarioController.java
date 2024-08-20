package com.br.sistema.gestao_fucionario.funcionario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.br.sistema.gestao_fucionario.funcionario.application.service.FuncionarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class FuncionarioController implements FuncionarioAPI {

	private final FuncionarioService funcionarioService;

	@Override
	public FuncionarioResponse postNovoFuncionario(FuncionarioRequest funcionarioRequest) {
		log.info("[inicia] FuncionarioController - postNovoFuncionario");
		FuncionarioResponse criaFuncionario = funcionarioService.funcionarioCriado(funcionarioRequest);
		log.info("[finaliza] FuncionarioController - postNovoFuncionario");
		return criaFuncionario;
	}

	@Override
	public List<FuncionarioListResponse> getTodosFuncionarios() {
		log.info("[inicia] FuncionarioController - getTodosFuncionarios");
		List<FuncionarioListResponse> funcionarios = funcionarioService.buscaTodosFuncionarios();
		log.info("[finaliza] FuncionarioController - getTodosFuncionarios");
		return funcionarios;
	}

	@Override
	public void patchFuncionario(UUID idFuncionario, @Valid FuncionarioAlteracaoRequest funcionarioAlteracaoRequest) {
		log.info("[inicia] FuncionarioController - patchFuncionario");
		log.info("[idFuncionario]{}", idFuncionario);
		funcionarioService.patchAlteraFuncionario(idFuncionario, funcionarioAlteracaoRequest);
		log.info("[finaliza] FuncionarioController - patchFuncionario");

	}

	@Override
	public FuncionarioDetalhadoResponse getFuncionarioAtravesId(UUID idFuncionario) {
		log.info("[inicia] FuncionarioController - getFuncionarioAtravesId");
		log.info("[idFuncionario]{}", idFuncionario);
		FuncionarioDetalhadoResponse funcionarioDetalhado = funcionarioService.buscaFuncionarioAtravesId(idFuncionario);
		log.info("[finaliza] FuncionarioController - getFuncionarioAtravesId");
		return funcionarioDetalhado;
	}

	@Override
	public void deletaFuncionario(UUID idFuncionario) {
		log.info("[inicia] FuncionarioController - deletaFuncionario");
		log.info("[idFuncionario]{}", idFuncionario);
		funcionarioService.DeletaFuncionarioAtravesId(idFuncionario);
		log.info("[finaliza] FuncionarioController - deletaFuncionario");
		
	}

}
