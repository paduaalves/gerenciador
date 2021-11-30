package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class RemoveEmpresa implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = Banco.getEmpresa(Integer.valueOf(request.getParameter("id")));
		Banco.remove(empresa);
		return "entrada?acao=ListaEmpresas";
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.REDIRECT;
	}
	
}
