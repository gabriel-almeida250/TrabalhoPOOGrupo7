package teste;

import java.time.LocalDate;

import pacote_enum.TipoParentesco;
import pacote_enum.TipoSalario;
import pacote_exception.DependenteException;

public class TesteFun {

	public static void main(String[] args) throws DependenteException {
		
		try {
			Dependente d1 = new Dependente("Siclano", 14654165, LocalDate.of(2004, 04, 23), TipoParentesco.FILHO);
			Funcionario f1 = new Funcionario("Fulano", 5413654, LocalDate.of(1999, 12, 26), TipoSalario.REPOSITOR, d1);
			f1.descontoIR();
			System.out.printf("R$:%.2f",f1.descontoInss(TipoSalario.REPOSITOR.getSalario()));
			System.out.printf("\nR$:%.2f", f1.descontoIR());
		} catch (DependenteException e) {
			System.out.println(e.getMessage());
		}
	}
}