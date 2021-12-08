package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.ConnectionFactory;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpresaDAO dao = new EmpresaDAO(ConnectionFactory.recuperarConexao());

		List<Empresa> lista;
		try {
			lista = dao.getEmpresas();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		request.setAttribute("empresas", lista);
		return "listaEmpresas.jsp";
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.FOWARD;

	}
}
