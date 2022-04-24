package teste;

import java.util.ArrayList;

public class Empresa {
	private int cnpj;
	private ArrayList<Funcionario> funcionario;

	public Empresa(int cnpj, ArrayList<Funcionario> funcionario) {
		super();
		this.cnpj = cnpj;
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", funcionario=" + funcionario + "]";
	}

	public int getCnpj() {
		return cnpj;
	}

	public ArrayList<Funcionario> getFuncionario() {
		return funcionario;
	}
}
