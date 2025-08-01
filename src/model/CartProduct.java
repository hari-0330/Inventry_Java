package model;

public class CartProduct{
    public int count;
    public Product product;
    public CartProduct(Product product,int count){
        this.product=product;
        this.count=count;
    }

    @Override
    public String toString() {
        return product+"\nCount :"+count;
    }
}
