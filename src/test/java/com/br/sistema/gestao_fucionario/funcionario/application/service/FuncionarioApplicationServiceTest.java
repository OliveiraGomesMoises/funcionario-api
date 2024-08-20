package com.br.sistema.gestao_fucionario.funcionario.application.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.br.sistema.gestao_fucionario.funcionario.domain.Funcionario;
import com.br.sistema.gestao_fucionario.funcionario.repository.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
public class FuncionarioApplicationServiceTest {

	@InjectMocks
	FuncionarioApplicationService classeTest;

	@Mock
	FuncionarioRepository funcionarioRepository;
	
	Funcionario funcionario ;

	@Test
	public void verificarSeRelmenteSalvaTest() {
//		Dado - Gieven
		
//		Quando - when
	}

}
