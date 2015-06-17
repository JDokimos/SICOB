package br.unipe.mlp3.sicob.model.exception;

@SuppressWarnings("serial")
public class ContaJaCadastradaException extends Exception {

	public ContaJaCadastradaException(String mensagem) {
		super(mensagem);
	}

	@Override
	public String getMessage() {
		return "Caro usuário, você está tentando incluir uma conta já cadastrada!";
	}

}
