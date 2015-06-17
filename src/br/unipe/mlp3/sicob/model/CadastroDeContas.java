package br.unipe.mlp3.sicob.model;

import java.util.List;

import br.unipe.mlp3.sicob.model.Conta;
import br.unipe.mlp3.sicob.dao.*;
import br.unipe.mlp3.sicob.model.exception.*;

public class CadastroDeContas {

	IContasBancarias persitencia;
	
	public CadastroDeContas(IContasBancarias persitencia) {
		this.persitencia = persitencia;
	}
	
	// metodo adicionar conta ok
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException {	
		// se nao existir... adiciona
		if(!persitencia.existe(conta)){
			persitencia.adicionar(conta);
		}else{
			throw new ContaJaCadastradaException("Conta já existe!");
		}
	}
	
	// remove conta ok
	public void removerConta(Conta conta) throws ContaNaoEncontradaException {
		if(persitencia.existe(conta)){
			persitencia.remover(conta);
		}else{
			throw new ContaNaoEncontradaException("Conta não encontrada!");
		}
	}


	// atualizar ok
	public void atualizarConta(Conta conta) throws ContaNaoEncontradaException {		
		if(persitencia.existe(conta)){
			persitencia.atualizar(conta);
		}else{
			throw new ContaNaoEncontradaException("Conta não encontrada!");
		}
	}

	

	//listar contas (+/- ok) revisar
	public List<Conta> listarContas(String numero) {
		return persitencia.listar(numero);
	}
	
	
	// procurar passando conta ok
	public Conta procurarConta(Conta conta) throws ContaNaoEncontradaException{	
		// se a conta passada existir... retorna dados da conta
		if(persitencia.existe(conta)){
			return persitencia.procurar(conta);
		}else{
			throw new ContaNaoEncontradaException("Conta não encontrada!");
		}
	}
	
		
	
	

}
