package br.com.bb.jayloja.exceptions;

public class ProdutoNaoCadastradoException extends NaoCadastradoException {
	public ProdutoNaoCadastradoException() {super();}
	public ProdutoNaoCadastradoException(String s) {super(s);}
	public ProdutoNaoCadastradoException(Exception e) {super(e);}
}
