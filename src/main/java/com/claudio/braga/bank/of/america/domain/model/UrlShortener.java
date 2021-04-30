package com.claudio.braga.bank.of.america.domain.model;

import org.springframework.stereotype.Component;

@Component
public class UrlShortener {
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final Integer BASE = ALPHABET.length();
	
	public String encode(Integer num) {
		
		StringBuilder strBdr = new StringBuilder();
		while (num > 0) {
			strBdr.append(ALPHABET.charAt(num % BASE));
			num = num / BASE;
		}
		return strBdr.toString();
	}
	
	public static Integer decode(String str) {
		
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			num = num * BASE + ALPHABET.indexOf(str.charAt(i));
		}
		if (num < 0) {
			num = num * (-1);
		}
		return num;
	}
}
