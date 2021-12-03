package br.com.alura.gerenciador.webservice;

import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.enums.TipoContentType;
import br.com.alura.gerenciador.modelo.Empresa;

public class ClienteXML  implements ClienteWebService{

	@Override
	public Resposta resposta(List<Empresa> empresas) {
		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		String xml = xstream.toXML(empresas);
		return new Resposta(xml, TipoContentType.XML);	}

}
