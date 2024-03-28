public class NYStylePizzaStore extends PizzaStore {


    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NyPizzaIngredientFactory();

        if (item.equals("cheese")) {

            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("NY STYLE CHEESE PIZZA");

        } else if (item.equals("veggie")) {

            pizza = new VeggiePizza(pizzaIngredientFactory);
            pizza.setName("NY STYLE VEGGIE PIZZA");

        } else if (item.equals("clam")) {

            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("NY STYLE CLAM PIZZA");

        } else if (item.equals("pepperoni")) {

            pizza = new PepperoniPizza(pizzaIngredientFactory);
            pizza.setName("NY STYLE PEPPERONI PIZZA");

        }
        return pizza;
    }
}
