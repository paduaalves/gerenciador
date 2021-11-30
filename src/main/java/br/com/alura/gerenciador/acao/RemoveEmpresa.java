package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class RemoveEmpresa implements Acao {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = Banco.getEmpresa(Integer.valueOf(request.getParameter("id")));
		Banco.remove(empresa);
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
