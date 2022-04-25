package teste;

import java.time.LocalDate;

public abstract class Pessoa {
	protected String nome;
	protected int cpf;
	protected LocalDate dataNascimento;

	public Pessoa(String nome, int cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	

	@Override
	public String toString() {
		return "\nNome: " + nome + ", Cpf: " + cpf + ", Data Nascimento: " + dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
