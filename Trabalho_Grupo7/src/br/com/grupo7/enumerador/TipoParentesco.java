package br.com.grupo7.enumerador;

public enum TipoParentesco {

	FILHO(189.59), SOBRINHO(189.59), OUTROS(189.59);

	private Double desconto;

	private TipoParentesco(Double desconto) {
		this.desconto = desconto;
	}

	public Double getDesconto() {
		return desconto;
	}
}
