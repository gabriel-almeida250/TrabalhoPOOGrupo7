package pacote_enum;

public enum TipoFuncionario {

	GERENTE("Gerente", 8500.00), AÇOGUEIRO("Açogueiro", 6500.00), REPOSITOR("Repositor",2630.00),
	JOVEMAPRENDIZ("Jovem Aprendiz", 1384.00), PADEIRO("Padeiro", 3500.00);

	private String cargo;
	private double salario;

	private TipoFuncionario(String cargo, double salario) {
		this.cargo = cargo;
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public double getSalario() {
		return salario;
	}

}
