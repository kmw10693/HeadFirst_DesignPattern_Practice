public class SingletonWithStaticInit {

    private static SingletonWithStaticInit uniqueInstance = new SingletonWithStaticInit();

    private SingletonWithStaticInit() {}

    public static SingletonWithStaticInit getInstance() {
        return uniqueInstance;
    }
}
