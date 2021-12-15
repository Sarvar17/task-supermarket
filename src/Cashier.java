public class Cashier implements Runnable {
    private final String name;
    private Customer customer;

    // Constructor for cashier class.
    public Cashier(String name) {
        this.name = name;
    }

    // Method to get name of cashier.
    public String getName() {
        return name;
    }

    // Method to set customer which will be served then.
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Method run for a thread.
    public void run() {
        System.out.println("\n" +name + " serves " + customer.getPropName());
        System.out.println(customer.getPropName() + " must pay for products " +
                Functions.calculateSum(customer.getProducts()) + " rub");
    }
}