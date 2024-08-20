package com.br.sistema.gestao_fucionario.funcionario.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioAlteracaoRequest;
import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioDetalhadoResponse;
import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioListResponse;
import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioRequest;
import com.br.sistema.gestao_fucionario.funcionario.application.api.FuncionarioResponse;
import com.br.sistema.gestao_fucionario.funcionario.domain.Funcionario;
import com.br.sistema.gestao_fucionario.funcionario.repository.FuncionarioRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class FuncionarioApplicationService implements FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	@Override
	public FuncionarioResponse funcionarioCriado(FuncionarioRequest funcionarioRequest) {
		log.info("[inicia] FuncionarioApplicationService - funcionarioCriado");
		Funcionario funcionario = funcionarioRepository.salvaFuncionario(new Funcionario(funcionarioRequest));
		log.info("[finaliza] FuncionarioApplicationService - funcionarioCriado");
		return FuncionarioResponse.builder().idFuncionario(funcionario.getIdFuncionario()).build();
	}

	@Override
	public List<FuncionarioListResponse> buscaTodosFuncionarios() {
		log.info("[inicia] FuncionarioApplicationService - buscaTodosFuncionarios");
		List<Funcionario> funcionarios = funcionarioRepository.buscaTodosFuncionarios();
		log.info("[finaliza] FuncionarioApplicationService - buscaTodosFuncionarios");
		return FuncionarioListResponse.converte(funcionarios);
	}

	@Override
	public void patchAlteraFuncionario(UUID idFuncionario,
			@Valid FuncionarioAlteracaoRequest funcionarioAlteracaoRequest) {
		log.info("[inicia] FuncionarioApplicationService - patchAlteraFuncionario");
		Funcionario funcionario = funcionarioRepository.buscaFuncionarioAtravesId(idFuncionario);
		log.info("[finaliza] FuncionarioApplicationService - patchAlteraFuncionario");
		
	}

	@Override
	public FuncionarioDetalhadoResponse buscaFuncionarioAtravesId(UUID idFuncionario) {
		log.info("[inicia] FuncionarioApplicationService - buscaFuncionarioAtravesId");
		Funcionario funcionario = funcionarioRepository.buscaFuncionarioAtravesId(idFuncionario);
		log.info("[finaliza] FuncionarioApplicationService - buscaFuncionarioAtravesId");
		return new FuncionarioDetalhadoResponse(funcionario);
	}

	@Override
	public void DeletaFuncionarioAtravesId(UUID idFuncionario) {
		log.info("[inicia] FuncionarioApplicationService - DeletaFuncionarioAtravesId");
		Funcionario funcionario = funcionarioRepository.buscaFuncionarioAtravesId(idFuncionario);
		funcionarioRepository.deletaFuncionario(funcionario);
		log.info("[finaliza] FuncionarioApplicationService - DeletaFuncionarioAtravesId");
		
	}


	


}

	
