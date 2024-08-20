package com.br.sistema.gestao_fucionario.funcionario.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.sistema.gestao_fucionario.funcionario.domain.Funcionario;
import java.util.List;


public interface FuncionarioSpringDataJPARepository extends JpaRepository<Funcionario, UUID> {

	List<Funcionario> findByIdFuncionario(UUID idFuncionario);



}
