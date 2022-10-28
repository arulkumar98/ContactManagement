import java.sql.*;
import java.util.Scanner;
public class Search {
    public void scan() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the name Contact name to search");
            String input = scanner.next();
            String url = "jdbc:mysql://localhost:3306/contact";
            String userName = "root";
            String password = "245521";
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            String query = "select * from info where name like " + "'" + input + "%" + "'"; // select * from info where Name like 'Ar%';
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString(1) + " || Number: " + resultSet.getString(2) +
                        " || Email: " + resultSet.getString(3) + " || Job: " + resultSet.getString(4) +
                        " || Address: " + resultSet.getString(5));
            }

        } catch (SQLException e) {
            System.out.println("error in Search function");
        }
    }
}