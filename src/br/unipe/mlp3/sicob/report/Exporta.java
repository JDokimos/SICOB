package br.unipe.mlp3.sicob.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Exporta {
	
	String local;

	public Exporta() {
		// TODO Auto-generated constructor stub
	}

	public void gravar(String texto) {

		String conteudo = texto;
		
		try {

			// o true significa q o arquivo será constante
			FileWriter x = new FileWriter(local, true);
			conteudo = "SICOB"
					 + "\n\r"
					 + "\n\r"
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

		try {
			FileWriter arq = new FileWriter("exporta.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf("%s%n%s", nome, senha);
			arq.close();
		} catch (IOException e) {
			System.out.println("Erro ao criar o arquivo");
		} catch (SecurityException securityException) {
			System.err
					.println("Você não tem permissão de escrita nesse arquivo");
			System.exit(1);
		} finally {
			System.out.printf("Arquivo gravado com sucesso");
		}
	}

}
