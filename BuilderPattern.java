import java.util.Scanner;

class Meal {
    private String drink;
    private String mainCourse;
    private String side;

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public void setSide(String side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Meal [drink=" + drink + ", mainCourse=" + mainCourse + ", side=" + side + "]";
    }
}

interface MealBuilder {
    void buildDrink(String drink);
    void buildMainCourse(String mainCourse);
    void buildSide(String side);
    Meal getMeal();
}

class CustomMealBuilder implements MealBuilder {
    private Meal meal;

    public CustomMealBuilder() {
        meal = new Meal();
    }

    @Override
    public void buildDrink(String drink) {
        meal.setDrink(drink);
    }

    @Override
    public void buildMainCourse(String mainCourse) {
        meal.setMainCourse(mainCourse);
    }

    @Override
    public void buildSide(String side) {
        meal.setSide(side);
    }

    @Override
    public Meal getMeal() {
        return meal;
    }
}

class MealDirector {
    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public void constructMeal(String drink, String mainCourse, String side) {
        mealBuilder.buildDrink(drink);
        mealBuilder.buildMainCourse(mainCourse);
        mealBuilder.buildSide(side);
    }

    public Meal getMeal() {
        return mealBuilder.getMeal();
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your drink: ");
        String drink = scanner.nextLine();

        System.out.println("Choose your main course: ");
        String mainCourse = scanner.nextLine();

        System.out.println("Choose your side: ");
        String side = scanner.nextLine();

        MealBuilder customMealBuilder = new CustomMealBuilder();
        MealDirector mealDirector = new MealDirector(customMealBuilder);

        mealDirector.constructMeal(drink, mainCourse, side);
        Meal meal = mealDirector.getMeal();

        System.out.println("Meal constructed: " + meal);
    }
}
