package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.gerenciador.dao.EmpresaRepository;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.webservice.ClienteWebService;
import br.com.alura.gerenciador.webservice.Resposta;

@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmpresaRepository repository;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String valor = request.getHeader("Accept");
			valor = valor.split("/")[1].toUpperCase();
			ClienteWebService cliente = (ClienteWebService) Class
					.forName("br.com.alura.gerenciador.webservice.Cliente" + valor)
					.newInstance();
			List<Empresa> empresas = new ArrayList<Empresa>();
			repository.findAll().iterator().forEachRemaining(empresas::add);
			;
			Resposta resposta = cliente.resposta(empresas);
			response.getWriter().print(resposta.getResposta());
			response.setContentType(resposta.getContentType().getContentType());
			System.out.println(valor);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			response.setContentType("applicaton/json");
			response.getWriter().print("{message ': no content'}");
		}
	}

}
