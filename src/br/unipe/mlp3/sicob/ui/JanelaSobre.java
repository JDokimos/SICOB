package br.unipe.mlp3.sicob.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JanelaSobre {

	private JFrame sobre;
	private final JProgressBar progressBar = new JProgressBar();
	private int progresso, loader, delay;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaSobre window = new JanelaSobre();
					window.sobre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaSobre() {
		inicializar();
	}

	private void inicializar() {
		sobre = new JFrame();
		sobre.setAlwaysOnTop(true);
		sobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sobre.setBounds(100, 100, 496, 350);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("C:\\SICOB\\utils\\sicobSplash.jpg"));
		sobre.getContentPane().add(lblImagem, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		sobre.getContentPane().add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("SICOB ");
		panel.add(lblNewLabel);
		panel.add(progressBar);
		load(100);
		
		sobre.setLocationRelativeTo(null); // Centraliza o programa
		sobre.setResizable(false);
		sobre.setVisible(true); // Exibe os componentes


	}

	private void load(int load) {
		this.delay = 50;
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

				sobre.setVisible(false);

				}
			}
		});
		progressive.start();
	}

}
