package pizzaBilling;

public class Main {
    public static void main(String[] args) {
        Pizza pizza=new Pizza(false);
//        pizza.addExtraCheese();
        pizza.addExtraToppings();
//        pizza.takeAway();
        pizza.getBill();

        DeluxPizza dp=new DeluxPizza(false);
        dp.addExtraCheese();
        dp.addExtraToppings();
        dp.getBill();
    }
}
