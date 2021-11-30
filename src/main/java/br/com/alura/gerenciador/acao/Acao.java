package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.enums.TipoReposta;

public interface Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public TipoReposta getTipoReposta();
}
