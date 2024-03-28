import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    List<String> toppings = new ArrayList<>();
    abstract void prepare();

    public void bake() {
        System.out.println("bake for 25 minutes in 175C");
    }

    void cut() {
        System.out.println("cut side");
    }

    public void box() {
        System.out.println("put into box");
    }

    public void setName(String name) { this.name = name; }
    public String getName() {
        return name;
    }
}
