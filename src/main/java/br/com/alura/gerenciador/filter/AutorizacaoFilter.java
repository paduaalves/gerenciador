package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutorizacaoFilter implements Filter {
	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Autorização Filter");
		String paramAcao = request.getParameter("acao");
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		HttpServletResponse responseHttp = (HttpServletResponse) response;
		HttpSession sessao = requestHttp.getSession();

		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuario") == null);
		boolean ehUmaAcaoProtegida = !("Login".equals(paramAcao) || "LoginForm".equals(paramAcao));

		if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			responseHttp.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		chain.doFilter(request, response);
	}

}
