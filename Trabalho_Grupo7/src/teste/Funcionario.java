package teste;

import java.time.LocalDate;
import java.util.Set;

import pacote_enum.TipoSalario;
import pacote_exception.CpfException;
import pacote_interface.Tributos;

public class Funcionario extends Pessoa implements Tributos {
	private TipoSalario salarioBruto;
	private Set<Dependente> dependentes;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, TipoSalario salarioBruto,
			Set<Dependente> dependentes) throws CpfException {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.dependentes = dependentes;
	}

	@Override
	public String toString() {
		return "Funcionário: \n--------------" + super.toString() + ", Salário Bruto:" + salarioBruto.getSalario()
				+ "\n\nDependentes: \n--------------" + dependentes;
	}

	public TipoSalario getSalarioBruto() {
		return salarioBruto;
	}

	public Set<Dependente> getDependente() {
		return dependentes;
	}

	@Override
	public double descontoInss() {
		double salario = 0.0;
		if (this.salarioBruto.getSalario() < 1212.0) {
			salario = this.salarioBruto.getSalario() * 0.075;
			return salario;
		} else if (this.salarioBruto.getSalario() < 2427.35) {
			salario = (this.salarioBruto.getSalario() * 0.09) - 18.18;
			return salario;
		} else if (this.salarioBruto.getSalario() < 3641.03) {
			salario = this.salarioBruto.getSalario() * 0.12 - 91.00;
			return salario;
		} else if (this.salarioBruto.getSalario() < 7087.22) {
			salario = this.salarioBruto.getSalario() * 0.14 - 163.82;
			return salario;
		} else if (this.salarioBruto.getSalario() > 7087.22) {
			salario = 7087.22 * 0.14 - 163.82;
			return salario;
		}
		return salario;
	}

	private Double calculoSalarioDedutivel() {
		Double valorTotalDescontoDependente = 0.0;
		for (Dependente dependente : dependentes) {
			valorTotalDescontoDependente += dependente.getTipoParentesco().getDesconto();
		}
		return this.salarioBruto.getSalario() - valorTotalDescontoDependente - this.descontoInss();
	}

	@Override
	public double descontoIR() {
		Double salarioDedutivel = this.calculoSalarioDedutivel();
		if (salarioDedutivel <= 1903.98) {
			return 0;
		} else if (salarioDedutivel > 1903.98 && salarioDedutivel <= 2826.65) {
			return (salarioDedutivel * 0.075) - 142.8;

		} else if (salarioDedutivel > 2826.65 && salarioDedutivel <= 3751.05) {
			return (salarioDedutivel * 0.15) - 354.8;

		} else if (salarioDedutivel > 3751.05 && salarioDedutivel <= 4664.68) {
			return (salarioDedutivel * 0.225) - 636.13;

		} else {
			return (salarioDedutivel * 0.275) - 869.36;
		}
	}

	public double salarioliquido() {
		double valor = 0.0;
		valor = this.salarioBruto.getSalario() - descontoIR() - descontoInss();
		return valor;
	}

}
/*
 * else if (this.salarioBruto.getSalario() < 2427.35) { iR =
 * ((this.salarioBruto.getSalario() - (PERCENTUAL_DESCONTO * dependentes.size())
 * - this.descontoInss(this.salarioBruto.getSalario()))*0.075) - 142.80; return
 * iR;
 */

/*
 * for (Dependente dependente : dependentes) { iR +=
 * ((this.salarioBruto.getSalario() -
 * dependente.getTipoParentesco().getDesconto() -
 * this.descontoInss(this.salarioBruto.getSalario()))*0.075); } return iR;
 */

/*
 * @Override private Double calculoSalarioDedutivel() { Double
 * valorTotalDescontoDependente = 0.0; for (Dependente dependente : dependentes)
 * { valorTotalDescontoDependente +=
 * dependente.getTipoParentesco().getDesconto(); } return
 * this.salarioBruto.getSalario() - valorTotalDescontoDependente -
 * this.descontoInss(this.salarioBruto.getSalario()); } } public double
 * descontoIR() { Double salarioDedutivel = this.calculoSalarioDedutivel();
 * 
 * if (salarioDedutivel <= 1903.98) { return 0; } else if (salarioDedutivel >
 * 1903.98 && salarioDedutivel <= 2826.65) { return (salarioDedutivel * 0.075) -
 * 142.8;
 * 
 * }else if (salarioDedutivel > 2826.65 && salarioDedutivel <= 3751.05) { return
 * (salarioDedutivel * 0.15) - 354.8;
 * 
 * }else if (salarioDedutivel > 3751.05 && salarioDedutivel <= 4664.68) { return
 * (salarioDedutivel * 0.225) - 636.13;
 * 
 * }else{ return (salarioDedutivel * 0.275) - 869.36; } }
 */