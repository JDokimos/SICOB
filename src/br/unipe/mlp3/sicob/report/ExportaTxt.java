package br.unipe.mlp3.sicob.report;

import java.io.FileWriter;

import javax.swing.JOptionPane;

import br.unipe.mlp3.sicob.model.Conta;

public class ExportaTxt {
	
	
	public ExportaTxt() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unused")
	private void gravar(Conta conta) {

		String conteudo = "SICOB"
				 + "\n" 
				 + "\nAGENCIA:      " 
				 + "\nCONTA NUMERO: "
				 + "\nTIPO DA CONTA:"
				 + "\nTITULAR:      "
				 + "\nSALDO ATUAL:  "
				 + "\n";

		
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

	
	
}
