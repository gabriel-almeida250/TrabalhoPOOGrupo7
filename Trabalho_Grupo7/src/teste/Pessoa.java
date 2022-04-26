package teste;

import java.time.LocalDate;
import pacote_exception.CpfException;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected LocalDate dataNascimento;
	
	public Pessoa(String nome, String cpf, LocalDate dataNascimento) throws CpfException  {
		super();
		this.nome = nome;
			if (cpf.length() == 11) {
				this.cpf = cpf;
			}else {
				throw new CpfException("Cpf deve conter 11 dígitos");
			}
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
