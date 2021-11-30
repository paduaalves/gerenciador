package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

public class Controller {
	private String parametro;
	private Acao acao;

	public Controller(String parametro) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		super();
		this.parametro = parametro;
		acao = (Acao) Class.forName("br.com.alura.gerenciador.acao." + parametro).newInstance();
	}

	public void send(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		acao.executa(request, response);
	}
}
