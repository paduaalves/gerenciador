package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.enums.TipoReposta;

public class ControladorFilter implements Filter {
	private static String ROOT_PATH = "WEB-INF/view/";

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Controlador Filter");

		HttpServletRequest reqHttp = (HttpServletRequest) request;
		HttpServletResponse respHttp = (HttpServletResponse) response;
		try {
			Acao acao = (Acao) Class.forName("br.com.alura.gerenciador.acao." + request.getParameter("acao"))
					.newInstance();
			String destino = acao.executa(reqHttp, respHttp);
			if (TipoReposta.FOWARD.equals(acao.getTipoReposta())) {
				RequestDispatcher rd = request.getRequestDispatcher(ROOT_PATH + destino);
				rd.forward(request, response);
			} else {
				respHttp.sendRedirect(destino);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
