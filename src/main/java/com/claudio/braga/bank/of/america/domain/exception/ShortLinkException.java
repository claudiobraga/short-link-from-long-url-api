package com.claudio.braga.bank.of.america.domain.exception;

public class ShortLinkException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ShortLinkException(String message) {
		super (message);
	}
}
