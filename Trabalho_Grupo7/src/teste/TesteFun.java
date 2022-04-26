package teste;

import java.time.LocalDate;
import java.util.List;

import pacote_enum.TipoParentesco;
import pacote_enum.TipoSalario;
import pacote_exception.CpfException;
import pacote_exception.IdadeException;

public class TesteFun {
	public static void main(String[] args) throws IdadeException {

		try {
			Dependente d1 = new Dependente("Siclano",  "73911422654", LocalDate.of(2004, 04, 23), TipoParentesco.FILHO);
			Dependente d2 = new Dependente("Beutrano",  "73911422654", LocalDate.of(2004, 04, 23), TipoParentesco.FILHO);
			@SuppressWarnings("unused")
			Dependente d3 = new Dependente("Azevedo",   "73911422654", LocalDate.of(2004, 04, 23), TipoParentesco.FILHO);
			Funcionario f1 = new Funcionario("Fulano",  "73911422654", LocalDate.of(1999, 12, 26), TipoSalario.JOVEMAPRENDIZ,
					List.of(d1, d2));
			System.out.printf("R$:%.2f", f1.descontoInss());
			System.out.printf("\nR$:%.2f\n", f1.descontoIR());
			System.out.printf("R$:%.2f\n", f1.salarioliquido());
			System.out.println(f1);
		} catch (IdadeException e) {
			System.out.println(e.getMessage());
		} catch (CpfException e) {
			System.out.println(e.getMessage());
		}
	}
}
