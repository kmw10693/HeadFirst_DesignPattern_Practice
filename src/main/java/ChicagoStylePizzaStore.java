public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            //pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals("clam")) {
            //pizza = new ChicagoStyleClamPizza();
        } else if (type.equals("veggie")) {
            //pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
