package zacseed.sineth.v2.tasks;

import zacseed.sineth.v2.taskHandlers.DatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewAllStudents {

    private String allStudentQuery;

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private int studentId;
    private String studentName;
    private int studentAge;
    private String studentAddress;

    private DatabaseManager databaseManager = new DatabaseManager();

    public void perform() {
        connection = databaseManager.getConnection();
        allStudentQuery = "SELECT * FROM studentinfo";
        try {
            resultSet = statement.executeQuery(allStudentQuery);
            while (resultSet.next()) {
                studentId = resultSet.getInt("StudentId");
                studentName = resultSet.getString("StudentName");
                studentAge = resultSet.getInt("StudentAge");
                studentAddress = resultSet.getString("StudentAddress");

                System.out.println("Student id : "+studentId);
                System.out.println("Student name : "+studentName);
                System.out.println("Student age : "+studentAge);
                System.out.println("Student address : "+studentAddress+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
