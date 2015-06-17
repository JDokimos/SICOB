package br.unipe.mlp3.sicob.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unused")
public class JanelaCadastro {

	private JFrame janelaCadastro;

	private static String sisNome = new String("SICOB - Sistema de Informações de Contas Bancárias");
	private static String sisSigla = new String("SICOB");
	private static String sisVersao = new String("Versão do Sistema: 2015.06.04.0000");
	private static String sisDevs = new String("Jarbas e Antongardo");

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println(sisSigla + " - Inicializando Gerenciamento de Contas...");
					JanelaCadastro principal = new JanelaCadastro();
	
				} catch (Exception e) {
					System.out.println("Falha ao inicializar Gerenciamento de Cadastro");
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaCadastro() {
		super();

		try {
			System.out.println(sisSigla + " - Carregando Componentes...");
			preparaJanela();
			criaPainelTitulos();
			criaPainelCadastro();
			criaPainelBotoes();
			mostraJanela();
			System.out.println(sisSigla
					+ " - Gerenciamento de Contas inicializado com sucesso!");

		} catch (Exception e) {
			System.out.println("Falha ao inicializar Sistema :(");
			e.printStackTrace();
		}

	}

	private void criaPainelTitulos() {

		try {
			System.out.println(sisSigla + " - Criando Painel de Títulos...");
			JPanel pnlTitulo = new JPanel();
			JLabel lblGerenciamentoDeContas = new JLabel("Gerenciamento de Contas");
			
			janelaCadastro.add(pnlTitulo, BorderLayout.NORTH);
			pnlTitulo.add(lblGerenciamentoDeContas);

		} catch (Exception e) {
			System.out.println("Falha ao criar Painel de Títulos");
			e.printStackTrace();
		}
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void criaPainelCadastro() {

		try {
			System.out.println(sisSigla + " - Criando Painel Central...");
				
			JPanel pnlCadastro	= new JPanel();
			JLabel lblAgencia	= new JLabel("Agencia");
			JLabel lblTipoConta	= new JLabel("Tipo de Conta");
			JLabel lblNumConta	= new JLabel("Numero da Conta");
			JLabel lblTitular	= new JLabel("Titular da Conta");
			JLabel lblSaldoAtual = new JLabel("Saldo Atual da Conta");
			
			JTextField txtAgencia = new JTextField();
			String[] tipoConta = new String [] {"Escolha o Tipo da Conta", "Conta Poupança", "Conta Corrente"};
			JComboBox comboBoxTipoConta = new JComboBox();

			JTextField txtNumConta = new JTextField();
			JTextField txtTitular = new JTextField();
			JTextField txtSaldoAtual = new JTextField("0,00");

			lblAgencia.setBounds(10, 12, 100, 14);
			txtAgencia.setBounds(10, 32, 100, 20);

			lblTipoConta.setBounds(140, 11, 106, 14);
			comboBoxTipoConta.setBounds(140, 30, 232, 22);
			//comboBoxTipoConta.setModel(new DefaultComboBoxModel(new String[] {"Conta Poupança", "Conta Corrente"}));
			comboBoxTipoConta.setModel(new DefaultComboBoxModel(tipoConta));


			lblNumConta.setBounds(10, 79, 100, 14);
			txtNumConta.setBounds(10, 101, 100, 20);

			lblTitular.setBounds(140, 79, 106, 14);
			txtTitular.setBounds(140, 101, 232, 20);

			lblSaldoAtual.setBounds(121, 156, 127, 14);
			txtSaldoAtual.setBounds(131, 181, 108, 20);

			pnlCadastro.add(lblAgencia);
			pnlCadastro.add(txtAgencia);
			pnlCadastro.add(lblTipoConta);
			pnlCadastro.add(comboBoxTipoConta);
			pnlCadastro.add(lblNumConta);
			pnlCadastro.add(txtNumConta);
			pnlCadastro.add(lblTitular);
			pnlCadastro.add(txtTitular);
			pnlCadastro.add(lblSaldoAtual);
			pnlCadastro.add(txtSaldoAtual);
								
			//txtTitular.setColumns(10);
			//txtAgencia.setColumns(10);
			//txtNumConta.setColumns(10);
			//txtSaldoAtual.setColumns(10);
			//lblSaldoAtual.setHorizontalAlignment(SwingConstants.CENTER);
			
			pnlCadastro.setLayout(null);
			janelaCadastro.add(pnlCadastro, BorderLayout.CENTER);

		} catch (Exception e) {
			System.out.println("Falha ao criar Painel Central");
			e.printStackTrace();
		}
	}

	private void criaPainelBotoes() {

		try {
			System.out.println(sisSigla + " - Criando Painel de Botões...");
				
			JPanel pnlBotoes	= new JPanel();
			JButton btnSalvar	= new JButton("Salvar     ");
			JButton btnCancelar	= new JButton("Cancelar");
			
			btnSalvar.setIcon(new ImageIcon("C:\\SICOB\\utils\\salvar.png"));
			pnlBotoes.add(btnSalvar);
			btnCancelar.setIcon(new ImageIcon("C:\\SICOB\\utils\\remover.png"));
			pnlBotoes.add(btnCancelar);

			janelaCadastro.add(pnlBotoes, BorderLayout.SOUTH);
		
		} catch (Exception e) {
			System.out.println("Falha ao carregar Painel de Botões");
			e.printStackTrace();
		}
	}

	private void preparaJanela() {

		try {
			System.out.println(sisSigla	+ " - Criando Tela de Cadastro de Contas...");
			janelaCadastro = new JFrame();
			janelaCadastro.setTitle(sisSigla);
			janelaCadastro.pack();
			janelaCadastro.setLayout(new BorderLayout());

		} catch (Exception e) {
			System.out.println("Falha ao criar a Tela de Cadastro de Contas");
			e.printStackTrace();
		}
	}

	private void mostraJanela() {

		try {
			System.out.println(sisSigla
					+ " - Carregando Tela de Cadastro...");

			janelaCadastro.setSize(400, 350);
			janelaCadastro.setBounds(100, 100, 400, 350);

			janelaCadastro.setLocationRelativeTo(null); // Centraliza o programa
			janelaCadastro.setVisible(true); // Exibe os componentes
			
				

		} catch (Exception e) {
			System.out.println("Falha ao carregar Interface do Usuário");
			e.printStackTrace();
		}
	}
}
