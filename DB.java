package week01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

public class DB {

	private static final String JDBC_DRIVER = "org.sqlite.JDBC";
	private static final String DB_URL = "jdbc:sqlite:WORDS_AND_ANSWERS.db";
	private ArrayList<String> words = new ArrayList<String>();
	private ArrayList<String> answers = new ArrayList<String>();
	private Connection conn;
	private Statement stmt;

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(ArrayList<String> words) {
		this.words = words;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}

	public static String getDbUrl() {
		return DB_URL;
	}

	public ArrayList<String> getData() {
		ArrayList<String> data = new ArrayList<>();

		conn = null;
		stmt = null;

		try {

			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL);

			stmt = conn.createStatement();

			String sql = "SELECT * FROM words_and_answers";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String word = rs.getString("word");
				String answer = rs.getString("answer");
				data.add(word + ": " + answer);
			}

			rs.close();
			stmt.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return data;
	}

	public void insertData() {
		try {

			Statement statement = conn.createStatement();
			for (int i = 0; i < this.words.size(); i++) {
				String word = this.words.get(i);
				String answer = this.answers.get(i);
				String query = "INSERT INTO WORDS_AND_ANSWERS (word, answer) VALUES ('" + word + "', '" + answer + "')";
				statement.executeUpdate(query);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readData(String filename) {
		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] parts = line.split("-");
				String word = parts[0].trim();
				String answer = parts[1].trim();
				this.words.add(word);
				this.answers.add(answer);
			}

			bufferedReader.close();
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
