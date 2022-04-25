package teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pacote_enum.TipoSalario;
import pacote_interface.Tributos;

public class Funcionario extends Pessoa implements Tributos {
	private static final Double PERCENTUAL_DESCONTO = 189.59;
	private TipoSalario salarioBruto;
	private List<Dependente> dependentes = new ArrayList<>();

	public Funcionario(String nome, int cpf, LocalDate dataNascimento, TipoSalario salarioBruto,
			List<Dependente> dependentes) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.dependentes = dependentes;
	}

	@Override
	public String toString() {
		return "Funcionário: " + super.toString() + ", Salário Bruto:" + salarioBruto.getSalario() + "\nDependentes: " + dependentes;
	}

	public TipoSalario getSalarioBruto() {
		return salarioBruto;
	}

	public List<Dependente> getDependente() {
		return dependentes;
	}

	@Override
	public double descontoInss(double salario) {
		if (salario < 1212.0) {
			double desconto = this.salarioBruto.getSalario() * 0.075;
			return desconto;
		} else if (salario < 2427.35) {
			double desconto = (this.salarioBruto.getSalario() * 0.09) - 18.18;
			return desconto;
		} else if (salario < 3641.03) {
			double desconto = this.salarioBruto.getSalario() * 0.12 - 91.00;
			return desconto;
		} else if (salario < 7087.22) {
			double desconto = this.salarioBruto.getSalario() * 0.14 - 163.82;
			return desconto;
		} else if (salario > 7087.22) {
			double desconto = 7087.22 * 0.14 - 163.82;
			return desconto;
		}
		return salario;
	}

	@Override
	public double descontoIR() {
		double valor = 0.0;
		double iR = 0.0d;
		if (this.salarioBruto.getSalario() < 1212.0) {
			iR += ((this.salarioBruto.getSalario() - (PERCENTUAL_DESCONTO * dependentes.size())
					- this.descontoInss(this.salarioBruto.getSalario())) * 0.075);
			return iR;
		} else if (this.salarioBruto.getSalario() < 2427.35) {
			iR = ((this.salarioBruto.getSalario() - (PERCENTUAL_DESCONTO * dependentes.size())
					- this.descontoInss(this.salarioBruto.getSalario())) * 0.075) - 142.80;
			return iR;
		} else if (this.salarioBruto.getSalario() < 3641.03) {
			iR = ((this.salarioBruto.getSalario() - (PERCENTUAL_DESCONTO * dependentes.size())
					- this.descontoInss(this.salarioBruto.getSalario())) * 0.075) - 142.80;
			return iR;
		} else if (this.salarioBruto.getSalario() < 7087.22) {
			iR = ((this.salarioBruto.getSalario() - (PERCENTUAL_DESCONTO * dependentes.size())
					- this.descontoInss(this.salarioBruto.getSalario())) * 0.15) - 354.80;
			return iR;
		} else if (this.salarioBruto.getSalario() > 7087.22) {
			iR = ((this.salarioBruto.getSalario() - (PERCENTUAL_DESCONTO * dependentes.size())
					- this.descontoInss(this.salarioBruto.getSalario())) * 0.275) - 869.36;
			return iR;
		}
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