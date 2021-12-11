package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.gerenciador.dao.EmpresaRepository;
import br.com.alura.gerenciador.enums.TipoReposta;
import br.com.alura.gerenciador.modelo.Empresa;

public class CadastraEmpresa implements Acao {

	@Autowired
	private EmpresaRepository repository;
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		Empresa empresa = Empresa.builder().nome(nomeEmpresa).build();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAberturaConvertida = null;
		try {
			if (dataAbertura != null) {
				dataAberturaConvertida = sdf.parse(dataAbertura);
				empresa.setDataAbertura(dataAberturaConvertida);
			}
			if (!"".equals(id)) {
				empresa.setId(Integer.valueOf(id));
			}
			repository.save(empresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		return "entrada?acao=ListaEmpresas";
	}

	@Override
	public TipoReposta getTipoReposta() {
		return TipoReposta.REDIRECT;
	}
}
