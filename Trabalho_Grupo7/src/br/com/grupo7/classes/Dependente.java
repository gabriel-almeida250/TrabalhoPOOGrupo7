package br.com.grupo7.classes;

import java.time.LocalDate;
import java.time.Period;

import br.com.grupo7.enumerador.TipoParentesco;
import br.com.grupo7.excecoes.CpfTamanhoException;
import br.com.grupo7.excecoes.IdadeException;

public class Dependente extends Pessoa {
	private TipoParentesco tipoParentesco;

	public Dependente(String nome, String cpf, LocalDate dataNascimento, TipoParentesco tipoParentesco)
			throws IdadeException, CpfTamanhoException {
		super(nome, cpf, dataNascimento);
		Period periodo = dataNascimento.until(LocalDate.now());
		if (periodo.getYears() > 18) {
			throw new IdadeException("Dependente precisa ser menor de 18 anos");
		}
		this.tipoParentesco = tipoParentesco;
	}

	@Override
	public String toString() {
		return "\n" + super.toString() + ";" + tipoParentesco;
	}

	public TipoParentesco getTipoParentesco() {
		return tipoParentesco;
	}
}