package zacseed.sineth.v2;

import zacseed.sineth.v2.outputs.PrintOptionList;
import zacseed.sineth.v2.outputs.PrintWelcomeText;
import zacseed.sineth.v2.taskHandlers.StudentManager;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static int optionInput;

    public static void main(String[] args) throws SQLException {
        Scanner getInput = new Scanner(System.in);

        PrintWelcomeText.print();
        StudentManager studentManager = new StudentManager();

        while (true) {
            PrintOptionList.print();
            optionInput = getInput.nextInt();
            studentManager.perform(optionInput);
        }
    }
}
