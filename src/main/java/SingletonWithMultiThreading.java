public class SingletonWithMultiThreading {

    private static SingletonWithMultiThreading uniqueInstance;

    private SingletonWithMultiThreading() {}

    /**
     * getInstance에 synchronized 키워드만 추가하면 한 스레드가
     * 메서드 사용을 끝내기 전까지 다른 스레드는 기다려야 한다.
     * 즉 2개의 스레드가 이 메서드를 동시에 실행하는 일은 일어나지 않는다.
     * @return
     */
    public static synchronized SingletonWithMultiThreading getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonWithMultiThreading();
        }
        return uniqueInstance;
    }
}
