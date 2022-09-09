package br.com.bb.jayloja.exceptions;

public class PedidoNaoEncontradoException extends NaoCadastradoException {
	public PedidoNaoEncontradoException(String s) {super(s);}
	public PedidoNaoEncontradoException() {super();}
	public PedidoNaoEncontradoException(Exception e) {super(e);}
}
