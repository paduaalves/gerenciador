package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.gerenciador.dao.UsuarioRepository;
import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.Usuario;

@Component
public class Login implements Acao {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario u = Usuario.builder().login(login).senha(senha).build();

		u = repository.findByLoginAndSenha(u.getLogin(), u.getSenha());

		if (u != null) {
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
