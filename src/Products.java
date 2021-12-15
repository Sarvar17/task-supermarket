import java.util.Random;

public enum Products {
    milk, water, energyDrink, eggs, bread, coffee, cookies, yogurt;

    public static Products getRandomProduct() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
