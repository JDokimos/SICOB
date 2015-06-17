package br.unipe.mlp3.sicob.dao;

import java.util.List;

import br.unipe.mlp3.sicob.model.Conta;

public interface IContasBancarias {

	public void adicionar(Conta conta);

	public void remover(Conta conta);

	public void atualizar(Conta conta);

	public List<Conta> listar(String numero);

	Conta procurar(Conta conta);

	boolean existe(Conta conta);

}
