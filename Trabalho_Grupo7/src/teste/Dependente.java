package teste;

import java.time.LocalDate;
import java.time.Period;

import pacote_enum.TipoParentesco;
import pacote_exception.IdadeException;
import pacote_enum.TipoSalario;

public class Dependente extends Pessoa {
	private TipoParentesco tipoParentesco; 

	public Dependente(String nome, int cpf, LocalDate dataNascimento, TipoParentesco tipoParentesco) throws IdadeException {
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
}
