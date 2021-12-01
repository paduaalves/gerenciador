package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String paramAcao = request.getParameter("acao");
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		HttpServletResponse responseHttp = (HttpServletResponse) response;
		HttpSession sessao = requestHttp.getSession();
		
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuario")==null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			responseHttp.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		chain.doFilter(request, response);
	}

}
