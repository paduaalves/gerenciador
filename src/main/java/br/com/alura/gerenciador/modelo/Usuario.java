package br.com.alura.gerenciador.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Usuario {
	private String login;
	private String senha;

	public boolean ehIgual(String login, String senha) {
		if (!this.login.equals(login)) {
			return false;
		}
		if (!this.senha.equals(senha)) {
			return false;
		}
		return true;
	}
}
