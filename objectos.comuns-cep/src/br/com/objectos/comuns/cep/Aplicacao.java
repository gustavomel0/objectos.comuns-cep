/*
 * Aplicacao.java criado em 13/12/2012
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.comuns.cep;

import java.util.Scanner;

/**
 * @author gustavo.melo@objectos.com.br (Gustavo Melo)
 */
public class Aplicacao {
	static String cep = "";

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o CEP:");
		cep = entrada.next();

		Cep c = new Cep();
		c.buscarCep("08461110");
		System.out.println(c.getLogradouro() + "\n\n" + c.getBairro() + "\n\n"
				+ c.getCidade() + "\n\n" + c.getEstado());

	}

}
