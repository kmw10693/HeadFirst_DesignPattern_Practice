public class Light {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("Light has been executed");
    }

    public void off() {
        System.out.println("Light has been off.");
    }
}
