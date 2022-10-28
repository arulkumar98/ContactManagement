import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class EditContact {
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        try {
            String url = "jdbc:mysql://localhost:3306/contact", username = "root", password = "245521";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println(" Enter the column that you want update \n Available column are Name, Number, Email, Job, Address ");
            String column = scanner.next();
            System.out.println("Entre the old value that want to replace in the " + column);
            String oldValue = scanner.next();
            System.out.println("Enter the value that you want to update in " + column);
            String newValue = scanner.next();
            String sql = "UPDATE info SET " + column + " =" + "'" + newValue + "'" + " WHERE " + column + "='" + oldValue + "';";
            int result = statement.executeUpdate(sql);
            System.out.println("Successfully old " + oldValue + " was updated " + newValue + " " + result);
        } catch (SQLException e) {
            System.out.println("error in edit function");
        }
    }
}
