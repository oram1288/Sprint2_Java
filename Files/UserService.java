package Files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    ArrayList<User> users = new ArrayList<>();
    
    public UserService(){

    }

    public User findByUsername(String username){
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";

        // Establish the database connection
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the username parameter
            ps.setString(1, username);

            // Execute the query
            try (ResultSet rs = ps.executeQuery()) {
                // Check if the user exists
                if (rs.next()) {
                    // Retrieve user details
                    String usernameFound = rs.getString("username");
                    String email = rs.getString("email"); // Example additional field
                    String role = rs.getString("role");
                    int id = rs.getInt("id");
                    System.out.println("User found! Username: "+ usernameFound + " ID: " + id + " Email: " + email + " Role: " + role);

                    //user = new User(usernameFound, null, email, role);
                    for(User users: users){
                        if (users.getUsername().toLowerCase() == username.toLowerCase()){
                            return users;
                        }

                    }
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    } 

    public void registerUser(User user){
        String sql = "INSERT INTO users(id, username, password, email, role) VALUES(?,?,?,?,?)";

        // Establish the database connection
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the parameter
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getRole());

            // Execute the query
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println(rs);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean authenticateUser(String username, String password){
        String sql = "SELECT * FROM USERS WHERE username = ? and password = ?";

        // Establish the database connection
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the parameter
            ps.setString(1, username);
            ps.setString(2, password);

            // Execute the query
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println(rs);
                if(rs != null){
                    return true;
                }else{
                    return false;
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}

