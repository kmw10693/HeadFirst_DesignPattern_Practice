public abstract class PizzaStore {
    Pizza pizza;

    public Pizza OrderPizza(String type) {

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }


    abstract Pizza createPizza(String type);
}
