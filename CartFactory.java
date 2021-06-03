package spring.example.HW2;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class CartFactory {

    @Lookup
    public Cart createCart(){
        return null;
    }
}
