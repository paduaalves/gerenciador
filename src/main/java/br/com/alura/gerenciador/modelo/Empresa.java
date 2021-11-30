package br.com.alura.gerenciador.modelo;

import java.util.Date;
import java.util.Objects;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataAbertura;

	public Empresa() {

	}

	public Empresa(String nome) {
		this.nome = nome;
	}

	public Empresa(String nome, Date dataAbertura) {
		super();
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}

	public Empresa(Integer id) {
		super();
		this.id = id;
	}

	public Empresa(Integer id, String nome, Date dataAbertura) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	} 

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}

}
