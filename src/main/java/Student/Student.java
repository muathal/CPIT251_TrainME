package Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    int nid;
    String firstName;
    String middleName;
    String lastName;
    String email;
    String password;
    String major;
    double gba;
    byte [] CV;
    StudentDatabaseCon databaseCon;
    public Student() throws SQLException {
        databaseCon = new StudentDatabaseCon();
    }
    public Student(int nid) {
    	this.nid = nid;
    }
    public void login(int nid, String password) throws SQLException {
    	Student resultLogin= databaseCon.login(nid, password);
    	if(resultLogin != null) {
    	this.firstName = resultLogin.getFirstName();
    	this.middleName = resultLogin.getMiddleName();
    	this.lastName = resultLogin.getLastName();
    	this.email = resultLogin.getEmail();
    	this.password = resultLogin.getPassword();
    	this.major = resultLogin.getMajor();
    	this.gba = resultLogin.getGba();
    	System.out.println("Welcome to TrainMe "+ this.firstName+" "+this.lastName);
    	}
    	else {
			System.out.println("ethir the password or the user is wrong");

    	}
    }
    public void signup() throws SQLException {
    	databaseCon.signup(this);
    }
    public int getNid() {
        return nid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setNid(int nid) {
		this.nid = nid;
	}
	public void setMajor(String major) {
        this.major = major;
    }

    public double getGba() {
        return gba;
    }

    public void setGba(double gba) {
        this.gba = gba;
    }

    public byte[] getCV() {
        return CV;
    }

    public void setCV(byte[] CV) {
        this.CV = CV;
    }

}
