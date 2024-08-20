package com.br.sistema.gestao_fucionario.funcionario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public interface FuncionarioAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	FuncionarioResponse postNovoFuncionario(
			@Valid @RequestBody FuncionarioRequest funcionarioRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<FuncionarioListResponse> getTodosFuncionarios();

	@GetMapping(value = "/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.OK)
	FuncionarioDetalhadoResponse getFuncionarioAtravesId(@PathVariable UUID idFuncionario);
	
	@PatchMapping(value = "/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchFuncionario(@PathVariable UUID idFuncionario, @Valid @RequestBody FuncionarioAlteracaoRequest funcionarioAlteracaoRequest);

	@DeleteMapping(value = "/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaFuncionario(@PathVariable UUID idFuncionario);
}
