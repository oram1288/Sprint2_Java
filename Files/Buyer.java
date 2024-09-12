package Files;

public class Buyer extends User {
    private String address;
    private String phoneNumber;

    public Buyer(String username, String password, String email, String role, String address, String phoneNumber) {
        super(username, password, email, role);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters 
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // String
    public String toString() {
        return "Buyer {" +
                "Id =" + getId() +
                ", Username ='" + getUsername() + '\'' +
                ", Email ='" + getEmail() + '\'' +
                ", Address ='" + getAddress() + '\'' +
                ", PhoneNumber ='" + getPhoneNumber() + '\'' +
                ", Role ='" + getRole() + '\'' +
                '}';
    }
}