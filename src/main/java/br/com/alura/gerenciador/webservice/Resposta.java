package br.com.alura.gerenciador.webservice;

import br.com.alura.gerenciador.enums.TipoContentType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Resposta {
	private String resposta;
	private TipoContentType contentType;
}
