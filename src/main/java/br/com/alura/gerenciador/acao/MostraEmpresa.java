package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.ConnectionFactory;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpresaDAO dao = new EmpresaDAO(ConnectionFactory.gEntityManager());		
		Empresa empresa;
		try {
			empresa = dao.getEmpresa(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("empresa", empresa);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "formNovaEmpresa.jsp";
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.FOWARD;
	}
}
