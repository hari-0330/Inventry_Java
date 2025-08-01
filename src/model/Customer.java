package model;

public class Customer {
    public int customerId;
    public String name,password;
    public Cart cart;

    public Customer(int customerId,String name,String password){
        this.customerId=customerId;
        this.name=name;
        this.password=password;
        cart=new Cart();
    }

    public void listCart(){
        System.out.println("In cart:\n"+cart);
    }

    public void buyProduct(){
        System.out.println("Products brought:\n"+cart);
    }
}
