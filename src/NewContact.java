import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class NewContact {
    public void newContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name ");
        String name = scanner.next();
        System.out.println("Enter the Mobile Number");
        String number = scanner.next();
        String num = "^\\d{10}$";
        while (!number.matches(num)) {
            System.out.println("Please enter the valid Mobile Number");
            number = scanner.next();
        }
        System.out.println("email address");
        String email = scanner.next();
        String regex = "^(.+)@(.+)$";
        while (!email.matches(regex)) {
            System.out.println("Please enter the valid e-mail address");
            email = scanner.next();
        }
        System.out.println("Enter the person's Job");
        String job = scanner.next();
        System.out.println("Enter the address");
        String address = scanner.next();

        String url = "jdbc:mysql://localhost:3306/contact";
        String username = "root";
        String password = "245521";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "insert into info values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, number);
            statement.setString(3, email);
            statement.setString(4, job);
            statement.setString(5, address);
            int count = statement.executeUpdate();
            System.out.println("Contact added successfully" + count);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
