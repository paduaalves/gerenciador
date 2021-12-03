package br.com.alura.gerenciador.webservice;

import java.util.List;

import com.google.gson.Gson;

import br.com.alura.gerenciador.enums.TipoContentType;
import br.com.alura.gerenciador.modelo.Empresa;

public class ClienteJSON implements ClienteWebService {

	@Override
	public Resposta resposta(List<Empresa> empresas) {
		Gson gson = new Gson();
		String json = gson.toJson(empresas);
		return new Resposta(json, TipoContentType.JSON);

	}

}
