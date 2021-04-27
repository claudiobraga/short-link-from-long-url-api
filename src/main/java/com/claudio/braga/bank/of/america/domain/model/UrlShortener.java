package com.claudio.braga.bank.of.america.domain.model;

import org.springframework.stereotype.Component;

@Component
public class UrlShortener {
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final String ALPHABET2 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final Integer BASE = ALPHABET.length();
	public static final Integer BASE2 = ALPHABET2.length();
	
	
	public String encode(Integer num) {
		
		StringBuilder strBdr = new StringBuilder();
		while (num > 0) {
			strBdr.append(ALPHABET.charAt(num % BASE));
			num = num / BASE;
		}
		return strBdr.toString();
	}
	
	public String encode2(Integer num) {
		
		StringBuilder strBdr = new StringBuilder();
		while (num > 0) {
			strBdr.append(ALPHABET2.charAt(num % BASE2));
			num = num / BASE2;
		}
		return strBdr.toString();
	}
	
	public Integer decode(String str) {
		
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			num = num * BASE + ALPHABET.indexOf(str.charAt(i));
		}
		return num;
	}
	
	public Integer decode2(String str) {
		
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			num = num * BASE2 + ALPHABET2.indexOf(str.charAt(i));
		}
		return num;
	}

}
