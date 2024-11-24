package org.example;

import java.sql.SQLException;
import java.util.Scanner;

import Student.Student;

public class Main {
	public static void main(String[] args) throws SQLException {
		try (Scanner input = new Scanner(System.in);) {
			String command = "";
			do {
				System.out.println("Enter your chose:\n" + 
			"1) login\n"
			+ "2) signup\n"
			+ "6) exit");
				command = input.nextLine();
				if(command.equalsIgnoreCase("login")|| command.equalsIgnoreCase("1")) {
					System.out.print("Enter your ID: ");
					int id = input.nextInt();
					System.out.println("\nEnter your password: ");
					String password = input.next();
					Student student = new Student();
					student.login(id, password);
				}
				else if(command.equalsIgnoreCase("signup")|| command.equalsIgnoreCase("2")){
					Student student = new Student();
					System.out.print("Enter your ID: ");
					student.setNid(input.nextInt());
					System.out.print("Enter your First Name: ");
					student.setFirstName(input.next());
					System.out.print("Enter your Middle Name: ");
					student.setMiddleName(input.next());
					System.out.print("Enter your Last Name: ");
					student.setLastName(input.next());
					System.out.print("Enter your Email: ");
					student.setEmail(input.next());
					System.out.print("Enter your Major: ");
					student.setMajor(input.next());
					System.out.print("Enter your password: ");
					student.setPassword(input.next());
					System.out.print("Enter your GBA: ");
					student.setGba(input.nextDouble());
					student.signup();
				}
			} while (!(command.equals("exit") || command.equals("6")) );
		}

	}
}