package br.unipe.mlp3.sicob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unipe.mlp3.sicob.model.Conta;

public class ContasBancariasDAO implements IContasBancarias {

	private Connection conn;
	private PreparedStatement stmt = null;

	public ContasBancariasDAO() {
		this.conn = new Conexao().getConnection();
	}

	@Override
	public void adicionar(Conta conta) {
		String sql = "insert into conta (id, agencia, numero, tipo, tutular, saldo) values (?, ?, ?, ?, ?, ?)";

		try {
			stmt = conn.prepareStatement(sql);
			int i = 0;
			stmt.setInt(++i, conta.getAgencia());
			stmt.setString(++i, conta.getNumero());
			stmt.setString(++i, conta.getTipo());
			stmt.setString(++i, conta.getTitular());
			stmt.setDouble(++i, conta.getSaldo());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close(); // finaliza a conexao se existir
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void remover(Conta conta) {
		PreparedStatement stmt = null;

		String sql = "delete from conta where id = ?";

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setLong(1, conta.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Conta> listar(String numero) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Conta> contas = new ArrayList<>();

		try {
			String sql = "select id, agencia, numero, tipo, tutular, saldo from conta";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + numero + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Conta conta = new Conta();
				conta.setId(rs.getInt("id"));
				conta.setAgencia(rs.getInt("agencia"));
				conta.setNumero(rs.getString("numero"));
				conta.setTipo(rs.getString("tipo"));
				conta.setTitular(rs.getString("titular"));
				conta.setSaldo(rs.getDouble("saldo"));

				contas.add(conta);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (stmt != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contas;
	}

	@Override
	public void atualizar(Conta conta) {
		PreparedStatement stmt = null;
		String sql = "update conta set id=?, agencia=?, numero=?, tipo=?, titular=?, saldo=? where id=?";

		try {
			stmt = conn.prepareStatement(sql);

			int i = 0;
			stmt.setInt(++i, conta.getAgencia());
			stmt.setString(++i, conta.getNumero());
			stmt.setString(++i, conta.getTipo());
			stmt.setString(++i, conta.getTitular());
			stmt.setDouble(++i, conta.getSaldo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Conta procurar(Conta conta) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Conta contaEncontrada = new Conta();
		String sql = "select id, agencia, numero, tipo, tutular, saldo from conta where numero = ?";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, conta.getNumero());

			rs = stmt.executeQuery();
			if (rs.next()) {
				contaEncontrada.setId(rs.getInt("id"));
				contaEncontrada.setAgencia(rs.getInt("agencia"));
				contaEncontrada.setNumero(rs.getString("numero"));
				contaEncontrada.setTipo(rs.getString("tipo"));
				contaEncontrada.setTitular(rs.getString("titular"));
				contaEncontrada.setSaldo(rs.getDouble("saldo"));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (stmt != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contaEncontrada;

	}

	@Override
	public boolean existe(Conta conta) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		boolean result;

		String sql = "select id from conta where numero = ?";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, conta.getNumero());

			rs = stmt.executeQuery();
			result = rs.next();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (stmt != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
