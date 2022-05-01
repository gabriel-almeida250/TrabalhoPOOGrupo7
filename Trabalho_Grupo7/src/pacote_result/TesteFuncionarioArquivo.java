package pacote_result;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import pacote_arquivo.EntradaSaidaArquivo;
import pacote_class.Funcionario;

public class TesteFuncionarioArquivo {

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		EntradaSaidaArquivo esa = new EntradaSaidaArquivo();
		Set<Funcionario> lista = esa.entradaArquivo("Arquivos\\funcionarioEntrada.txt");
		esa.saidaArquivo(lista,"Arquivos\\funcionarioSaida.txt");
	}
}
