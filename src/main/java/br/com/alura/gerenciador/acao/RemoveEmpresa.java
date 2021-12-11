package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.gerenciador.dao.EmpresaRepository;
import br.com.alura.gerenciador.enums.TipoReposta;

public class RemoveEmpresa implements Acao {

	@Autowired
	private EmpresaRepository repository;

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			repository.deleteById(Integer.valueOf(request.getParameter("id")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "entrada?acao=ListaEmpresas";
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.REDIRECT;
	}

}
