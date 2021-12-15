import java.util.ArrayList;
import java.util.Random;

public class Functions {
    // Method to calculate how much customer must pay for his/her purchased products.
    static int calculateSum(ArrayList<Products> products) {
        int sum = 0;
        for (Products product : products) {
            switch (product) {
                case milk:
                    sum += 100;
                    break;
                case water:
                    sum += 70;
                    break;
                case energyDrink:
                    sum += 79;
                    break;
                case bread:
                    sum += 50;
                    break;
                case eggs:
                    sum += 119;
                    break;
                case yogurt:
                    sum += 99;
                    break;
                case cookies:
                    sum += 120;
                    break;
                case coffee:
                    sum += 299;
                    break;
                default:
                    break;
            }
        }
        return sum;
    }

    // Method to get random cashier.
    public static Cashier getRandomCashier(Cashier cashier1, Cashier cashier2) {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            return  cashier1;
        }
        else {
            return cashier2;
        }
    }
}
