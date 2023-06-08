package com.projeto.api;

import java.util.HashMap;
import java.util.Map;

public class Util {

	public static Map<String, String> mapearRetornoSimples(String chave, String valor){
		HashMap<String, String> mapa = new HashMap<String, String>();
		if (chave!= null && valor != null) {
			mapa.put(chave, valor);
		}
		return mapa;
	}
}
