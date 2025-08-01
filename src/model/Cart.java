package model;
import java.util.*;

public class Cart {
    public int totalPrice=0,count=0;
    public List<CartProduct> products=new ArrayList<>();

    public void addProduct(Product product,int count){
        CartProduct cartProduct=new CartProduct(product,count);
        products.add(cartProduct);
        totalPrice+=product.price*count;
    }

    @Override
    public String toString() {
        return "\ntotalPrice=" + totalPrice +
                "\n, products=" + products ;
    }
}
