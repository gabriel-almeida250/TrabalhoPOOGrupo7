package teste;

import java.time.LocalDate;
import java.util.Set;

import pacote_enum.TipoFuncionario;
import pacote_exception.CpfException;
import pacote_interface.Tributos;

public class Funcionario extends Pessoa implements Tributos {
	private TipoFuncionario salarioBruto;
	private TipoFuncionario cargo;
	private Set<Dependente> dependentes;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento,TipoFuncionario cargo, TipoFuncionario salarioBruto,
			Set<Dependente> dependentes) throws CpfException {
		super(nome, cpf, dataNascimento);
		this.cargo = cargo;
		this.salarioBruto = salarioBruto;
		this.dependentes = dependentes;
	}

	@Override
	public String toString() {
		return "Funcionário: \n--------------" + super.toString() + ", Cargo: " + cargo.getCargo() + ", Salário Bruto:" + salarioBruto.getSalario()
				+ "\n\nDependentes: \n--------------" + dependentes;
	}

	public TipoFuncionario getSalarioBruto() {
		return salarioBruto;
	}

	public Set<Dependente> getDependente() {
		return dependentes;
	}
	
	public TipoFuncionario getCargo() {
		return cargo;
	}

	@Override
	public double descontoInss() {
		double calculoInss = 0.0;
		if (this.salarioBruto.getSalario() < 1212.0) {
			calculoInss = this.salarioBruto.getSalario() * 0.075;
			return calculoInss;
		} else if (this.salarioBruto.getSalario() < 2427.35) {
			calculoInss = (this.salarioBruto.getSalario() * 0.09) - 18.18;
			return calculoInss;
		} else if (this.salarioBruto.getSalario() < 3641.03) {
			calculoInss = this.salarioBruto.getSalario() * 0.12 - 91.00;
			return calculoInss;
		} else if (this.salarioBruto.getSalario() < 7087.22) {
			calculoInss = this.salarioBruto.getSalario() * 0.14 - 163.82;
			return calculoInss;
		} else if (this.salarioBruto.getSalario() > 7087.22) {
			calculoInss = 7087.22 * 0.14 - 163.82;
			return calculoInss;
		}
		return calculoInss;
	}

	public double calculoSalarioDependenteInss() {
		double valorSalarioDependenteInss = 0.0;
		for (Dependente dependente : dependentes) {
			valorSalarioDependenteInss += dependente.getTipoParentesco().getDesconto();
		}
		return this.salarioBruto.getSalario() - valorSalarioDependenteInss - this.descontoInss();
	}

	public double descontoIR() {
		double calculoIR = 0.0;
		if (this.salarioBruto.getSalario() < 1903.98) {
			return calculoIR;
		} else if (this.salarioBruto.getSalario() < 2826.65) {
			calculoIR = ((calculoSalarioDependenteInss()) * 0.075) - 142.80;
			return calculoIR;
		} else if (this.salarioBruto.getSalario() < 3751.05) {
			calculoIR = ((calculoSalarioDependenteInss()) * 0.15) - 142.80;
			return calculoIR;
		} else if (this.salarioBruto.getSalario() < 4664.68) {
			calculoIR = ((calculoSalarioDependenteInss()) * 0.225) - 354.80;
			return calculoIR;
		} else if (this.salarioBruto.getSalario() > 4664.68) {
			calculoIR = ((calculoSalarioDependenteInss()) * 0.275) - 869.36;
		}
		return calculoIR;
	}
	public double salarioliquido() {
		double valor = 0.0;
		valor = this.salarioBruto.getSalario() - descontoIR() - descontoInss();
		return valor;
	}

	

}