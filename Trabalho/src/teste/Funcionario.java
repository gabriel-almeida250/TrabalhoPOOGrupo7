package teste;

import java.time.LocalDate;

import pacote_enum.TipoSalario;
import pacote_interface.Tributos;

public class Funcionario extends Pessoa implements Tributos {
	private TipoSalario salarioBruto;
	private Dependente dependente;

	public Funcionario(String nome, int cpf, LocalDate dataNascimento, TipoSalario salarioBruto, Dependente dependente) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.dependente = dependente;
	}

	@Override
	public String toString() {
		return "Funcionario [salarioBruto=" + salarioBruto + ", dependente=" + dependente + ", nome=" + nome + ", cpf="
				+ cpf + ", dataNascimento=" + dataNascimento + "]";
	}

	public TipoSalario getSalarioBruto() {
		return salarioBruto;
	}

	public Dependente getDependente() {
		return dependente;
	}

	@Override
	public double descontoInss(double salario) {
		if (salario < 1212.0) {
			double desconto = this.salarioBruto.getSalario() * 0.075;
			return desconto;
		} else if (salario < 2427.35) {
			double desconto = (this.salarioBruto.getSalario() * 0.09) - 18.18; 
			return desconto;
		}else if (salario < 3641.03) {
			double desconto = this.salarioBruto.getSalario() * 0.12 - 91.00; 
			return desconto;
		}else if (salario < 7087.22) {
			double desconto = this.salarioBruto.getSalario() * 0.14 - 163.82;
			return desconto;
		}else if (salario > 7087.22) {
			double desconto = 7087.22 * 0.14 - 163.82; 
			return desconto;
		}
		return salario;}

	@Override
	public double descontoIR() {
		double valor = 0.0;
		if (this.salarioBruto.getSalario() < 1212.0) {
			double iR = ((this.salarioBruto.getSalario() - this.dependente.getTipoParentesco().getDesconto() - this.descontoInss(this.salarioBruto.getSalario()))*0.075);
			return iR;
		}else if (this.salarioBruto.getSalario() < 2427.35) {
			double iR = ((this.salarioBruto.getSalario() - this.dependente.getTipoParentesco().getDesconto() - this.descontoInss(this.salarioBruto.getSalario()))*0.075) - 142.80; 
			return iR;
		}else if (this.salarioBruto.getSalario() < 3641.03) {
			double iR = ((this.salarioBruto.getSalario() - this.dependente.getTipoParentesco().getDesconto() - this.descontoInss(this.salarioBruto.getSalario()))*0.075) - 142.80;
			return iR;
		}else if (this.salarioBruto.getSalario() < 7087.22) {
			double iR = ((this.salarioBruto.getSalario() - this.dependente.getTipoParentesco().getDesconto() - this.descontoInss(this.salarioBruto.getSalario()))*0.15) - 354.80;
			return iR;
		}else if (this.salarioBruto.getSalario() > 7087.22) {
			double iR = ((this.salarioBruto.getSalario() - this.dependente.getTipoParentesco().getDesconto() - this.descontoInss(this.salarioBruto.getSalario()))*0.275) - 869.36;
			return iR;
		}
		return valor;
	}
}
