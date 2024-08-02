<<<<<<< HEAD
package Files;

import java.util.ArrayList;
import java.util.List;

=======
import java.util.ArrayList;
import java.util.List;
 
>>>>>>> 8024756a1acdecd1634c0dbaa4c79afd404ec90e
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
 
    public static List<Product> sampleProducts = new ArrayList<>();
 
    // Constructor
    public Product(int id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
<<<<<<< HEAD

    public static List<Product> sampleProducts = new ArrayList<>();

    // Getters
    public int getId() {
        return id;
=======
 
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
 
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
 
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
 
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
 
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
 
    // Method to initialize sample data
    public static void initializeSampleData() {
        sampleProducts.add(new Product(1, "Modern Sofa", "A comfortable modern sofa.", 599.99, 10));
        sampleProducts.add(new Product(2, "Dining Table Set", "A set of dining table with 6 chairs.", 899.99, 5));
        sampleProducts.add(new Product(3, "Queen Bed Frame", "Stylish queen bed frame.", 299.99, 7));
        sampleProducts.add(new Product(4, "Office Chair", "Ergonomic office chair.", 199.99, 15));
        sampleProducts.add(new Product(5, "Coffee Table", "Glass-top coffee table.", 149.99, 20));
        sampleProducts.add(new Product(6, "Bookshelf", "Wooden bookshelf with 5 shelves.", 249.99, 12));
        sampleProducts.add(new Product(7, "Recliner", "Comfortable leather recliner.", 399.99, 8));
        sampleProducts.add(new Product(8, "TV Stand", "Modern TV stand with storage.", 179.99, 10));
        sampleProducts.add(new Product(9, "Nightstand", "Minimalist nightstand with drawer.", 89.99, 25));
>>>>>>> 8024756a1acdecd1634c0dbaa4c79afd404ec90e
    }
 
    // Overriding toString() method
    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
<<<<<<< HEAD


public static void initializeSampleData() {
    sampleProducts.add(new Product(1, "Modern Sofa", "A comfortable modern sofa.", 599.99, 10));
    sampleProducts.add(new Product(2, "Dining Table Set", "A set of dining table with 6 chairs.", 899.99, 5));
    sampleProducts.add(new Product(3, "Queen Bed Frame", "Stylish queen bed frame.", 299.99, 7));
    sampleProducts.add(new Product(4, "Office Chair", "Ergonomic office chair.", 199.99, 15));
    sampleProducts.add(new Product(5, "Coffee Table", "Glass-top coffee table.", 149.99, 20));
    sampleProducts.add(new Product(6, "Bookshelf", "Wooden bookshelf with 5 shelves.", 249.99, 12));
    sampleProducts.add(new Product(7, "Recliner", "Comfortable leather recliner.", 399.99, 8));
    sampleProducts.add(new Product(8, "TV Stand", "Modern TV stand with storage.", 179.99, 10));
    sampleProducts.add(new Product(9, "Nightstand", "Minimalist nightstand with drawer.", 89.99, 25));
}

// Main method for testing
public static void main(String[] args) {
    // Initialize sample data
    Product.initializeSampleData();

    // Display all products
    for (Product product : Product.sampleProducts) {
        System.out.println(product);
    }
}
=======
 
    // Main method for testing
    public static void main(String[] args) {
        // Initialize sample data
        Product.initializeSampleData();
 
        // Display all products
        for (Product product : Product.sampleProducts) {
            System.out.println(product);
        }
    }
>>>>>>> 8024756a1acdecd1634c0dbaa4c79afd404ec90e
}
