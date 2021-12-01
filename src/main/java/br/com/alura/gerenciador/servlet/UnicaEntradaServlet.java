package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.enums.TipoReposta;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ROOT_PATH="WEB-INF/view/";
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String paramAcao = request.getParameter("acao");
			HttpSession sessao = request.getSession();
			
			boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuario")==null);
			boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
			
			if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
				response.sendRedirect("entrada?acao=LoginForm");
				return;
			}
			Acao acao = (Acao) Class.forName("br.com.alura.gerenciador.acao." + request.getParameter("acao")).newInstance();
			String destino = acao.executa(request, response);
			if(TipoReposta.FOWARD.equals(acao.getTipoReposta())){
				RequestDispatcher rd = request.getRequestDispatcher(ROOT_PATH + destino);
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
