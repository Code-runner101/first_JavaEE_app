package spring.example.HW2;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private AtomicInteger count = new AtomicInteger(1);

    public AtomicInteger getCount() {
        return count;
    }

    public Product findById(int id){
        return products.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public List<Product> findAll(){
        return products;
    }

    public void add(Product product){
        products.add(product);
    }

    @PostConstruct
    public void init(){
        Product product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Apple");
        product.setCost(34);
        products.add(product);
        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Carrot");
        product.setCost(12);
        products.add(product);
        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Pineapple");
        product.setCost(56);
        products.add(product);
        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Watermelon");
        product.setCost(44);
        products.add(product);
        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Peach");
        product.setCost(47);
        products.add(product);
    }
}
