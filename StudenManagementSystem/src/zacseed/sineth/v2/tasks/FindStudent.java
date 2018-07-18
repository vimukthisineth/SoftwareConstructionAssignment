package zacseed.sineth.v2.tasks;

import zacseed.sineth.v2.taskHandlers.DatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FindStudent {
    private int findStudentId;
    private String findStudentQuery;

    private int studentId;
    private String studentName;
    private int studentAge;
    private String studentAddress;

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private DatabaseManager databaseManager = new DatabaseManager();

    public void perform() {
        Scanner getInput = new Scanner(System.in);
        connection = databaseManager.getConnection();

        System.out.print("Please enter the id of the student : ");
        findStudentId = getInput.nextInt();
        findStudentQuery = "SELECT * FROM studentinfo WHERE StudentId = "+findStudentId;
        try {
            resultSet = statement.executeQuery(findStudentQuery);
            if (resultSet.next()) {
                studentId = resultSet.getInt("StudentId");
                studentName = resultSet.getString("StudentName");
                studentAge = resultSet.getInt("StudentAge");
                studentAddress = resultSet.getString("StudentAddress");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Student Id : "+studentId);
        System.out.println("Student name : "+studentName);
        System.out.println("Student age : "+studentAge);
        System.out.println("Student address : "+studentAddress);

    }
}
