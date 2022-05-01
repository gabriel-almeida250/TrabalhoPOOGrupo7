package pacote_class;

import java.time.LocalDate;
import java.time.Period;

import pacote_enum.TipoParentesco;
import pacote_exception.CpfTamanhoException;
import pacote_exception.IdadeException;

public class Dependente extends Pessoa {
	private TipoParentesco tipoParentesco;

	public Dependente(String nome, String cpf, LocalDate dataNascimento, TipoParentesco tipoParentesco)
			throws IdadeException, CpfTamanhoException {
		super(nome, cpf, dataNascimento);
		Period periodo = dataNascimento.until(LocalDate.now());
		if (periodo.getYears() >  18) {
			throw new IdadeException("Dependente deve ter menos de 18 anos");
		}
		this.tipoParentesco = tipoParentesco;
	}

	@Override
	public String toString() {
		return "\n" +super.toString() + ";" + tipoParentesco;
	}

	public TipoParentesco getTipoParentesco() {
		return tipoParentesco;
	}
}