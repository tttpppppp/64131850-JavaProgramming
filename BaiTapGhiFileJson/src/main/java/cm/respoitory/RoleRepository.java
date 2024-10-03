package cm.respoitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm.config.MysqlConnection;
import cm.model.Role;
import cm.model.User;

public class RoleRepository {

	public List<Role> getAllRole() {
        List<Role> listRole = new ArrayList<Role>();
        Connection connection = MysqlConnection.getConnection();
        String query = "SELECT * FROM role";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setRolename(resultSet.getString("rolename"));
                
                listRole.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return listRole;
    }
	public int deleteRoleById(int id) {
	        Connection connection = MysqlConnection.getConnection();
	        String query = "DELETE FROM role WHERE id = ?";
	        int isDelete = 0;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, id);
	            isDelete = preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return isDelete;
	}
	public int addRole(String rolename) {
	    Connection connection = MysqlConnection.getConnection();
	    String query = "INSERT INTO role (rolename) VALUES (?)";
	    int isAddRole = 0;
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, rolename);
	        
	        isAddRole = preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return isAddRole;
	}

}
