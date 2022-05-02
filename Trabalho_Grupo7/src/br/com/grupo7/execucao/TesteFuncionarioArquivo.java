package br.com.grupo7.execucao;

import java.io.IOException;
import java.util.Set;

import br.com.grupo7.arquivo.EntradaSaidaArquivo;
import br.com.grupo7.classes.Funcionario;

public class TesteFuncionarioArquivo {

	public static void main(String[] args) throws IOException  {
		EntradaSaidaArquivo esa = new EntradaSaidaArquivo();
		Set<Funcionario> lista = esa.entradaArquivo("Arquivos\\funcionarioEntrada.csv");
		esa.saidaArquivo(lista,"Arquivos\\funcionarioSaida.csv");
	}
}
