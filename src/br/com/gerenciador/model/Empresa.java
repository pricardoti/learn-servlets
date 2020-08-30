package br.com.gerenciador.model;

public class Empresa {

	private int id;
	private String nome;

	public Empresa(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "{\"id\"=" + this.id + ",\"nome\"=\"" + this.nome + "\"}";
	}
}
