package zacseed.sineth.v1;

import java.sql.*;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {

    private static int optionInput;
    private static String newStudentName;
    private static int newStudentAge;
    private static String newStudentAddress;
    private static int findStudentId;
    private static String newStudentQuery;
    private static String findStudentQuery;
    private static String allStudentQuery;

    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    private static int studentId;
    private static String studentName;
    private static int studentAge;
    private static String studentAddress;


    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmdb","root","");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("|                                          |");
        System.out.println("| Welcome to the Student Management System |");
        System.out.println("|__________________________________________|");

        while (true) {
            System.out.println("\nPlease select an option");
            System.out.println("1 : Add new student");
            System.out.println("2 : View a student information");
            System.out.println("3 : View all student information");
            System.out.println("4 : Exit");

            Scanner getInput = new Scanner(System.in);
            optionInput = getInput.nextInt();

            switch (optionInput) {
                case 1 :
                    System.out.print("Enter new student name : ");
                    newStudentName = getInput.next();
                    System.out.print("Enter new student age : ");
                    newStudentAge = getInput.nextInt();
                    System.out.print("Enter new student address : ");
                    newStudentAddress = getInput.next();

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
                    break;
                case 2 :
                    System.out.print("Please enter the id of the student : ");
                    findStudentId = getInput.nextInt();
                    findStudentQuery = "SELECT * FROM studentinfo WHERE StudentId = "+findStudentId;
                    try {
                        resultSet = statement.executeQuery(findStudentQuery);
                        if (resultSet.next()) {
                            studentName = resultSet.getString("StudentName");
                            studentAge = resultSet.getInt("StudentAge");
                            studentAddress = resultSet.getString("StudentAddress");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Student name : "+studentName);
                    System.out.println("Student age : "+studentAge);
                    System.out.println("Student address : "+studentAddress);

                    break;
                case 3 :
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
                    break;
                case 4 :
                    System.out.println("Thank you ...");
                    exit(0);
                    break;
                default:
                    System.out.println("Wrong input. Please try again.");
                    break;
            }
        }
    }
}
