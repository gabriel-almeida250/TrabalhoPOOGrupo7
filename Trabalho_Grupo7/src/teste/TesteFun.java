package teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pacote_enum.TipoParentesco;
import pacote_enum.TipoSalario;
import pacote_exception.IdadeException;

public class TesteFun {

	public static void main(String[] args) throws IdadeException {
		try {
			Dependente d1 = new Dependente("Siclano", 14654165, LocalDate.of(2004, 04, 23), TipoParentesco.FILHO);
			Dependente d2 = new Dependente("Beutrano", 4351454, LocalDate.of(2004, 04, 23), TipoParentesco.FILHO);
			Funcionario f1 = new Funcionario("Fulano", 5413654, LocalDate.of(1999, 12, 26), TipoSalario.REPOSITOR,
					List.of(d1, d2));
			f1.descontoIR();
			System.out.printf("R$:%.2f", f1.descontoInss(TipoSalario.REPOSITOR.getSalario()));
			System.out.printf("\nR$:%.2f\n", f1.descontoIR());
			System.out.println(f1);
		} catch (IdadeException e) {
			System.out.println(e.getMessage());
		}
	}
}