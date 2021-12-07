package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.DAO;
import br.com.alura.gerenciador.modelo.Empresa;

public class RemoveEmpresa implements Acao {
	
	private DAO dao = new DAO();

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa;
		try {
			empresa = dao.getEmpresa(Integer.valueOf(request.getParameter("id")));
			dao.remove(empresa);
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
