package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.ConnectionFactory;
import br.com.alura.gerenciador.modelo.DAO;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.webservice.ClienteWebService;
import br.com.alura.gerenciador.webservice.Resposta;

@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao = new DAO(ConnectionFactory.recuperarConexao());
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

		String valor = request.getHeader("Accept");
		valor = valor.split("/")[1].toUpperCase();
		ClienteWebService cliente = (ClienteWebService) Class.forName("br.com.alura.gerenciador.webservice.Cliente" + valor)
					.newInstance();
		List<Empresa> empresas = dao.getEmpresas();
		Resposta resposta = cliente.resposta(empresas);
		response.getWriter().print(resposta.getResposta());
		response.setContentType(resposta.getContentType().getContentType());
		System.out.println(valor);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			response.setContentType("applicaton/json");
			response.getWriter().print("{message ': no content'}");
		}
	}

}
