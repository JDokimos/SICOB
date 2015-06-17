package br.unipe.mlp3.sicob.ui;

public class Main {

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//JanelaPrincipal janela = new JanelaPrincipal();
					//janela.setVisible(true);
					
					new JanelaSplash();
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}
