package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = Banco.getEmpresa(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/formNovaEmpresa.jsp");
		rd.forward(request, response);
	}
}
