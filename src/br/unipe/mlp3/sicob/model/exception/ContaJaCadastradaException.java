package br.unipe.mlp3.sicob.model.exception;

@SuppressWarnings("serial")
public class ContaJaCadastradaException extends Exception {

	public ContaJaCadastradaException(String mensagem) {
		super(mensagem);
	}

	@Override
	public String getMessage() {
		return "Caro usu�rio, voc� est� tentando incluir uma conta j� cadastrada!";
	}

}
