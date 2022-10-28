import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DeleteContact {
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        try {
            String url = "jdbc:mysql://localhost:3306/contact", username = "root", password = "245521";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println("Enter the name from the contact that want to delete ");
            String name = scanner.next();
            String sql = "DELETE FROM info " + "WHERE Name = '" + name + "'";
            System.out.println(sql);
            int result = statement.executeUpdate(sql);
            System.out.println(name + " was deleted " + result);
        } catch (SQLException e) {
            System.out.println("error in delete function");
        }
    }
}