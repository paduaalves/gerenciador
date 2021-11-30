package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Controller controller;
			controller = new Controller(request.getParameter("acao"));
			controller.send(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		if (paramAcao.equals("listaEmpresas")) {
//			 acao = new ListaEmpresas();
//			acao.executa(request, response);
//		} else if (paramAcao.equals("mostraEmpresa")) {
//			acao = new MostraEmpresa();
//			acao.executa(request, response);
//		} else if (paramAcao.equals("removeEmpresa")) {
//			acao = new RemoveEmpresa();
//			acao.executa(request, response);
//		}
	}

}
