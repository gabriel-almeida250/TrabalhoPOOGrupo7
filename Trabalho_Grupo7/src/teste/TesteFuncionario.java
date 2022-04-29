package teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TesteFuncionario {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Set<Funcionario> listaFuncionario = new HashSet<>();
		Funcionario funcionario = null;
		try {
			Scanner sc = new Scanner(new InputStreamReader(new FileInputStream("c:\\Exemplos\\funcionario.txt"), "UTF-8"));
			while (sc.hasNextLine()) {
				String linha = sc.nextLine();
				if (!linha.isEmpty()) {
					String[] dadoslinha = linha.split(";");
					String nome ;
				}
				listaFuncionario.add(funcionario);
			}
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
