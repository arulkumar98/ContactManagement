import java.sql.*;
import java.util.ArrayList;
public class ViewContact {
    public void view() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/contact";
            String userName = "root";
            String password = "245521";
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            String query = "select * from info;";
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<Pojo> pojoArrayList = new ArrayList<>();
            while (resultSet.next()) {
                Pojo pojo = new Pojo();
                pojo.setName(resultSet.getString(1));
                pojo.setNumber(resultSet.getString(2));
                pojo.setEmail(resultSet.getString(3));
                pojo.setJob(resultSet.getString(4));
                pojo.setAddress(resultSet.getString(5));
                pojoArrayList.add(pojo);
            }
            statement.close();
            connection.close();
            for (Pojo obj : pojoArrayList) {
                System.out.println("__________________________________________________________________________________________________________________________");
                System.out.println(" Name - " + obj.getName() + "|| Number " + obj.getNumber() +
                        "|| E-mail " + obj.getEmail() + "|| Job " + obj.getJob() + "|| Address " + obj.getAddress());
            }
            System.out.println("************************************************************************************************************************************");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}