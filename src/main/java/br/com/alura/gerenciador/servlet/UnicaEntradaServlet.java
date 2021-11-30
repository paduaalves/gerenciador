package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.enums.TipoReposta;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Acao acao = (Acao) Class.forName("br.com.alura.gerenciador.acao." + request.getParameter("acao")).newInstance();
			String destino = acao.executa(request, response);
			if(TipoReposta.FOWARD.equals(acao.getTipoReposta())){
				RequestDispatcher rd = request.getRequestDispatcher(destino);
				rd.forward(request, response);
			}
			else {
				response.sendRedirect(destino);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
