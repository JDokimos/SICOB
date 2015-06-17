package br.unipe.mlp3.sicob.facade;

import java.util.List;

import br.unipe.mlp3.sicob.model.CadastroDeContas;
import br.unipe.mlp3.sicob.model.Conta;
import br.unipe.mlp3.sicob.model.exception.ContaJaCadastradaException;
import br.unipe.mlp3.sicob.model.exception.ContaNaoEncontradaException;

public class SistemaBanco {

	private CadastroDeContas contaBancaria;

	public SistemaBanco(CadastroDeContas bancaria) {
		this.contaBancaria = bancaria;
	}

	// chamar metodo de cadastro de contas ok
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException {
		contaBancaria.cadastrarConta(conta);
	}

	public void removerConta(Conta conta) throws ContaNaoEncontradaException {
		contaBancaria.removerConta(conta);
	}

	public void atualizarConta(Conta conta) throws ContaNaoEncontradaException {
		contaBancaria.atualizarConta(conta);
	}

	public Conta procurarConta(Conta conta) throws ContaNaoEncontradaException {
		return contaBancaria.procurarConta(conta);
	}

	public List<Conta> getContas(String nome) {
		return contaBancaria.listarContas(nome);
	}

}
