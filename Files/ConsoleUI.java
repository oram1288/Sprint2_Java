package Files;

import java.util.Scanner;

// import org.mindrot.jbcrypt.BCrypt;
 
public class ConsoleUI {
 
    private UserService userService;
    private ProductService productService;
 
    private Scanner scanner;
 
    public ConsoleUI() {
        this.userService = new UserService(); 
        // Instantiate UserService
        this.productService = new ProductService(); 
        // Instantiate ProductService
        this.scanner = new Scanner(System.in); // Scanner for user input
    }
 
    public void start() {
        boolean exit=false;
 
        while (!exit) {
            displayMainMenu();
 
            int choice= scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    login();
                break;
                case 2:
                    register();
                break;
                case 3:
                    exit = true;
                break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
 
        System.out.println("Exiting the application. Goodbye!");
        scanner.close();
    }
 
    private void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        //System.out.println(BCrypt.hashpw(kyle), BCrypt.gensalt());
    }
 
    private void login() {
        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String username= scanner.nextLine();
        System.out.print("Enter password: ");
        String password= scanner.nextLine();
 
        // Perform authentication logic using UserService
        boolean authenticated = userService.authenticateUser(username, password);
 
        if (authenticated) {
            // Fetch user details and redirect to appropriate menu based on role
            User user = userService.userDAO.findByUsername(username);
            displayUserMenu(user);
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }
 
    private void register() {
        System.out.println("\n=== Register ===");
        System.out.print("Enter username: ");
        String username= scanner.nextLine();
        System.out.print("Enter password: ");
        String password= scanner.nextLine();
        System.out.print("Enter email: ");
        String email= scanner.nextLine();
        System.out.print("Enter role (buyer/seller/admin): ");
        String role= scanner.nextLine();

        // Hash the password using bcrypt
        // String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
 
        // Create a new user using UserService
        User newUser = new User(username, password, email, role);
        userService.registerUser(newUser);
 
        System.out.println("Registration successful!");
    }
 
    private void displayUserMenu(User user) {
        System.out.println("\n=== Welcome, " + user.getUsername() + " ===");
 
        switch (user.getRole()) {
            case"buyer":
                displayBuyerMenu();
            break;
            case"seller":
                displaySellerMenu();
            break;
            case"admin":
                displayAdminMenu();
            break;
            default:
                System.out.println("Invalid role. Please contact support.");
        }
    }
 
    private void displayBuyerMenu() {
        boolean buyerExit = false;
        
        while(buyerExit != true){
            System.out.println("=========================================================");
            System.out.println("What Would you like to do?");
            System.out.println("(Please enter the number corresponding to your entry)");
            System.out.println("");
            System.out.println("1. View all Products");
            System.out.println("2. Search for Product ");
            System.out.println("3. Back To Main Page");
            System.out.println("=========================================================");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    System.out.println();
                    productService.productDAO.getAllProducts();
                
                break;
                case 2:
                    System.out.println("=========================================================");
                    System.out.println("Enter Product Name");
                    String choice1 = scanner.nextLine();
                    System.out.println();
                    productService.productDAO.findByName(choice1);
                    System.out.println("=========================================================");

                break;
                case 3:
                    start();
                break;
                default:
                    System.out.println("Invalid Choice"); 
            }
        }      
    }
       
 
    private void displaySellerMenu() {
        boolean leave = false;
        while(leave != true){
            System.out.println("=========================================================");
            System.out.println("What would you like to do?");
            System.out.println("(Please enter the number corresponding to your entry)");
            System.out.println("1. Add Product");
            System.out.println("2. Update existing product");
            System.out.println("3. Delete Product");
            System.out.println("4. See my products");
            System.out.println("5. Back to Main Page");
            System.out.println("=========================================================");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    System.out.println("=========================================================");
                    System.out.println("Enter Name of Product to be added");
                    String name = scanner.nextLine();
                    System.out.println("Enter description of Product to be added");
                    String desc = scanner.nextLine();
                    System.out.println("Enter Price of Product to be added");
                    double price = scanner.nextDouble();
                    System.out.println("Enter Quantity of Product to be added");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter your Seller ID");
                    int sellerID = scanner.nextInt();
                    Product newProduct = new Product(name,desc, price, quantity, sellerID);
                    productService.productDAO.createProduct(newProduct);
                    System.out.println("Product Added!");
                    System.out.println("=========================================================");
                break;
                case 2:
                    System.out.println("=========================================================");
                    System.out.println("Enter the name of the product to be edited");
                    String prodName = scanner.nextLine();
                    Product prod = productService.productDAO.findByName(prodName);
                    int prodID = prod.getId();
                    System.out.println("Enter the new name of the product");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the new price of the product");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter the new description of the product");
                    String newDesc = scanner.nextLine();
                    System.out.println("Enter the new quantity of the product");
                    int newQuan = scanner.nextInt();
                    System.out.println("Enter your Seller ID");
                    int newSellerID = scanner.nextInt();
                    productService.productDAO.updateProduct(prodID, newName, newPrice, newDesc, newQuan, newSellerID);
                    System.out.println("Product Updated!");
                    System.out.println("=========================================================");
                break;
                case 3:
                    System.out.println("=========================================================");
                    System.out.println("Enter the name of the Product to be deleted");
                    String delName = scanner.nextLine();
                    Product delProd = productService.productDAO.findByName(delName);
                    int delID = delProd.getId();
                    productService.productDAO.deleteProduct(delID);
                    System.out.println("Product Deleted");
                    System.out.println("=========================================================");
                break;
                case 4:
                    System.out.println("=========================================================");
                    System.out.println("Enter your Seller ID");
                    int sellID = scanner.nextInt();
                    productService.productDAO.getProductsBySellerID(sellID);
                    System.out.println("=========================================================");
                break;
                case 5:
                    leave = true;
                break;
            }
        }
        
    }
 
    private void displayAdminMenu() {
        boolean adminExit = false;
        while(adminExit != true){
            System.out.println("=========================================================");
            System.out.println("What would you like to do?");
            System.out.println("(Please enter the number corresponding to your entry)");
            System.out.println("=========================================================");
            System.out.println("1. View all Users");
            System.out.println("2. Delete User");
            System.out.println("3. View all Products");
            System.out.println("4. Back to Main Page");
            System.out.println("=========================================================");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    System.out.println("=========================================================");
                    userService.userDAO.getAllUsers();
                    System.out.println("=========================================================");
                break;
                case 2:
                    System.out.println("=========================================================");
                    System.out.println("Enter the ID of the User to be deleted");
                    int delUser = scanner.nextInt();
                    userService.userDAO.deleteUser(delUser);
                    System.out.println("User Deleted!");
                    System.out.println("=========================================================");
                break;
                case 3:
                    System.out.println("=========================================================");
                    productService.productDAO.getAllProducts();
                    System.out.println("=========================================================");
                break;
                case 4:
                    adminExit = true;
                break;
                    
            }

        }
        
    }
 
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}
