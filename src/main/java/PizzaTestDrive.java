public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.OrderPizza("cheese");
        System.out.println(pizza.getName());

        pizza = chicagoStore.OrderPizza("cheese");
        System.out.println(pizza.getName());
    }
}
