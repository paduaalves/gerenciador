package br.com.alura.gerenciador.modelo;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class Empresa {

	@EqualsAndHashCode.Include
	@NonNull
	private Integer id;
	@NonNull
	private String nome;
	@NonNull
	private Date dataAbertura;
	private List<Funcionario> funcionarios;

	public List<Funcionario> getFuncionarios(){
		return Collections.unmodifiableList(funcionarios);
	}

}
