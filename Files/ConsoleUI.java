package Files;


import java.util.Scanner;
 
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
            User user = userService.findByUsername(username);
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
// Implement buyer menu options
        System.out.println("Buyer menu options placeholder.");
    }
 
    private void displaySellerMenu() {
// Implement seller menu options
        System.out.println("Seller menu options placeholder.");
    }
 
    private void displayAdminMenu() {
// Implement admin menu options
        System.out.println("Admin menu options placeholder.");
    }
 
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}
