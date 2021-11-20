package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

		String id = request.getParameter("id");
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		Empresa empresa = new Empresa(nomeEmpresa);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAberturaConvertida = null;
		try {
			dataAberturaConvertida=sdf.parse(dataAbertura); 
			empresa.setDataAbertura(dataAberturaConvertida);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		if("".equals(id)) {
			Banco.adiciona(empresa);
		}
		else {
			Empresa empresaEditada = Banco.getEmpresa(Integer.parseInt(id));
			empresaEditada.setNome(nomeEmpresa);
			empresaEditada.setDataAbertura(dataAberturaConvertida);
			
		}
		response.sendRedirect("/gerenciador/listaEmpresas");
	}

}
