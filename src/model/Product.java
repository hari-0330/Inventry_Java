package model;

public class Product {
    public int productId,availableCount,price;
    public String productDescription,name;

    public Product(){}
    public Product(int productId,String name,String productDescription,int availableCount,int price){
        this.productId=productId;
        this.name=name;
        this.productDescription=productDescription;
        this.availableCount=availableCount;
        this.price=price;
    }

    @Override
    public String toString() {
        return "\nProduct Name :"+name+"\nProduct Id:"+productId+"\nDescription :"+productDescription+"\nAvailable Count :"+availableCount+"\nPrice :Rs."+price;
    }
}
