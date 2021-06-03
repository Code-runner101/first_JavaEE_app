package spring.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spring.example.HW2.Cart;
import spring.example.HW2.CartFactory;
import spring.example.HW2.Product;
import spring.example.HW2.ProductRepository;
import spring.example.config.ApplicationConfiguration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CartStarter {
    private final ProductRepository productRepository;
    private final CartFactory cartFactory;

    public CartStarter(ProductRepository productRepository, CartFactory cartFactory) {
        this.productRepository = productRepository;
        this.cartFactory = cartFactory;
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    }

        @PostConstruct
        public void start(){
            System.out.println("To see all the list of products type 'find all'");
            System.out.println("To find a product by id type 'find by id'");
            System.out.println("To remove product from cart type 'remove'");
            System.out.println("To add product to your cart type 'add'");
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    String input = scanner.nextLine();
                    final Cart cart = cartFactory.createCart();
                    if (input.equals("find all")) {
                        final List<Product> products = productRepository.findAll();
                        products.forEach(x -> System.out.println(x.getId() + " " + x.getName() + " " + x.getCost()));
                    }
                    if (input.equals("find by id")){
                        System.out.println("input product id:");
                        int id = scanner.nextByte();
                        System.out.println(productRepository.findById(id).getName() + " " + productRepository.findById(id).getCost());
                    }
                    if (input.equals("add")){
                        System.out.println("type product's id to add it to your cart");
                        int id = scanner.nextInt();
                        Product product = productRepository.findById(id);
                        cart.add(product);
                        System.out.println("product: " + product.getName() + " has been added");
                    }
                    if (input.equals("remove")){
                        System.out.println("type product's id to remove it from your cart");
                        int id = scanner.nextInt();
                        Product product = productRepository.findById(id);
                        cart.remove(product);
                        System.out.println("product: " + product.getName() + " has been removed");
                    }
                    System.out.println("-------------------------------------");
                }
            }catch (Exception e){
                System.err.println("Exception while cart manipulation");

            }
    }
}
