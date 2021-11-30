package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario u = Usuario.builder().login(login).senha(senha).build();
		if(Banco.possuiCadastro(u)) {
			return "entrada?acao=ListaEmpresas";
		}
		else {
			return "entrada?acao=LoginForm";
		}
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.REDIRECT;

	}
}
