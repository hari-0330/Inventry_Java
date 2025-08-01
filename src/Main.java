import model.Customer;
import model.Product;
import model.Seller;
import service.CustomerService;
import service.SellerService;

import java.util.*;

class Main{
    static Scanner scanner=new Scanner(System.in);
    static CustomerService customerService=new CustomerService();
    static SellerService sellerService=new SellerService();
    public static void main(String[] arr){


        while (true){
            System.out.println("1.Seller\n2.Customer\n3.Exit\n\n");
            System.out.println("Enter choice : ");
            int choice =scanner.nextInt();

            switch (choice){
                case 1:
                    seller();
                    break;
                case 2:
                    customer();
                    break;
                case 3:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid input....");
            }
        }
    }

    private static void customer() {
        while (true){
            System.out.println("1.Login\n2.SignUp\n3.Exit\n\n");

            System.out.println("Enter choice : ");
            int choice =scanner.nextInt();

            switch (choice){
                case 1:
                    customerService.login();
                    break;
                case 2:
                    customerService.signUp();
                    break;
                case 3:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid input....");
            }
        }
    }

    private static void seller() {
        while (true){
            System.out.println("1.Login\n2.SignUp\n3.Exit\n\n");

            System.out.println("Enter choice : ");
            int choice =scanner.nextInt();

            switch (choice){
                case 1:
                    sellerService.login();
                    break;
                case 2:
                    sellerService.signUp();
                    break;
                case 3:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid input....");
            }
        }
    }
}