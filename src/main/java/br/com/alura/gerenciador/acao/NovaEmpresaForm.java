package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.enums.TipoReposta;

public class NovaEmpresaForm implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "formNovaEmpresa.jsp";
	}
	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.FOWARD;
	}
}
