package teste;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import pacote_enum.TipoParentesco;
import pacote_exception.CpfException;
import pacote_exception.IdadeException;

public class Dependente extends Pessoa {
	private TipoParentesco tipoParentesco; 

	public Dependente(String nome, String cpf, LocalDate dataNascimento, TipoParentesco tipoParentesco) throws IdadeException, CpfException {
		super(nome, cpf, dataNascimento);
		Period dif = dataNascimento.until(LocalDate.now());
		if (dif.getDays() >= 18) {
			throw new IdadeException("Dependente deve ter menos de 18 anos");
		} 
		this.tipoParentesco = tipoParentesco;
	}

	@Override
	public String toString() {
		return  super.toString() + ", Parentesco: " + tipoParentesco;	
				}

	public TipoParentesco getTipoParentesco() {
		return tipoParentesco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoParentesco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dependente other = (Dependente) obj;
		return tipoParentesco == other.tipoParentesco;
	}
}