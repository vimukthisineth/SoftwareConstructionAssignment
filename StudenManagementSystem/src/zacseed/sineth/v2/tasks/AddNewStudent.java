package zacseed.sineth.v2.tasks;

import zacseed.sineth.v2.taskHandlers.DatabaseManager;

import java.sql.*;
import java.util.Scanner;

public class AddNewStudent {

    private String newStudentName;
    private int newStudentAge;
    private String newStudentAddress;
    private String newStudentQuery;

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    private Scanner getInput = new Scanner(System.in);
    private DatabaseManager databaseManager = new DatabaseManager();

    public void perform() {
        System.out.print("Enter new student name : ");
        newStudentName = getInput.next();
        System.out.print("Enter new student age : ");
        newStudentAge = getInput.nextInt();
        System.out.print("Enter new student address : ");
        newStudentAddress = getInput.next();

        connection = databaseManager.getConnection();
        newStudentQuery = "INSERT INTO studentinfo(StudentName, StudentAge, StudentAddress) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(newStudentQuery);
            preparedStatement.setString(1, newStudentName);
            preparedStatement.setInt(2, newStudentAge);
            preparedStatement.setString(3, newStudentAddress);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("New student added successfully");
    }
}
