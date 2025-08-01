package service;

import model.*;

import java.util.*;

public class CustomerService {
    static Scanner scanner=new Scanner(System.in);

    static ArrayList<Customer> customers=new ArrayList<>();
    static int customerCount=0;
    static {
        customers.add(new Customer(++customerCount,"aaa","aaa"));
        customers.add(new Customer(++customerCount,"bbb","bbb"));
        customers.add(new Customer(++customerCount,"ccc","ccc"));
        customers.add(new Customer(++customerCount,"ddd","ddd"));
    }

    public void login() {
        System.out.println("Login Page....");
        System.out.println("\nEnter Customer id: ");
        int id=scanner.nextInt();
        System.out.println("\nEnter Password: ");
        String  password=scanner.next();

        for(Customer customer:customers){
            if(customer.customerId==id){
                if(customer.password.equals(password)){
                    System.out.println("Login successful....");
                    functionalities(customer);
                }
                else System.out.println("Password in correct...");
                return;
            }
        }
         System.out.println("Invalid customer Id....");
    }

    public  void signUp(){
        System.out.println("SignUp Page....");
        System.out.println("\nEnter Customer Name: ");
        String name=scanner.next();
        System.out.println("\nEnter Password: ");
        String  password=scanner.next();

        customers.add(new Customer(++customerCount,name,password));
        System.out.println("SignUp successful your customer Id:"+customerCount);
    }

    private void functionalities(Customer customer) {
        while (true){
            System.out.println("1.List Inventory\n2.Add to cart\n3.View Cart\n4.Buy items\n5.Exit\n\n");

            System.out.println("Enter choice : ");
            int choice =scanner.nextInt();

            switch (choice){
                case 1:
                    listInventory();
                    break;
                case 2:
                    addToCart(customer);
                    break;
                case 3:
                    viewCart(customer);
                    break;
                case 4:
                    butItems(customer);
                    break;
                case 5:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid input....");
            }
        }
    }

    private void viewCart(Customer customer) {
        System.out.println(customer.cart);
    }

    private void butItems(Customer customer) {
        System.out.println("Products Brought....:");
        for(CartProduct product1:customer.cart.products){
             int sellerId =product1.product.productId/100;
             int count=product1.count;
             goto1:
             for(Seller seller:SellerService.sellers){
                 if(seller.sellerId==sellerId){
                     for(Product product: seller.productList){
                         if(product.productId==product1.product.productId){
                             if(product.availableCount>=count){
                                 product.availableCount-=count;
                                 System.out.println(product1);
                             }
                             else {
                                 System.out.println("current Available count for "+product.productId+" less then count");
                             }
                             break goto1;
                         }
                     }
                 }
             }
        }
        customer.cart=new Cart();

    }

    private void listInventory() {
        SellerService sellerService=new SellerService();
        sellerService.ListInventory();
    }
    private void  addToCart(Customer customer){

        System.out.println("Add to Cart....");

        System.out.println("Enter Product id:");
        int id=scanner.nextInt();
        System.out.println("Enter Count of Product:");
        int count=scanner.nextInt();

        int sellerId=id/100;

        for(Seller seller: SellerService.sellers){
            if(seller.sellerId==sellerId){
                for(Product product:seller.productList){
                    if(product.productId==id){
                        if(count<=product.availableCount){
                            customer.cart.addProduct(product,count);
                            System.out.println("Product added to cart successful...");
                            return;
                        }
                        System.out.println("Count greater then Available.....");
                        return;
                    }
                }
                System.out.println("Invalid Product id...");
                return;
            }
        }
        System.out.println("Invalid Product id...");
    }
}
