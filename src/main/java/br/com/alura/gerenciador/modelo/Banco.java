package br.com.alura.gerenciador.modelo;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Banco {

	private static List<Empresa> lista;
	private static Integer id;
	private static List<Usuario> usuarios;

	static {
		lista = new ArrayList<Empresa>();
		lista.add(new Empresa(1, "Sacola do Bebê", new Date()));
		lista.add(new Empresa(2, "Alura", new Date()));
		lista.add(new Empresa(3, "Celum", new Date()));
		Banco.id = 4;

		Usuario u1 = Usuario.builder().login("padua").senha("padua").build();
		Usuario u2 = Usuario.builder().login("eliz").senha("eliz").build();
		usuarios = new ArrayList<Usuario>();
		usuarios.add(u1);
		usuarios.add(u2);
	}

	public static void adiciona(Empresa empresa) {
		empresa.setId(Banco.id);
		Banco.lista.add(empresa);
		Banco.id++;
	}

	public static List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public static void remove(Empresa empresa) {
		Banco.lista.remove(empresa);
	};

	public static Empresa getEmpresa(Integer id) {
		Optional<Empresa> empresa = lista.stream().filter(e->e.getId().equals(id)).findFirst();
		return empresa.isPresent() ? empresa.get() : null;
	}

	public static Usuario possuiCadastro(Usuario usuario) {
		Optional<Usuario> user = usuarios.stream().filter(u -> u.ehIgual(usuario.getLogin(), usuario.getSenha()))
				.findFirst();
		return user.isPresent() ? user.get() : null;
	}
}
