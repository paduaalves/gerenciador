package br.com.alura.gerenciador.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TipoContentType {
	XML("application/xml"), JSON("application/xml");
	
	private String contentType;
	
	public String getContentType() {
		return this.contentType;
	}
	
}
