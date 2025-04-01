
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Creación de un café simple
        Beverage coffee = new Coffee();
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        // Café decorado con Leche
        Beverage milkCoffee = new MilkDecorator(coffee);
        System.out.println(milkCoffee.getDescription() + " $" + milkCoffee.cost());

        // Café decorado con Leche y Azúcar
        Beverage sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sugarMilkCoffee.getDescription() + " $" + sugarMilkCoffee.cost());
    }
}

// Interfaz que define la bebida
interface Beverage {
    String getDescription();
    double cost();
}

// Implementación básica de una bebida: Café
class Coffee implements Beverage {
    @Override
    public String getDescription() {
        return "Café";
    }

    @Override
    public double cost() {
        return 1.50;
    }
}

// Clase abstracta Decorator que implementa Beverage y tiene una referencia a Beverage
abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();
    public abstract double cost();
}

// Decorador concreto que añade Leche a la bebida
class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", con Leche";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }
}

// Decorador concreto que añade Azúcar a la bebida
class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", con Azúcar";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}


