import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Initializing two cashiers.
        Cashier cashier1 = new Cashier("1st cashier");
        Cashier cashier2 = new Cashier("2nd cashier");

        // Initializing 5 customers and their threads.
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            customers.add(new Customer("#" + (i + 1) + " customer", 10));
            threads.add(new Thread(customers.get(i)));
        }

        // Starting customers' threads, i.e. customers start buying products.
        for (Thread thread : threads) {
            thread.start();
        }

        // Cashier starts work if thread in customers' thread finished buying products.
        int i = 0;
        while (i < 5) {
            int j = 0;
            for (Thread thread : threads) {
                if (!thread.isAlive()) {
                    Cashier temp = Functions.getRandomCashier(cashier1, cashier2);

                    temp.setCustomer(customers.get(j));
                    Thread tempThread = new Thread(temp);
                    tempThread.start();
                    tempThread.join();

                    customers.remove(thread);
                    ++i;
                }
                ++j;
            }
        }

        // Announcing that all customers have been served.
        System.out.println("\nAll customers are served!");
    }
}
