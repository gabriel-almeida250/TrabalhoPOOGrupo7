package teste;

import java.util.Set;

public class Empresa {
	private String cnpj;
	private Set<Funcionario> funcionario;

	public Empresa(String cnpj, Set<Funcionario> funcionario) {
		super();
		this.cnpj = cnpj;
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", funcionario=" + funcionario + "]";
	}

	public String getCnpj() {
		return cnpj;
	}

	public Set<Funcionario> getFuncionario() {
		return funcionario;
	}
}
