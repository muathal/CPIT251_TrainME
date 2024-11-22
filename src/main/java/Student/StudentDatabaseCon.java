package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// this class for conncting between student and the database
//all method will be using sql prepaired statment
public class StudentDatabaseCon{
    String url;
    String password;
    String username;
    Connection connection;

    public StudentDatabaseCon() throws SQLException {
         url = "jdbc:mysql://127.0.0.1:3306/TrainMe";
         username = "root";
         password = "1$R2e3W4q";
 		this.connection = DriverManager.getConnection(url, username, password);
 		}
	//data retrieval 
	public void login(int nid,String password) throws SQLException 
	{
		String cheackAccount = "Select * from student where nid = ?";
		try(PreparedStatement cheackAccountPrep = connection.prepareStatement(cheackAccount)){
			cheackAccountPrep.setInt(0, 0);
			ResultSet resultLogin = cheackAccountPrep.executeQuery();
			if(resultLogin.next()) {
				System.out.println("User Found");
			}
			else {
				System.out.println("User not found");
			}
			
		}
	}
	public void getFullName(int nid){
		//Make sure that it is the user profile
		String fullNameStatment = "select fname, mname, gname,lname from student where nid = ?";
	}
	public void getEmail(int nid) {
		//Make sure that it is the user profile
		String emailStatment = "select fname, mname, gname,lname from student where nid = ?";

	}
	public void getMajor(int nid) {
		//Make sure that it is the user profile
		String majorStatment = "select fname, mname, gname,lname from student where nid = ?";

	}
	public void getGba(int nid) {
		//Make sure that it is the user profile
		String gbaStatment = "select fname, mname, gname,lname from student where nid = ?";


	}
	//get report about all student in the same major that has no internship
	public void getAllStudentwoIntern(int nid) {

	}
	public void getCV(int nid) {
		//Make sure that it is the user profile
		String cvStatment = "select fname, mname, gname,lname from student where nid = ?";

	}
	
	////data manipulation/////
	public void editFirstName (int nid){
		//Make sure that it is the user profile
		String firstNameStatment = "select * from student where nid = ?";

	}
	public void editMiddleName(int nid) {
		//Make sure that it is the user profile
		String middleNameStatment = "select * from student where nid = ?";

	}
	public void editGrandpaName(int nid) {
		//Make sure that it is the user profile
		String grandpaNameStatment = "select * from student where nid = ?";

	}
	public void editLastName(int nid) {
		//Make sure that it is the user profile
		String lastStatment = "select * from student where nid = ?";


	}
	public void editPassword(int nid) {
		//Make sure that it is the user profile
		String passwordStatment = "select * from student where nid = ?";

	}
	/////data creation //////
	public void signup() throws SQLException {
		//Make sure that the user didn't exist 
		String fullNameStatment = "select * from student where nid = ?";
		String cheackAccount = "Select * from student where nid = ?";
		try(PreparedStatement cheackAccountPrep = connection.prepareStatement(cheackAccount)){
			cheackAccountPrep.setInt(0, 0);
			ResultSet resultLogin = cheackAccountPrep.executeQuery();
			if(!resultLogin.next()) {
				System.out.println("User Found");
			}
			else {
				
			}
			
		}
		
	}
	public void addCV() {
		//Make sure that it is the user profile
		String cvStatment = "select * from student where nid = ?";	
	}
}
