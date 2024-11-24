package org.example;

import java.sql.SQLException;

import Student.Student;

public class Main {
    public static void main(String[] args) throws SQLException {
    	Student student = new Student();
    	student.setFirstName("Muath");
    	student.setMiddleName("Abullah");
    	student.setLastName("Alhurtumi");
    	student.setEmail("muath@gmail.com");
    	student.setMajor("IT");
    	student.setGba(4.44);
    	student.setPassword("1234");
    	student.signin();

    	
    }
}