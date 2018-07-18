package zacseed.sineth.v2.taskHandlers;

import zacseed.sineth.v2.tasks.AddNewStudent;
import zacseed.sineth.v2.tasks.FindStudent;
import zacseed.sineth.v2.tasks.ViewAllStudents;

import static java.lang.System.exit;

public class StudentManager {
    private AddNewStudent addNewStudent = new AddNewStudent();
    private FindStudent findStudent = new FindStudent();
    private ViewAllStudents viewAllStudents = new ViewAllStudents();

    public void perform(int optionInput) {
        switch (optionInput) {
            case 1 :
                addNewStudent.perform();
                break;
            case 2 :
                findStudent.perform();
                break;
            case 3 :
                viewAllStudents.perform();
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
