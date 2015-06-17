package br.unipe.mlp3.sicob.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {


	public Connection getConnection() {
		try {
			String url = "jdbc:postgresql://localhost/contas";
			String user = "postgres";
			String password = "postgres";

			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
