package br.com.alura.gerenciador.modelo;

import java.util.Date;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empresa {

	@EqualsAndHashCode.Include
	private Integer id;
	private String nome;
	private Date dataAbertura;

}
