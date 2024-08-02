package Files;

public class Seller extends User {
    private String storeName;
    private String storeAddress;

    public Seller(String username, String password, String email, String role, String storeName, String storeAddress) {
        super(username, password, email, role);
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }

    // Getters
    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    // Setters
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    // String
    @Override
    public String toString() {
        return "Seller {" +
                "Id =" + getId() +
                ", Username ='" + getUsername() + '\'' +
                ", Email ='" + getEmail() + '\'' +
                ", StoreName ='" + getStoreName() + '\'' +
                ", StoreAddress ='" + getStoreAddress() + '\'' +
                ", Role ='" + getRole() + '\'' +
                '}';
    }
}
