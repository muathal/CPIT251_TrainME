package Internship;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InternshipDatabaseCon {
	private String url;
	private String password;
	private String username;
	private Connection connection;

	protected InternshipDatabaseCon() throws SQLException {
		url = "jdbc:mysql://127.0.0.1:3306/TrainMe";
		username = "root";
		password = "1$R2e3W4q";
		this.connection = DriverManager.getConnection(url, username, password);
	}
	//Retrieve data
	protected void retiveinternship () throws SQLException {
		String getInternshipStatement = "select * from internship";
		try(PreparedStatement getInternship= connection.prepareStatement(getInternshipStatement)){
			ResultSet getInternshipResult = getInternship.executeQuery();
		}
	}
	
}
