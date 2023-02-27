package main;

import java.util.HashMap;
import java.util.Map;

public class Tradutor {
	private Map<String,String> traducoes = new HashMap<>();
	private String text;
	
	public boolean estaVazio() {
		return traducoes.isEmpty();
	}

	public String traduzir(String palavra) {
		return traducoes.get(palavra);
	}

	public void adicionarTraducao(String palavra, String traducao) {
		if(traducoes.containsKey(palavra)) {
			traducao = traduzir(palavra)+", "+traducao;
		}
		traducoes.put(palavra,traducao);
	}
	
	public String traduzirFrase(String frase) {
		String[] palavras = frase.split(" ");
		String fraseTraduzida = " ";
		for(String palavra : palavras) {
			String traducao = traduzir(palavra);
			if(traducao.contains(", ")) {
				traducao = PrimeiraTraducaoPalavra(traducao);
			}
			fraseTraduzida += " "+traducao;
		}
		return fraseTraduzida.trim();
	}

	private String PrimeiraTraducaoPalavra(String traducao) {
		traducao = traducao.substring(0,traducao.indexOf(","));
		return traducao;
	}

	public Map<String, String> getTraducoes() {
		return traducoes;
	}

	public void setTraducoes(Map<String, String> traducoes) {
		this.traducoes = traducoes;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Tradutor(String text) {
		this.text = text;
	}
	
	
}
