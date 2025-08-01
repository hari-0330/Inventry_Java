package model;

import java.util.*;

public class Seller {
    public int sellerId;
    public String name,password;
    public List<Product> productList=new ArrayList<>();

    public Seller(int sellerId,String name,String password){
        this.name=name;
        this.password=password;
        this.sellerId=sellerId;

        productList.add(new Product(productList.size()+1+sellerId*100,"zzz","sssssss",10,100));
        productList.add(new Product(productList.size()+1+sellerId*100,"yyy","sssssss",20,100));
        productList.add(new Product(productList.size()+1+sellerId*100,"xxx","sssssss",45,100));
        productList.add(new Product(productList.size()+1+sellerId*100,"www","sssssss",60,100));
        productList.add(new Product(productList.size()+1+sellerId*100,"vvv","sssssss",70,100));
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void listProduct(){
        for(Product product:productList){
            System.out.println(product);
        }
    }

    public void updateProduct(Product product){
        Product temp=null;
        for(Product product1:productList){
            if(product1.productId==product.productId){
                temp=product1;
            }
        }
        if(temp!=null){
            productList.remove(temp);
            productList.add(product);
        }
    }
}
