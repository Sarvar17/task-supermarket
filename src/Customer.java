import java.util.ArrayList;

public class Customer implements Runnable {
    private final String name;
    private final int number_of_products;
    private final ArrayList<Products> products;

    // Constructor for customer class.
    public Customer(String name, int number_of_products) {
        this.name = name;
        this.number_of_products = number_of_products;
        this.products = new ArrayList<>();
    }

    // Method to get name of customer.
    public String getPropName() {
        return name;
    }

    // Method to get list of products that customer bought.
    public ArrayList<Products> getProducts() {
        return products;
    }

    // Method to add random product to list of products.
    public void addProduct() {
        products.add(Products.getRandomProduct());
    }

    // Method run for a thread.
    public void run() {
        synchronized (this) {
            System.out.println(name + " buying " + number_of_products + " products");
        }
        for (int i = 0; i < number_of_products; ++i) {
            addProduct();
        }
    }
}
