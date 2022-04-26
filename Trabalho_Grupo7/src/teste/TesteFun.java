package teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pacote_enum.TipoParentesco;
import pacote_enum.TipoSalario;
import pacote_exception.CpfException;
import pacote_exception.IdadeException;

public class TesteFun {
	public static void main(String[] args) throws IdadeException {
		try {
			Dependente d1 = new Dependente("Valdeir",  "73911422654", LocalDate.of(2004, 04, 23), TipoParentesco.FILHO);
			Dependente d2 = new Dependente("Zé",  "73911422654", LocalDate.of(2004, 04, 23), TipoParentesco.FILHO);
			List<Dependente> dependentes1 = new ArrayList<>();
			dependentes1.add(d1);
			dependentes1.add(d2);
			Funcionario f1 = new Funcionario("Diego",  "73911422654", LocalDate.of(1999, 12, 26), TipoSalario.GERENTE,dependentes1);
			System.out.println(f1);
			System.out.println();
			System.out.println("Contra Cheque:");
			System.out.println("--------------");
			System.out.printf("Desconto Inss R$:%.2f", f1.descontoInss());
			System.out.printf("\nDesconto IR R$:%.2f\n", f1.descontoIR());
			System.out.printf("Salário Líquido R$:%.2f\n", f1.salarioliquido());
			System.out.println("======= FIM =======");
			Dependente d3 = new Dependente("Azevedo",   "73911422654", LocalDate.of(2004, 04, 23), TipoParentesco.FILHO);
			Dependente d4 = new Dependente("Frederico", "31212132133", LocalDate.of(2005, 04, 23), TipoParentesco.OUTROS);
			Dependente d5 = new Dependente("Arnaldo",   "21321321321", LocalDate.of(2006, 04, 23), TipoParentesco.SOBRINHO);
			List<Dependente> dependentes2 = new ArrayList<>();
			dependentes2.add(d3);
			dependentes2.add(d4);
			dependentes2.add(d5);
			System.out.println();
			Funcionario f2 = new Funcionario("Douglas", "13513245465", LocalDate.of(1958, 02, 11), TipoSalario.JOVEMAPRENDIZ, dependentes2);
			System.out.println(f2);
			System.out.println();
			System.out.printf("Desconto Inss R$:%.2f",    f2.descontoInss());
			System.out.printf("\nDesconto IR R$:%.2f\n", f2.descontoIR());
			System.out.printf("Salário Líquido R$:%.2f\n",f2.salarioliquido());
			System.out.println("======= FIM =======");
		} catch (IdadeException e) {
			System.out.println(e.getMessage());
		} catch (CpfException e) {
			System.out.println(e.getMessage());
		}
	}
}
