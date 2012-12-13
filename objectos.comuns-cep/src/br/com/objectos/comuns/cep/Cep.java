/*
 * Cep.java criado em 13/12/2012
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.comuns.cep;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author gustavo.melo@objectos.com.br (Gustavo Melo)
 */
public class Cep {
	static String logradouro, cidade, estado, bairro;

	public String getLogradouro() {
		return logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getBairro() {
		return bairro;
	}

	public boolean buscarCep(String cep) {
		// Cria os parâmetros necessários para se communicar com o site dos
		// correios
		boolean valido = false;
		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("cepEntrada", cep);
		parametros.put("tipoCep", "");
		parametros.put("cepTemp", "");
		parametros.put("metodo", "buscarCep");

		// Faz a comunicação enviando os parâmetros e retorna o código fonte
		// html do site com os dados de endereço
		Document doc = null;
		try {
			doc = Jsoup
					.connect(
							"http://m.correios.com.br/movel/buscaCepConfirma.do")
					.data(parametros).post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Faz a consulta css pela classe respostadestaque no código html do
		// site
		Elements elementos = doc.select(".respostadestaque");

		// Faz uma validação para ver se o cep foi encontrado
		if (elementos.size() == 4) {
			// Mostra todos os indices do resultado da consulta

			logradouro = elementos.get(0).text();
			bairro = elementos.get(1).text();

			cidade = elementos.get(2).text()
					.substring(0, elementos.get(2).text().length() - 3);
			estado = elementos
					.get(2)
					.text()
					.substring(elementos.get(2).text().length() - 2,
							elementos.get(2).text().length());
			valido = true;

		}
		return valido;

	}

}
