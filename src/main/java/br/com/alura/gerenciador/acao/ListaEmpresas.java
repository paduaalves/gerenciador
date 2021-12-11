package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.gerenciador.dao.EmpresaRepository;
import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	@Autowired
	private EmpresaRepository repository;

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> lista=new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(lista::add);
		request.setAttribute("empresas", lista);
		return "listaEmpresas.jsp";
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.FOWARD;

	}
}
