package Files;

import java.sql.*;
import java.util.*;

public class ProductDAO {
    ArrayList<Product> products = new ArrayList<>();
    UserService us = new UserService();
    Product findByName(String name){
        
        Product product = null;
        String sql = "SELECT * FROM products WHERE name = ?";

        // Establish the database connection
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the username parameter
            ps.setString(1, name);

            // Execute the query
            try (ResultSet rs = ps.executeQuery()) {
                // Check if the user exists
                if (rs.next()) {
                    // Retrieve user details
                    String nameFound = rs.getString("name");
                    String description = rs.getString("description"); // Example additional field
                    double price = rs.getDouble("price");
                    int id = rs.getInt("id");
                    int quantity = rs.getInt("quantity");
                    int sellerID = rs.getInt("seller_id");
                    System.out.println("Product found! Name: "+ nameFound + " ID: " + id + " Description: " + description + " Price: " + price);

                    product = new Product(id, nameFound, description, price, quantity, sellerID);
                    for(Product products: products){
                        if (products.getName().toLowerCase() == name.toLowerCase()){
                            return products;
                        }

                    }
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    };

    public void createProduct(Product product){
        String sql = "INSERT INTO products (id, name, price, description, quantity, seller_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getDescription());
            ps.setInt(5, product.getQuantity());
            ps.setInt(6, product.getSellerID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    public void updateProduct(int Id, String name, double price, String description, int quantity, int sellerID){
        String sql = "UPDATE products SET name = ?, price = ?, description = ?, quantity = ?, seller_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setString(3, description);
            pstmt.setInt(4, quantity);
            pstmt.setInt(5, sellerID);
            pstmt.setInt(6, Id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    public void deleteProduct(int id){
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    public void getAllProducts(){
        String sql = "SELECT * FROM products";
        try (Connection conn = DatabaseConnection.getConnection();
            Statement ps = conn.createStatement()) {
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int sellerID = rs.getInt("seller_id");
                User seller = us.userDAO.getUserById(sellerID);
                String selName = seller.getUsername();
                String selEmail = seller.getEmail();
                
                System.out.println("Product[ Name: "+ name+ " , Price: " + price + ", Description: "+ description + ", Quantity: "+ quantity + " ]  Seller[ Seller ID: " + sellerID + ", Seller Name: " + selName + ", Seller Email: " + selEmail + "]");


                products.add(new Product(id, name, description, price, quantity, sellerID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getProductsBySellerID(int id){
        String sql = "SELECT * FROM products where seller_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idS = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int sellerID = rs.getInt("seller_id");

                System.out.println("Product[ Name: "+ name+ " , Price: " + price + " Description: "+ description + " Quantity: "+ quantity);

                products.add(new Product(idS, name, description, price, quantity, sellerID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
