package br.unipe.mlp3.sicob.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

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
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unused")
public class JanelaPrincipal {

	private JFrame janela ;
	private JTable tabContas;


	private static String sisNome	= new String("SICOB - Sistema de Informações de Contas Bancárias");
	private static String sisSigla	= new String("SICOB");
	private static String sisVersao	= new String("Versão do Sistema: 2015.06.16.0000");
	private static String sisDevs	= new String("Jarbas e Antongardo");

	public static void main(String[] args) {
		

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println(sisSigla + " - Inicializando Sistema...");
					JanelaPrincipal principal = new JanelaPrincipal();
					//principal.mostraTela();

				} catch (Exception e) {
					System.out.println("Falha ao inicializar Sistema");
					e.printStackTrace();
				}
			}
		});
	}
	

	public JanelaPrincipal() {
		super();
		

		try {
			System.out.println(sisSigla + " - Carregando Componentes...");
			preparaJanela();
			criaMenuBar();
			criaToolBar();
			criaPainelCentral();
			criaStatusBar();
			mostraJanela();
			System.out.println(sisSigla + " - Sistema inicializado com sucesso!");

		} catch (Exception e) {
			System.out.println("Falha ao inicializar Sistema :(");
			e.printStackTrace();
		}
	
	}



	private void criaMenuBar() {

		try {
			System.out.println(sisSigla + " - Criando Barra de Menus...");

			JMenuBar menuBar = new JMenuBar();
			JMenu menuSistema = new JMenu("Sistema");
			JMenu menuAcoes = new JMenu("Ações");
			JMenu menuUtilitrios = new JMenu("Utilitários");
			JMenu menuAjuda = new JMenu("Ajuda");
			JMenuItem imenuSair = new JMenuItem("Sair");
			JMenuItem imenuCadastrarConta = new JMenuItem("Cadastrar Conta");
			JMenuItem imenuEditarConta = new JMenuItem("Editar Conta");
			JMenuItem imenuRemoverConta = new JMenuItem("Remover Conta");
			JMenuItem imenuExportar = new JMenuItem("Exportar Dados da Conta");
			JMenuItem imenuCalculadora = new JMenuItem("Calculadora");
			JMenuItem imenuBlocoDeNotas = new JMenuItem("Bloco de Notas");
			JMenuItem imenuSobre = new JMenuItem("Sobre");

			// Cria Menu Sistema
			menuBar.add(menuSistema);
			menuSistema.add(imenuSair);

			// Cria Menu Acoes
			menuBar.add(menuAcoes);
			menuAcoes.add(imenuCadastrarConta);
			menuAcoes.add(imenuEditarConta);
			menuAcoes.add(imenuRemoverConta);

			menuAcoes.add(imenuExportar);

			// Cria Menu Utilitarios
			menuBar.add(menuUtilitrios);
			menuUtilitrios.add(imenuCalculadora);
			menuUtilitrios.add(imenuBlocoDeNotas);

			// Cria Menu Ajuda
			menuBar.add(menuAjuda);
			menuAjuda.add(imenuSobre);
			janela.setJMenuBar(menuBar);
			
			
			//Acoes
			
			imenuSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();
			}
			});
			
			
			imenuCadastrarConta.addActionListener(new ActionListener() {

				
				@Override
				public void actionPerformed(ActionEvent e) {
					JanelaCadastro janelaCadastro = new JanelaCadastro();
					

				}
				});
			
			imenuCalculadora.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String comando = "cmd /c C:/windows/system32/calc.exe";
					try {
							Runtime.getRuntime().exec(comando);
					} catch (Exception eCalc) {
						System.out.println("Falha ao Abrir Calculadora");
						eCalc.printStackTrace();
					}
				}
			});

			imenuBlocoDeNotas.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String comando = "cmd /c C:/windows/system32/notepad.exe";
					try {
							Runtime.getRuntime().exec(comando);
					} catch (Exception eCalc) {
						System.out.println("Falha ao Abrir Bloco de Notas");
						eCalc.printStackTrace();
					}
				}
			});
			
			imenuSobre.addActionListener(new ActionListener() {

				
				@Override
				public void actionPerformed(ActionEvent e) {
					JanelaSobre splash = new JanelaSobre();
					

				}
				});



			
			
		} catch (Exception e) {
			System.out.println("Falha ao criar Barra de Menus");
			e.printStackTrace();
		}
	}
	
	private void criaToolBar() {
		
		try {
			System.out.println("SICOB - Criando Barra de Ferramentas...");

			JToolBar tbrAtalhos = new JToolBar();
			JButton btnCadastrarConta = new JButton("");
			JButton btnEditarConta = new JButton("");
			JButton btnRemoverConta = new JButton("");
			JButton btnExportar = new JButton("");
			JButton btnEspecial = new JButton("");

			tbrAtalhos.setRollover(true);
			tbrAtalhos.setFloatable(false);

			// Botao Cadastrar Contas da Barra de Atalhos
			btnCadastrarConta.setToolTipText("Cadastrar Conta");
			btnCadastrarConta.setIcon(new ImageIcon("C:\\SICOB\\utils\\adicionarConta.png"));
			tbrAtalhos.add(btnCadastrarConta);
			
			// Botao Editar Contas da Barra de Atalhos
			btnEditarConta.setToolTipText("Editar Conta");
			btnEditarConta.setIcon(new ImageIcon("C:\\SICOB\\utils\\editarConta.png"));
			tbrAtalhos.add(btnEditarConta);

			// Botao Remover Conta da Barra de Atalhos
			btnRemoverConta.setToolTipText("Remover Conta");
			btnRemoverConta.setIcon(new ImageIcon("C:\\SICOB\\utils\\removerConta.png"));
			tbrAtalhos.add(btnRemoverConta);
			
	

			// Botao Exportar Dados da Conta da Barra de Atalhos
			btnExportar.setToolTipText("Exportar Dados da Conta");
			btnExportar.setIcon(new ImageIcon("C:\\SICOB\\utils\\exportar.png"));
			tbrAtalhos.add(btnExportar);
			
			// Botao Especial
			//btnEspecial.setToolTipText("Requisito Especial");
			//btnEspecial.setIcon(new ImageIcon("C:\\SICOB\\utils\\especial.png"));
			//tbrAtalhos.add(btnEspecial);
			
			btnCadastrarConta.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					try {
						JanelaCadastro janelaCadastro = new JanelaCadastro();
					} catch (Exception eCalc) {
						System.out.println("Falha ao abrir janela de cadastros");
						eCalc.printStackTrace();
					}
				}
			});

			
			btnExportar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					try {
							gravar(null);
					} catch (Exception eCalc) {
						System.out.println("Falha ao exportar dados da conta");
						eCalc.printStackTrace();
					}
				}
			});
			
			

			janela.add(tbrAtalhos, BorderLayout.NORTH);

		} catch (Exception e) {
			System.out.println("Falha ao criar Barra de Ferramentas");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void criaPainelCentral() {

		try {
			System.out.println(sisSigla +" - Criando Painel Central...");

			JPanel pnlOrganizar = new JPanel();
			JLabel lblOrganizar = new JLabel("Organizar Colunas por: ");
			JComboBox comboBox = new JComboBox();

			JPanel pnlExportar = new JPanel();
			JButton btnExportarDown = new JButton("Exportar Dados da Conta...");
			
			JPanel pnlContas = new JPanel();
			JScrollPane pnlScrollContas = new JScrollPane(tabContas);
			String[] colunas = new String [] {"Agencia", "Tipo de Conta", "Numero da Conta", "Titular da Conta", "Saldo Atual"};
			Object[][] dados = new Object[][] {{null, null, null, null, null},};
	
			pnlOrganizar.add(lblOrganizar);
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Titular da Conta", "Agencia", "Tipo de Conta", "Numero da Conta", "Saldo Atual"}));
			comboBox.setModel(new DefaultComboBoxModel(colunas));
			pnlOrganizar.add(comboBox);

		    // Ao inves de passar direto, colocamos os dados em um modelo  
		    DefaultTableModel tabModelo = new DefaultTableModel(dados, colunas);  
			tabContas = new JTable(tabModelo);
			tabContas.getColumnModel().getColumn(0).setPreferredWidth(100);
			tabContas.getColumnModel().getColumn(1).setPreferredWidth(100);
			tabContas.getColumnModel().getColumn(2).setPreferredWidth(100);
			tabContas.getColumnModel().getColumn(3).setPreferredWidth(300);
			tabContas.getColumnModel().getColumn(4).setPreferredWidth(100);
			pnlScrollContas.setColumnHeaderView(tabContas);
			pnlScrollContas.setViewportView(tabContas); //faltava isso
				
			pnlExportar.add(btnExportarDown);
		
			pnlContas.setLayout(new BorderLayout(0, 0));
			pnlContas.add(pnlOrganizar, BorderLayout.NORTH);
			pnlContas.add(pnlScrollContas, BorderLayout.CENTER);
			//pnlContas.add(pnlExportar, BorderLayout.SOUTH);
			janela.add(pnlContas, BorderLayout.CENTER);

		} catch (Exception e) {
			System.out.println("Falha ao criar Painel Central");
			e.printStackTrace();
		}
	}

	private void criaStatusBar() {

		try {
			System.out.println(sisSigla +" - Criando Barra de Status...");
			JPanel pnlVersao = new JPanel();
			JLabel lblVersao = new JLabel(sisVersao);
			pnlVersao.setBorder(new BevelBorder(BevelBorder.LOWERED));
			lblVersao.setFont(new Font("Tahoma", Font.PLAIN, 9));
			pnlVersao.add(lblVersao);
			janela.add(pnlVersao, BorderLayout.SOUTH);
			System.out.println(sisSigla +" - Carregando "+ sisVersao +"...");
			
		} catch (Exception e) {
			System.out.println("Falha ao criar Barra de Status");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	private void gravar(String texto) {

		String conteudo = texto;
		
		try {

			FileWriter x = new FileWriter("C:\\SICOB\\report\\exportaTXT.txt");
			conteudo = "SICOB"
					 + "\n"
					 + "\nAGENCIA:      "
					 + "\nCONTA NUMERO: "
					 + "\nTIPO DA CONTA:"
					 + "\nTITULAR:      "
					 + "\nSALDO ATUAL:  "
					 + "\n"
					 + "\n"
					 + sisNome
					; 
			x.write(conteudo); 
			x.close(); // cria o arquivo
			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso",
					"Concluído", JOptionPane.INFORMATION_MESSAGE);
		}
		// em caso de erro apreenta mensagem abaixo
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	
	private void sair() {
		System.out.println(sisSigla +" - Fianlizando Sistema");
		JOptionPane.showMessageDialog(janela, "Saindo do sistema...", sisSigla,
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}	
	

	private void preparaJanela() {

		try {
			System.out.println(sisSigla +" - Criando JanelaPrincipal Principal...");

			janela = new JFrame();
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.setTitle(sisNome);
			janela.pack();
			janela.setLayout(new BorderLayout());
	
		} catch (Exception e) {
			System.out.println("Falha ao criar a MAIN FRAME");
			e.printStackTrace();
		}
	}

	private void mostraJanela() {

		try {
			System.out.println(sisSigla +" - Carregando Interface do Usuário...");

			// Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
			// janela.setSize((tela.width - 200), (tela.height - 200)); 
			janela.setSize(800, 600);
			janela.setLocationRelativeTo(null); // Centraliza o programa
			janela.setVisible(true); // Exibe os componentes

	
		} catch (Exception e) {
			System.out.println("Falha ao carregar Interface do Usuário");
			e.printStackTrace();
		}
	}
}
