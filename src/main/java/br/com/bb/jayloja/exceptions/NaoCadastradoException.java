package br.com.bb.jayloja.exceptions;

public abstract class NaoCadastradoException extends JayLojaException {
	NaoCadastradoException() {super();}
	NaoCadastradoException(String s) {super(s);}
	NaoCadastradoException(Exception e) {super(e);}
}
