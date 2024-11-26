package org.example;

import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Student.*;

public class StudentApp {
      private Student student;// To to signup, login and retrieve data;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentApp().createSignupPage());
    }

    // Method to create Signup Page
    public void createSignupPage() {
        JFrame signupFrame = new JFrame("Signup Page");
        signupFrame.setSize(600, 800);
        signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 87, 51));

        JLabel background = createBackgroundLabel();
        panel.add(background);

        JLabel titleLabel = new JLabel("Signup Page");
        titleLabel.setFont(new Font("Bold", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(200, 50, 200, 30);
        background.add(titleLabel);

        JLabel idLabel = new JLabel("ID (6 digits):");
        idLabel.setBounds(100, 100, 150, 25);
        idLabel.setForeground(Color.WHITE);
        background.add(idLabel);
        JTextField idField = new JTextField();
        idField.setBounds(250, 100, 200, 25);
        background.add(idField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 150, 150, 25);
        emailLabel.setForeground(Color.WHITE);
        background.add(emailLabel);
        JTextField emailField = new JTextField();
        emailField.setBounds(250, 150, 200, 25);
        background.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 200, 150, 25);
        passwordLabel.setForeground(Color.WHITE);
        background.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 200, 200, 25);
        background.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(100, 250, 150, 25);
        confirmPasswordLabel.setForeground(Color.WHITE);
        background.add(confirmPasswordLabel);
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(250, 250, 200, 25);
        background.add(confirmPasswordField);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(100, 300, 150, 25);
        nameLabel.setForeground(Color.WHITE);
        background.add(nameLabel);
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(250, 300, 100, 25);
        background.add(firstNameField);
        JTextField fathersNameField = new JTextField();
        fathersNameField.setBounds(360, 300, 100, 25);
        background.add(fathersNameField);
        JTextField familyNameField = new JTextField();
        familyNameField.setBounds(470, 300, 100, 25);
        background.add(familyNameField);

        JLabel majorLabel = new JLabel("Major:");
        majorLabel.setBounds(100, 350, 150, 25);
        majorLabel.setForeground(Color.WHITE);
        background.add(majorLabel);
        JTextField majorField = new JTextField();
        majorField.setBounds(250, 350, 200, 25);
        background.add(majorField);

        JLabel gpaLabel = new JLabel("GPA (0 - 5):");
        gpaLabel.setBounds(100, 400, 150, 25);
        gpaLabel.setForeground(Color.WHITE);
        background.add(gpaLabel);
        JTextField gpaField = new JTextField();
        gpaField.setBounds(250, 400, 200, 25);
        background.add(gpaField);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(250, 500, 100, 30);
        background.add(signupButton);
        // Store the ID and Password
        try {
			student = new Student();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        signupButton.addActionListener(e -> {
            // Validate ID
            if (idField.getText().length() != 6 || !idField.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(signupFrame, "ID must be 6 numeric digits.");
                return;
            }
            try {
				if (student.check(Integer.parseInt(idField.getText()))) {
				    JOptionPane.showMessageDialog(signupFrame, "There is already user with this ID");
				    return;
				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            // Validate Email
            if (!emailField.getText().contains("@")) {
                JOptionPane.showMessageDialog(signupFrame, "Email must contain '@'.");
                return;
            }
            if (majorField.getText().isEmpty() || firstNameField.getText().isEmpty() || fathersNameField.getText().isEmpty() || familyNameField.getText().isEmpty() || nameLabel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(signupFrame, "You need to fill all fields");
                return;
            }
            // Validate GPA
            try {
                double gpa = Double.parseDouble(gpaField.getText());
                if (gpa < 0 || gpa > 5) {
                    JOptionPane.showMessageDialog(signupFrame, "GPA must be between 0 and 5.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(signupFrame, "Invalid GPA value.");
                return;
            }
            // Validate Password Match
            if (!String.valueOf(passwordField.getPassword()).equals(String.valueOf(confirmPasswordField.getPassword()))) {
                JOptionPane.showMessageDialog(signupFrame, "Passwords do not match.");
                return;
            }
            student.setNid(Integer.parseInt(idField.getText()));
            student.setPassword(String.valueOf(passwordField.getPassword()));
            student.setFirstName(firstNameField.getText());
            student.setMiddleName(fathersNameField.getText());
            student.setLastName(familyNameField.getText());
            student.setEmail(emailField.getText());
            student.setMajor(majorField.getText());
            student.setGba(Double.parseDouble(gpaField.getText()));
            try {
				student.signup();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            JOptionPane.showMessageDialog(signupFrame, "Signup Successful!");
            signupFrame.dispose();
            try {
				createLoginPage(firstNameField.getText(), majorField.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(250, 550, 100, 30);
        background.add(loginButton);
        loginButton.addActionListener(e -> {
            signupFrame.dispose();
            try {
				createLoginPage("", "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        signupFrame.add(panel);
        signupFrame.setVisible(true);
    }

    // Method to create Login Page
    public void createLoginPage(String userName, String userMajor) throws SQLException {
        JFrame loginFrame = new JFrame("Login Page");
        loginFrame.setSize(600, 800);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel background = createBackgroundLabel();
        panel.add(background);

        JLabel titleLabel = new JLabel("Login Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(200, 50, 200, 30);
        background.add(titleLabel);

        JLabel idOrEmailLabel = new JLabel("ID");
        idOrEmailLabel.setBounds(100, 150, 150, 25);
        idOrEmailLabel.setForeground(Color.WHITE);
        background.add(idOrEmailLabel);
        JTextField idOrEmailField = new JTextField();
        idOrEmailField.setBounds(250, 150, 200, 25);
        background.add(idOrEmailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 200, 150, 25);
        passwordLabel.setForeground(Color.WHITE);
        background.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 200, 200, 25);
        background.add(passwordField);

        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(250, 300, 100, 30);
        background.add(loginButton);
        student = new Student();
        loginButton.addActionListener(e -> {
            try {
				if (!student.login(Integer.parseInt(idOrEmailField.getText()), String.valueOf(passwordField.getPassword()))) {
				    JOptionPane.showMessageDialog(loginFrame, "Invalid ID or Password.");
				} else {
				    JOptionPane.showMessageDialog(loginFrame, "Login Successful!");
				    loginFrame.dispose();
				    createHomePage(userName,userMajor);
				}
			} catch (NumberFormatException | HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(250, 350, 100, 30);
        background.add(signupButton);
        signupButton.addActionListener(e -> {
        loginFrame.dispose(); // Close the login frame
        createSignupPage(); // Navigate back to the signup page
        });
        loginFrame.add(panel);
        loginFrame.setVisible(true);
    }

    // Method to create Home Page
public void createHomePage(String userName, String userMajor) {
    JFrame homeFrame = new JFrame("Home Page");
    homeFrame.setSize(600, 800);
    homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(null);

    JLabel background = createBackgroundLabel();
    panel.add(background);

    JLabel titleLabel = new JLabel("Welcome, " + userName + " (" + userMajor + ")");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setBounds(100, 50, 400, 30);
    background.add(titleLabel);

    JLabel trainingsLabel = new JLabel("Available Trainings:");
    trainingsLabel.setFont(new Font("Bold", Font.BOLD, 18));
    trainingsLabel.setBounds(100, 100, 200, 30);
    trainingsLabel.setForeground(Color.WHITE);
    background.add(trainingsLabel);

    String[][] trainingData = {
        {"Training 1", "Google", "Information Technology", "Internship"},
        {"Training 2", "Microsoft", "Computer Science", "Co-op Program"},
        {"Training 3", "Amazon Web Services", "Software Engineering", "Summer Training"},
        {"Training 4", "IBM", "Artificial Intelligence", "Project-Based Training"},
        {"Training 5", "Oracle", "Database Management", "Part-Time Training"}
    };

    int y = 150;
    for (String[] training : trainingData) {
        JLabel trainingLabel = new JLabel(
                training[0] + " - " + training[1] + " (" + training[2] + ", " + training[3] + ")");
        trainingLabel.setBounds(45, y, 400, 25);
        trainingLabel.setForeground(Color.WHITE);
        background.add(trainingLabel);

        JButton joinButton = new JButton("Details");
        joinButton.setBounds(450, y, 120, 25);
        String[] details = training; // Capture training details for the listener
        joinButton.addActionListener(e -> {
            homeFrame.dispose(); // Close the home page
            createDetailsPage(details, userName, userMajor); // Open the details page
        });
        background.add(joinButton);
        y += 50;
    }
    // Add Log Out button
    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBounds(250, 550, 100, 30);
    background.add(logoutButton);

    // Log Out button action listener
    logoutButton.addActionListener(e -> {
        homeFrame.dispose(); // Close the Home Page
        try {
			createLoginPage(userName, userMajor);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Navigate back to the Login Page
    });
    homeFrame.add(panel);
    homeFrame.setVisible(true);
}

// Method to create Details Page
public void createDetailsPage(String[] details, String userName, String userMajor) {
    JFrame detailsFrame = new JFrame("Company Details");
    detailsFrame.setSize(600, 800);
    detailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(null);

    JLabel background = createBackgroundLabel();
    panel.add(background);

    JLabel titleLabel = new JLabel("Details of " + details[1]);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setBounds(100, 50, 400, 30);
    background.add(titleLabel);

    JLabel descriptionLabel = new JLabel("<html>" +
            "<b>Training:</b> " + details[0] + "<br>" +
            "<b>Company:</b> " + details[1] + "<br>" +
            "<b>Field:</b> " + details[2] + "<br>" +
            "<b>Type:</b> " + details[3] + "<br>" +
            "</html>");
    descriptionLabel.setBounds(100, 100, 400, 200);
    descriptionLabel.setForeground(Color.WHITE);
    background.add(descriptionLabel);

    JButton backButton = new JButton("Back");
    backButton.setBounds(150, 400, 100, 30);
    backButton.addActionListener(e -> {
        detailsFrame.dispose();
        createHomePage(userName, userMajor); // Reopen the home page
    });
    background.add(backButton);

    JButton joinButton = new JButton("Join");
    joinButton.setBounds(300, 400, 100, 30);
    joinButton.addActionListener(e -> {
        JOptionPane.showMessageDialog(detailsFrame,
                "Your request has been submitted. We will contact you via email.");
        detailsFrame.dispose();
        
        createHomePage(userName, userMajor); // Reopen the home page
    });
    background.add(joinButton);

    detailsFrame.add(panel);
    detailsFrame.setVisible(true);
}


    // Helper method to create a background label with a book image
    private JLabel createBackgroundLabel() {
        ImageIcon backgroundImage = new ImageIcon("books_background.jpg"); // Replace with the path to your image
        JLabel backgroundLabel = new JLabel(new ImageIcon(
                backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(0, 0, 600, 800);
        backgroundLabel.setLayout(null);
        return backgroundLabel;
    }
}