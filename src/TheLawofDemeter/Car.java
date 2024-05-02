package TheLawofDemeter;

public class Car {
    Engine engine; // 이 클래스의 구성 요소이므로 메서드 호출 가능

    // 기타 인스턴스 변수
    public Car() {
        // 엔진 초기화 등을 처리
    }

    public void start(Key key){
        Doors doors = new Doors(); // 새 객체가 생성되어, 이 객체의 메서드는 호출 가능
        boolean authorized = key.turns(); // 매개 변수로 전달된 객체의 메서드는 호출 가능
        if (authorized) {
            System.start(); // 구성 요소 메서드 호출 가능
            updateDashBoardDisplay(); // 객체 내애 있는 메서드는 호출 가능
            doors.lock(); // 직접 생성하거나 인스턴스를 만든 객체의 메서드 호출 가능
        }
    }

    public void updateDashBoardDisplay() {
        // 디스플레이 갱신
    }
}
