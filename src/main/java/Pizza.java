import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();
    public void prepare() {
        for (String topping : toppings) {
            System.out.println(" " + topping);
        }
    }

    public void bake() {
        System.out.println("bake for 25 minutes in 175C");
    }

    void cut() {
        System.out.println("cut side");
    }

    public void box() {
        System.out.println("put into box");
    }
    public String getName() {
        return name;
    }
}
