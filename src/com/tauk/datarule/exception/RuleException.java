package com.tauk.datarule.exception;

public class RuleException extends RuntimeException {

	public RuleException(String message) {
	        super(message);
	    }

	public RuleException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
