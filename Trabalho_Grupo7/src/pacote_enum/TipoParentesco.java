package pacote_enum;

public enum TipoParentesco {

	FILHO(189.59), SOBRINHO(189.59), OUTROS(189.59);

	private double desconto;

	private TipoParentesco(double desconto) {
		this.desconto = desconto;
	}

	public double getDesconto() {
		return desconto;
	}
}