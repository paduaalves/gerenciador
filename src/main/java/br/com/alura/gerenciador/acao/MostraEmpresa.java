package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.gerenciador.dao.EmpresaRepository;
import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	@Autowired
	private EmpresaRepository repository;

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Optional<Empresa> empresa;
		try {
			empresa = repository.findById(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("empresa", empresa.get());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "formNovaEmpresa.jsp";
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.FOWARD;
	}
}
