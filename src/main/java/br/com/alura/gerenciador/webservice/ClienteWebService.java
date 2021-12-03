package br.com.alura.gerenciador.webservice;

import java.util.List;

import br.com.alura.gerenciador.modelo.Empresa;

public interface ClienteWebService {

	Resposta resposta(List<Empresa> empresas);
	
}
