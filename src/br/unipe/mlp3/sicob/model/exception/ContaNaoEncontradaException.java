package br.unipe.mlp3.sicob.model.exception;

@SuppressWarnings("serial")
public class ContaNaoEncontradaException extends Exception {

	public ContaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	@Override
	public String getMessage() {
		return "Conta não encontrada!";
	}

}
