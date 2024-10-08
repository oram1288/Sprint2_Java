package Files;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;

    int upperBound = 10000;
    int randomInt = (int) (Math.random() * upperBound);
    

    int count = randomInt;

    public User(int id, String username, String password, String email, String role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public User(String username, String password, String email, String role){
        this.id = count;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        count+=1;
    }

    public void setID(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }

    
    public String toString() {
        return "User: " + username + " ID: " + id + " Email: "+ email +" Role: "+ role;
    }
    
}
