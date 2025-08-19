import java.util.*;
import java.lang.*;
import java.io.*;

class ProductTracker {
    private PriorityQueue<Product> maxProd;
    private PriorityQueue<Product> minProd;
    private HashMap<String, Product> productMap;
    
    public class void main(Sting[] args) {
        ProductTracker pt = new ProductTracker();
		pt.wishlit("a");
		pt.wishlit("a");
		pt.wishlit("a");
		
		pt.wishlit("b");
		pt.wishlit("b");
		System.out.println(pt.getMaxProduct());
		System.out.println(pt.getMinProduct());
		pt.delist("a");
		pt.delist("a");
		System.out.println(pt.getMaxProduct());
		System.out.println(pt.getMinProduct());
		pt.delist("a");
		pt.delist("a");
		System.out.println(pt.getMaxProduct());
		System.out.println(pt.getMinProduct());]
    }
    public ProductTracker() {
        maxProd = new PriorityQueue<>(
            (a,b) -> (Integer.compare(b.getWishes(), a.getWishes());
        )

        minProd = new PriorityQueue<>(
            (a,b) -> (Integer.compare(a.getWishes(), a.getWishes());
        )
        productMap = new HashMap<>();
    }
    
    public void wishlist(String productName) {
        Product product = new Product(productName);
        productMap.put(productName, product);
        maxProd.offer(product);
        minProd.offer(product);
    }
    
    public void delist(String productName) {
        Product product = new Product(productName);
        if(product != null) {
            maxProd.remove(product);
            minProd.remove(product);
        }
    }
    
    public String getMaxProduct() {
        
    }
    
    public String getMinProduct() {
        
    }
}

Class Product {
    private String productName;
    private int wishes;
    
    Product(String productName) {
        this.productName = productName;
        this.wishes = 0;
    }
    
    public int getWishes() {
        return this.wishes;
    }

    public String getProductName() {
        return productName;
    }
}
