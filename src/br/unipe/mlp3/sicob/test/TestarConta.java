package br.unipe.mlp3.sicob.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import br.unipe.mlp3.sicob.model.Conta;
import br.unipe.mlp3.sicob.model.ContaPoupanca;

public class TestarConta {

	Conta conta;

	// @Before
	// public void setUp() throws Exception {
	// }
	protected void setUp() {
		conta = new ContaPoupanca();
		conta.setId(1);
	}

	// @After
	// public void tearDown() throws Exception {
	// }
	protected void tearDown() {
		conta = null;
	}

	@Test
	public void testConta() {
		fail("Not yet implemented");
	}

}
