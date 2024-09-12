package Files;

import java.util.ArrayList;

public class ProductService {
     ArrayList<User> users = new ArrayList<>();
    ProductDAO productDAO = new ProductDAO();
    
    public ProductService(){
        productDAO = new ProductDAO();
    }


    
}
