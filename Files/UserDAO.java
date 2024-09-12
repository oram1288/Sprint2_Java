package Files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDAO {
    ArrayList<User> users = new ArrayList<>();
    User findByUsername(String username){
        
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";

        // Establish the database connection
        try (Connection conn = DatabaseConnection.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);

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
                    String password = rs.getString("password");
                    int id = rs.getInt("id");
                    System.out.println("User found! Username: "+ usernameFound + " ID: " + id + " Email: " + email + " Role: " + role);

                    user = new User(usernameFound, password, email, role);
                    for(User userFound: users){
                        if (userFound.getUsername().toLowerCase() == username.toLowerCase()){
                            
                            return userFound;
                        }

                    }
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    };
    
    
    public void createUser(User user){
        String sql = "INSERT INTO users (id, username, password, email, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getRole());
            ps.executeUpdate();
            System.out.println("Your User ID is: " + user.getId() + " Remember this ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public User getUserById(int id){
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),rs.getString("email"), rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    };
    public void updateUser(int Id, String username, String password, String email, String role){
        String sql = "UPDATE users SET username = ?, password = ?, email = ?, role = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, role);
            pstmt.setInt(5, Id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public void deleteUser(int id){
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    public void getAllUsers(){
        String sql = "SELECT * FROM users";
        try (Connection conn = DatabaseConnection.getConnection();
            Statement ps = conn.createStatement()) {
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String role = rs.getString("role");
                String number = rs.getString("phonenumber");
                System.out.println("User[Name: " + username + ", ID: " + id + ", Email: " + email + ", Phone Number: "+ number + " Role: " + role + "]");

                users.add(new User(id, username, password, email, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
