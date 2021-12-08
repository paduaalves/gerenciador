package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.ConnectionFactory;

public class RemoveEmpresa implements Acao {

	EmpresaDAO dao = new EmpresaDAO(ConnectionFactory.recuperarConexao());

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dao.remove(Integer.valueOf(request.getParameter("id")));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		return "entrada?acao=ListaEmpresas";
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.REDIRECT;
	}

}
