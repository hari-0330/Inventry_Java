package service;

import model.Customer;
import model.Product;
import model.Seller;

import java.util.*;


public class SellerService {
    static Scanner scanner=new Scanner(System.in);

    static ArrayList<Seller> sellers=new ArrayList<>();
    static int sellerCount=0;
    static {
        sellers.add(new Seller(++sellerCount,"111","111"));
        sellers.add(new Seller(++sellerCount,"111","111"));
        sellers.add(new Seller(++sellerCount,"111","111"));
        sellers.add(new Seller(++sellerCount,"111","111"));
        sellers.add(new Seller(++sellerCount,"111","111"));
    }

    public void login(){
        System.out.println("Login Page....");
        System.out.println("\nEnter Seller id: ");
        int id=scanner.nextInt();
        System.out.println("\nEnter Password: ");
        String  password=scanner.next();

        for(Seller seller:sellers){
            if(seller.sellerId==id){
                if(seller.password.equals(password)){
                    System.out.println("Login successful....");
                    functionalities(seller);
                }
                else System.out.println("Password in correct...");
                return;
            }
        }
        System.out.println("Invalid customer Id....");
    }
    public  void signUp(){
        System.out.println("SignUp Page....");
        System.out.println("\nEnter Seller Name: ");
        String name=scanner.next();
        System.out.println("\nEnter Password: ");
        String  password=scanner.next();

        sellers.add(new Seller(++sellerCount,name,password));
        System.out.println("SignUp successful your customer Id:"+sellerCount);
    }

    private void functionalities(Seller seller) {
        while (true){
            System.out.println("1.Add product\n2.Update Product\n3.List Product\n4.Exit\n\n");

            System.out.println("Enter choice : ");
            int choice =scanner.nextInt();

            switch (choice){
                case 1:
                    addProduct(seller);
                    break;
                case 2:
                    updateProduct(seller);
                    break;
                case 3:
                    listProduct(seller);
                    break;
                case 4:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid input....");
            }
        }
    }

    private void listProduct(Seller seller) {
        seller.listProduct();
    }

    private void updateProduct(Seller seller) {

        System.out.println("Update Product");

        System.out.println("Enter Product id to Update :");
        int id =scanner.nextInt();
        for(Product product:seller.productList){
            if(product.productId==id) {
                System.out.println("\nEnter New Product name: ");
                String name = scanner.next();
                System.out.println("\nEnter New Description: ");
                scanner.nextLine();
                String description = scanner.nextLine();
                System.out.println("\nEnter New Available Count: ");
                int count = scanner.nextInt();
                System.out.println("\nEnter New Price: Rs.");
                int price = scanner.nextInt();

                seller.updateProduct(new Product(id, name, description, count, price));
                System.out.println("Update successful...");
                return;
            }
        }
        System.out.println("Invalid id");

    }

    private void addProduct(Seller seller) {
        System.out.println("Add product....");

        int id= seller.productList.size()+1+seller.sellerId*100;
        System.out.println("\nEnter Product name: ");
        String name=scanner.next();
        System.out.println("\nEnter Description: ");
        scanner.nextLine();
        String  description=scanner.nextLine();
        System.out.println("\nEnter Available Count: ");
        int count=scanner.nextInt();
        System.out.println("\nEnter Price: Rs.");
        int  price=scanner.nextInt();

        seller.addProduct(new Product(id,name,description,count,price));
    }

    public void ListInventory() {
        for(Seller seller:sellers){
            System.out.println("Seller name: "+seller.name );
            seller.listProduct();
        }
    }
}
