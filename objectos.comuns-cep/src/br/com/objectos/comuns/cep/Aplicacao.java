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

	public static void main(String[] args) { //@marcioendo teste
		Scanner entrada = new Scanner(System.in);
		String r = "s";
		while (r.equals("s")) {
			System.out.println("Informe o CEP:");
			cep = entrada.next();

			Cep c = new Cep();
			if (c.buscarCep(cep) == true) {
				System.out.println("Logradouro: " + c.getLogradouro()
						+ "\nBairro: " + c.getBairro() + "\nCidade: "
						+ c.getCidade() + "\nEstado: " + c.getEstado());
			} else {
				System.out.println("CEP inexistente.");
			}
			System.out.println("\n\nDeseja repetir? (s/n)");
			r = entrada.next();

		}

	}

}
