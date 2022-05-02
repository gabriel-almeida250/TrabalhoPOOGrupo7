package pacote_result;

import java.io.IOException;
import java.util.Set;

import pacote_arquivo.EntradaSaidaArquivo;
import pacote_class.Funcionario;

public class TesteFuncionarioArquivo {

	public static void main(String[] args) throws IOException {
		EntradaSaidaArquivo esa = new EntradaSaidaArquivo();
		Set<Funcionario> lista = esa.entradaArquivo("Arquivos\\funcionarioEntrada.csv");
		esa.saidaArquivo(lista,"Arquivos\\funcionarioSaida.csv");
	}
}
