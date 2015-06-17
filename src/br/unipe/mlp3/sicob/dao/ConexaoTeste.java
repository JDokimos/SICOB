package br.unipe.mlp3.sicob.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoTeste {

	public void conexao(String usuario, String senha) {

		try {
			Class.forName("org.postgresql.Driver"); // para o bd postgresql
			String url = "jdbc:postgresql://localhost/sicob"; // para o bd postgresql
			Connection conn = DriverManager.getConnection(url, usuario, senha);
			Statement stmt = conn.createStatement();
			String query = "select * from contas";
			ResultSet rs = stmt.executeQuery(query);

	
			while (rs.next()) {
				int i = 1;
				int id = rs.getInt(i++);
				int agencia = rs.getInt(i++);
				String numero = rs.getString(i++);
				String tipo = rs.getString(i++);
				String titular = rs.getString(i++);
				double saldo = rs.getDouble(i++);				


				System.out.printf(
						"objeto -> id = %d, "
						+ "agencia = %d, "
						+ "numero = %s, "
						+ "tipo = %s, "
						+ "titular = %s, "
						+ "saldo = %.2f \n", 
						id, agencia,
						numero, tipo, titular, saldo);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		ConexaoTeste con = new ConexaoTeste();
		con.conexao("postgres", "postgres");
	}

}
