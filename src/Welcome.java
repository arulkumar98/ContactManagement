import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Welcome {
    public void start() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Contact Management");
            System.out.println(" Press 1 For to add new Contact \n " +
                    "Press 2 For to delete Contact \n " +
                    "Press 3 For to edit Contact \n " +
                    "Press 4 For view all the Contact \n " +
                    "Press 5 For Search from the Contact");
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    NewContact newContact = new NewContact();
                    newContact.newContact();
                }
                case 2 -> {
                    DeleteContact deleteContact = new DeleteContact();
                    deleteContact.delete();
                }
                case 3 -> {
                    EditContact editContact = new EditContact();
                    editContact.edit();
                }
                case 4 -> {
                    ViewContact viewContact = new ViewContact();
                    viewContact.view();
                }
                case 5 -> {
                    Search search = new Search();
                    search.scan();
                }
                default -> {
                    System.out.println("Please enter a valid input");
                    start();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
