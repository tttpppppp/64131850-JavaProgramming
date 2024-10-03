package cm.respoitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm.config.MysqlConnection;
import cm.model.User;

public class UserRespository {

    public List<User> getEmailAndPassword(String email, String password) {
        List<User> listUser = new ArrayList<User>();
        Connection connection = MysqlConnection.getConnection();
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                
                listUser.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return listUser;
    }
}
