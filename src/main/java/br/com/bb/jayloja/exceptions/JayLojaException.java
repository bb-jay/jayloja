package br.com.bb.jayloja.exceptions;

public abstract class JayLojaException extends RuntimeException {
	JayLojaException() {super();}
	JayLojaException(String s) {super(s);}
	JayLojaException(Exception e) {super(e);}
}
