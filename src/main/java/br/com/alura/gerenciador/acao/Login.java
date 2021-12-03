package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario u = Usuario.builder().login(login).senha(senha).build();
		u= Banco.possuiCadastro(u);
		if(u!=null) {
			request.getSession().setAttribute("usuario", u);
			return "entrada?acao=ListaEmpresas";
		}

		return "entrada?acao=LoginForm";
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.REDIRECT;

	}
}
