package br.com.alura.gerenciador.teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BuscaArquivoTeste {
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("gerenciador/src/main/resources/connection.properties");
		properties.load(fis);
		System.out.println(properties.getProperty("user"));
	}
}
