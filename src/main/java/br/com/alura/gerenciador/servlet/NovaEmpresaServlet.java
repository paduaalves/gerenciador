package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		Empresa empresa = new Empresa(nomeEmpresa);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			empresa.setDataAbertura(sdf.parse(dataAbertura));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		Banco.adiciona(empresa);

		response.sendRedirect("/gerenciador/listaEmpresas");

	}

}
