package br.unipe.mlp3.sicob.model;

public class Conta {


	// antogardo 9925 2258
	private long id;
	private int agencia;
	private String tipo; // tipo conta poupanca ou corrente
	private String numero;
	private String titular;
	protected double saldo;


	// Construtor Padrao
	public Conta() {
		super();
	}


	// Metodo creditar valor
	public void creditar(double valor) {
		this.saldo += valor;
	}

	// Metodo debitar valor
	public void  debitar (double valor) throws Exception{
		if (this.saldo < valor) {
			throw new Exception("Saldo insuficiente!");
		} 

		else {
			this.saldo -= valor;
		}
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getAgencia() {
		return agencia;
	}


	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
		
	}




}
