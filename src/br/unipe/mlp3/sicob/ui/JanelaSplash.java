package br.unipe.mlp3.sicob.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JanelaSplash {

	private JFrame splash;
	private final JProgressBar progressBar = new JProgressBar();
	private int progresso, loader, delay;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaSplash window = new JanelaSplash();
					window.splash.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaSplash() {
		inicializar();
	}

	private void inicializar() {
		splash = new JFrame();
		splash.setAlwaysOnTop(true);
		splash.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		splash.setBounds(100, 100, 496, 350);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("C:\\SICOB\\utils\\sicobSplash.jpg"));
		splash.getContentPane().add(lblImagem, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splash.getContentPane().add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("Carregando SICOB ...");
		panel.add(lblNewLabel);
		panel.add(progressBar);
		load(100);
		
		splash.setLocationRelativeTo(null); // Centraliza o programa
		splash.setResizable(false);
		splash.setVisible(true); // Exibe os componentes


	}

	private void load(int load) {
		this.delay = 30;
		this.progresso = 0;
		loader = load;

		Thread progressive = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = progresso; i < loader; i++) {

					progressBar.setValue(i);

					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

				progresso = loader;
				progressBar.setValue(progresso);
				if (progresso == progressBar.getMaximum()) {

					new JanelaPrincipal();
					splash.setVisible(false);

				}
			}
		});
		progressive.start();
	}

}
