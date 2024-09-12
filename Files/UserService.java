package Files;

//import org.mindrot.jbcrypt.BCrypt;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;


public class UserService{
    ArrayList<User> users = new ArrayList<>();
    UserDAO userDAO = new UserDAO();
    
    public UserService(){
        userDAO = new UserDAO();
    }


    public void registerUser(User user){
        if(user.equals(null)){
            System.out.println("User Is Null");
        
        }
        //String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
 
        User newUser = new User(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
        userDAO.createUser(newUser);
        System.out.println("User Created");
    }

    public boolean authenticateUser(String username, String password){
        if(username == null || password == null){
            System.out.println("The User Does Not Exist");
            return false;
        }

        User user = userDAO.findByUsername(username);

        if(user == null){
            System.out.println("The User Does Not Exist! ");
            return false;
        }

        if(password.equals(user.getPassword())){
            System.out.println("User has passed Auth");
            return true;
        }else{
            System.out.println("Wrong Password, Please Try Again!");
            return false;
        }
}}