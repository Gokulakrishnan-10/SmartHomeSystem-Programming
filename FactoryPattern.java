import java.util.Scanner;
interface Dish {
    void prepare();
}

class Pasta implements Dish {
    @Override
    public void prepare() {
        System.out.println("Preparing Pasta");
    }
}

class Pizza implements Dish {
    @Override
    public void prepare() {
        System.out.println("Preparing Pizza");
    }
}

class DishFactory {
    // Factory method to create objects based on input type
    public Dish getDish(String dishType) {
        if (dishType == null) {
            return null;
        }
        if (dishType.equalsIgnoreCase("PASTA")) {
            return new Pasta();
        } else if (dishType.equalsIgnoreCase("PIZZA")) {
            return new Pizza();
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        DishFactory dishFactory = new DishFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Restaurant! What would you like to order?");
        System.out.println("1. Pasta");
        System.out.println("2. Pizza");
        System.out.print("Enter your choice (1 for Pasta, 2 for Pizza): ");
        int choice = scanner.nextInt();

        Dish dish;
        if (choice == 1) {
            dish = dishFactory.getDish("PASTA");
        } else if (choice == 2) {
            dish = dishFactory.getDish("PIZZA");
        } else {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        System.out.println("order taken");
        dish.prepare(); // Prepare the ordered dish

        scanner.close();
    }
}
