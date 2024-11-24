package Student;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

// this class for conncting between student and the database
//all method will be using sql prepaired statment
public class StudentDatabaseCon {
	private String url;
	private String password;
	private String username;
	private Connection connection;

	protected StudentDatabaseCon() throws SQLException {
		url = "jdbc:mysql://127.0.0.1:3306/TrainMe";
		username = "root";
		password = "1$R2e3W4q";
		this.connection = DriverManager.getConnection(url, username, password);
	}

	// data retrieval
	protected ResultSet login(int nid, String spassword) throws SQLException {
		String cheackAccount = "Select * from student where nid = ? and stu_password = ?";
		try (PreparedStatement cheackAccountPrep = connection.prepareStatement(cheackAccount)) {
			cheackAccountPrep.setInt(1, nid);
			cheackAccountPrep.setString(2, spassword);
			ResultSet resultLogin = cheackAccountPrep.executeQuery();
			if (resultLogin.next()) {
				System.out.println("User Found");
				return resultLogin;
			} else {
				return null;
			}

		}
	}

	protected void getFullName(int nid) throws SQLException {
		// Make sure that it is the user profile
		String fullNameStatment = "select fname, mname, gname,lname from student where nid = ?";
		StringBuilder fullNameSb = new StringBuilder("");
		try (PreparedStatement getFullName = connection.prepareStatement(fullNameStatment)) {
			getFullName.setInt(1, nid);
			ResultSet resultFullName = getFullName.executeQuery();
			if (resultFullName.next()) {
				fullNameSb.append(resultFullName.getString("fname") + " " + resultFullName.getString("mname")  
				+ " " + resultFullName.getString("lname"));
			}
		}
		String fullName = fullNameSb.toString();
	}

	protected void getEmail(int nid) throws SQLException {
		// Make sure that it is the user profile
		String emailStatment = "select email from student where nid = ?";
		String email;
		try (PreparedStatement getEmail = connection.prepareStatement(emailStatment)) {
			getEmail.setInt(1, nid);
			ResultSet emailResult = getEmail.executeQuery();
			if (emailResult.next()) {
				email = emailResult.getString("email");
			} else {
				email = "";
			}
		}

	}

	protected void getMajor(int nid) throws SQLException {
		// Make sure that it is the user profile
		String majorStatment = "select major from student where nid = ?";
		String major;
		try (PreparedStatement getMajor = connection.prepareStatement(majorStatment)) {
			getMajor.setInt(1, nid);
			ResultSet majorResult = getMajor.executeQuery();
			if (majorResult.next()) {
				major = majorResult.getString("major");
			} else {
				major = "";
			}

		}
	}

	protected void getGba(int nid) throws SQLException {
		// Make sure that it is the user profile
		String gbaStatment = "select gba from student where nid = ?";
		double gba;
		try (PreparedStatement getGba = connection.prepareStatement(gbaStatment)) {
			getGba.setInt(1, nid);
			ResultSet gbaResult = getGba.executeQuery();
			if (gbaResult.next()) {
				gba = gbaResult.getDouble("gba");
			} else {
				gba = 0.0;

			}

		}
	}

	// get report about all student in the same major that has no internship
	protected void getAllStudentWOIntern(int nid) {

	}

	protected void getCV(int nid) throws SQLException {
		// Make sure that it is the user profile
		String cvStatment = "select cv from student where nid = ?";
		Blob cv;
		try (PreparedStatement getCV = connection.prepareStatement(cvStatment)) {
			getCV.setInt(1, nid);
			ResultSet cvResult = getCV.executeQuery();
			if (cvResult.next()) {
				cv = cvResult.getBlob("cv");
			} else {
				cv = null;
			}

		}
	}

	//// data manipulation/////
	protected void editFirstName(int nid, String fname) throws SQLException {
		// Make sure that it is the user profile
		String firstNameStatment = "update student set fname = ? where nid = ?";
		try(PreparedStatement updateFname = connection.prepareStatement(firstNameStatment)){
			updateFname.setString(1, fname);
			updateFname.setInt(2, nid);
			updateFname.executeUpdate();		
			}
	}
	protected void editMiddleName(int nid, String mname) throws SQLException {
		// Make sure that it is the user profile
		String middleNameStatment = "update student set mname = ? where nid = ?";
		try(PreparedStatement updateGname = connection.prepareStatement(middleNameStatment)){
			updateGname.setString(1, mname);
			updateGname.setInt(2, nid);
			updateGname.executeUpdate();		
			}
	}
	protected void editLastName(int nid,String lname) throws SQLException {
		// Make sure that it is the user profile
		String lastStatment = "update student set lname = ? where nid = ?";
		try(PreparedStatement updateFname = connection.prepareStatement(lastStatment)){
			updateFname.setString(1, lname);
			updateFname.setInt(2, nid);
			updateFname.executeUpdate();		
			}
	}

	protected void editPassword(int nid, String stuPassword) throws SQLException {
		// Make sure that it is the user profile
		String passwordStatment = "update student set stu_password = ? where nid = ?";
		try(PreparedStatement updatePassword = connection.prepareStatement(passwordStatment)){
			updatePassword.setString(1, stuPassword);
			updatePassword.setInt(2, nid);
			updatePassword.executeUpdate();		
			}
	}

	///// data creation //////
	protected void signup(Student student) throws SQLException {
		// Make sure that the user didn't exist
		String cheackAccount = "Select * from student where nid = ?";
		try (PreparedStatement cheackAccountPrep = connection.prepareStatement(cheackAccount)) {
			cheackAccountPrep.setInt(1,student.getNid());
			ResultSet resultLogin = cheackAccountPrep.executeQuery();
			if (!resultLogin.next()) {
				String insertIntoTableStat = "INSERT INTO student "
						+ "(nid,fname,mname,lname,email,major,gba,stu_password) values"
						+ "(?,?,?,?,?,?,?,?)";
				try(PreparedStatement insertIntoTable = connection.prepareStatement(insertIntoTableStat)){
					insertIntoTable.setInt(1,student.getNid());
					insertIntoTable.setString(2,student.getFirstName());
					insertIntoTable.setString(3,student.getMiddleName());
					insertIntoTable.setString(4,student.getLastName());
					insertIntoTable.setString(5,student.getEmail());
					insertIntoTable.setString(6,student.getMajor());
					insertIntoTable.setDouble(7, student.getGba());
					insertIntoTable.setString(8, student.getPassword());
					insertIntoTable.executeUpdate();

				}
			} else {
				System.out.println("User already exsit");
			}

		}

	}

	protected void addCV(int nid, byte [] cv) throws SQLException {
		// Make sure that it is the user profile
		String cvStatment = "update student set stu_password = ? where nid = ?";
		try(PreparedStatement uploadCV = connection.prepareStatement(cvStatment)){
			SerialBlob cvBlob = new SerialBlob(cv);
			uploadCV.setBlob(1, cvBlob);
			uploadCV.setInt(2, nid);
			uploadCV.executeUpdate();		
			}
		
	}
	protected void applyForInternship(int nid,int internshipid) throws SQLException {
		String applyStatement = "insert into student_internship (nid,internId,status) values(?, ? , ?)";
		try(PreparedStatement apply = connection.prepareStatement(applyStatement)){
			apply.setInt(1, nid);
			apply.setInt(2, internshipid);
			apply.setString(3, "No info");
			apply.executeUpdate();
		}
		
	}
}
