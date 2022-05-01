package pacote_arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import pacote_class.Dependente;
import pacote_class.Funcionario;
import pacote_enum.TipoParentesco;
import pacote_exception.CpfTamanhoException;
import pacote_exception.IdadeException;

public class EntradaSaidaArquivo {
	public Set<Funcionario>  entradaArquivo(String arquivo) throws UnsupportedEncodingException, FileNotFoundException  {
		Set<Funcionario> listaFuncionarios = new HashSet<>();
		Funcionario funcionario = null;
		Scanner leia = new Scanner(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));
		try {
			while (leia.hasNextLine()) {
				String linha = leia.nextLine();
				if (!linha.isEmpty()) {
					String[] dados = linha.split(";");
					if (funcionario != null) {
						String nomeDependente = dados[0], 
							   cpfDependente = dados[1], 
							   nascimentoDependente = dados[2],
							   tipoParentesco = dados[3];
						Dependente dependente = new Dependente(nomeDependente, 
													cpfDependente, 
													LocalDate.parse(nascimentoDependente, DateTimeFormatter.BASIC_ISO_DATE), 
													TipoParentesco.valueOf(tipoParentesco));
						funcionario.getDependente().add(dependente);
						continue;
					}
					String nomeFuncionario = dados[0], 
						   cpfFuncionario = dados[1], 
						   nascimentoFuncionario = dados[2],
						   salarioBruto = dados[3];
					funcionario = new Funcionario(nomeFuncionario,
												  cpfFuncionario,
												  LocalDate.parse(nascimentoFuncionario, DateTimeFormatter.BASIC_ISO_DATE), 
												  Double.parseDouble(salarioBruto));
				} else {
					listaFuncionarios.add(funcionario);
					funcionario = null;
				}
			}
			if (funcionario != null) {
				listaFuncionarios.add(funcionario);
				leia.close();
			}
		} catch (CpfTamanhoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IdadeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		for (Funcionario funcionarios : listaFuncionarios) {
			System.out.println(funcionarios);
			System.out.println();
		}
		return listaFuncionarios;
	}
		public void saidaArquivo (Set<Funcionario> listaFuncionarios, String arquivo) {
			DecimalFormat deci = new DecimalFormat("0.00");
			FileWriter arquivoSaida = null;
		try {
			arquivoSaida = new FileWriter(arquivo);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(arquivoSaida);
		
		for (Funcionario funcionario : listaFuncionarios) {
			String linha = funcionario.getNome() + ";" +
						   funcionario.getCpf() + ";" +
						   deci.format(funcionario.descontoInss()) + ";" +
						   deci.format(funcionario.descontoIR()) + ";" +
						   deci.format(funcionario.salarioliquido()) + "\n";
			pw.print(linha);
		}
		pw.close();
	}
}