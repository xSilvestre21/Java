package br.unisal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Prover uma ponte de conexão com SGBD - Sistema Gerenciador de B. Dados
 * @author Gustavo Silvestre
 * @data 07/05/2024
 */
public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aula",
					"root",
					"Gust@avo2321"
					);
		}catch(ClassNotFoundException erro) {
			throw new SQLException("Houve um erro, não foi possível a conexão "
					+ erro);
		}
	}
}