package com.br.sistema.gestao_fucionario.funcionario.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.br.sistema.gestao_fucionario.funcionario.domain.Funcionario;
import com.br.sistema.gestao_fucionario.funcionario.handler.APIException;
import com.br.sistema.gestao_fucionario.funcionario.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class FuncionarioInfraRepository implements FuncionarioRepository {

	private final FuncionarioSpringDataJPARepository funcionarioSpringDataJPARepository;

	@Override
	public Funcionario salvaFuncionario(Funcionario funcionario) {
		log.info("[inicia] FuncionarioInfraRepository - salvaFuncionario");
		try {
			funcionarioSpringDataJPARepository.save(funcionario);
		} catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Existem dados duplicados");
		}
		log.info("[finaliza] FuncionarioInfraRepository - salvaFuncionario");
		return funcionario;
	}

	@Override
	public List<Funcionario> buscaTodosFuncionarios() {
		log.info("[inicia] FuncionarioInfraRepository -  buscaTodosFuncionarios");
		List<Funcionario> todosFuncioanrios = funcionarioSpringDataJPARepository.findAll();
		log.info("[finaliza] FuncionarioInfraRepository -  buscaTodosFuncionarios");
		return todosFuncioanrios;

	}

	@Override
	public Funcionario buscaFuncionarioAtravesId(UUID idFuncionario) {
		log.info("[inicia] FuncionarioInfraRepository -  buscaFuncionarioAtravesId");
		Funcionario funcionario = funcionarioSpringDataJPARepository.findById(idFuncionario)
				.orElseThrow(() ->APIException.build(HttpStatus.NOT_FOUND, "Funcionario Não Encontrado!!"));
		log.info("[inicia] FuncionarioInfraRepository -  buscaFuncionarioAtravesId");
		return funcionario;
	}

	@Override
	public void deletaFuncionario(Funcionario funcionario) {
		log.info("[inicia] FuncionarioInfraRepository -  deletaFuncionario");
		funcionarioSpringDataJPARepository.delete(funcionario);
		log.info("[finaliza] FuncionarioInfraRepository -  deletaFuncionario");
		
	}



	
	

	


}
