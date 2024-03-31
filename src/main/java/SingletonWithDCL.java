public class SingletonWithDCL {

    private volatile static SingletonWithDCL uniqueInstance;

    private SingletonWithDCL() {}

    /**
     * 인스턴스가 있는지 확인하고 없으면 동기화된 블록으로 들어갑니다.
     * volatile 키워드를 사용하면 멀티쓰레딩을 쓰더라도 uniqueInstance 변수가 Singleton 인스턴스로
     * 초기화되는 과정이 올바르게 진행됩니다.
     * DCL 자바 1.4 이전에 쓸 수 없다.
     * @return
     */
    public static SingletonWithDCL getInstance() {
        if(uniqueInstance == null) {
            synchronized (SingletonWithDCL.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonWithDCL();
                }
            }
        }
        return uniqueInstance;
    }
}
