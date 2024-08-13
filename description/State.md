- 상태 기계 역할을 하는 클래스를 만들기
- 각 행동을 구현할 때는 조건문을 써서 어떤 작업을 처리해야 할지 결정한다.
- 동전 투입 행동은 다음과 같은 메서드로 처리 가능하다.

```java
public void insertQuarter() {
	if (state == HAS_QUARTER) {
	} else if (state == NO_QUARTER) {
		state = HAS_QUARTER;
	} else if (state == SOLD_OUT) {
	} else if (state == SOLD) {
	}
}
```

### 새로운 디자인 구상하기

- 상태 객체들을 별도의 코드에 넣고, 어떤 행동이 일어나면 현재 상태 객체에서 필요한 작업을 처리하게 한다.

1. 모든 행동에 관한 메서드가 들어있는 State 인터페이스를 정의한다.
2. 모든 상태를 대상으로 상태 클래스를 구현한다.
3. 조건문을 모두 없애고 상태 클래스에 모든 작업을 위임한다.

![image.png](https://images.velog.io/images/y_dragonrise/post/b0cd2535-b0f8-4aa6-8fdc-7c1c164e89b2/image.png)

### State 클래스 구현하기

```java
public class NoQuarterState implements State {
	
	GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	public void insertQuarter() {
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
} 
```

### 뽑기 기계 코드 수정하기

```java
public class GumballMachine {
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	
	State state = soldOutState;
	int count = 0;
}
```

- 정적 정수 변수를 사용하던 코드를 새로 만든 클래스를 사용하는 방식으로 수정한다.
- 정수가 아닌 상태 객체가 저장된다.

### 뽑기 기계 구조 다시 살펴보기

- 각 상태의 행동을 별도의 클래스로 국지화 한다.
- if 선언문들을 없앤다.
- 각 상태를 변경에는 닫혀 있게 했고, 새로운 상태 클래스를 추가하는 확장에 열려 있도록 고친다(OCP)
- 더 이해하기 좋은 코드 베이스와 클래스 구조를 만든다.

### 상태 패턴의 정의

<aside>
💡 상태 패턴(State Pattern)을 사용하면 객체 내부 상태가 바뀜에 따라서 객체의 행동을 바꿀 수 있다. 객체의 클래스가 바뀌는 것과 같은 결과를 얻을 수 있다.

</aside>

### 상태 패턴 vs 전략 패턴

- 상태 패턴을 사용할 때는 일련의 행동이 캡슐화 된다. 클라이언트는 상태의 객체를 몰라도 된다.
- 전략 패턴을 사용할 때는 클라이언트가 Context 객체에게 어떤 전략 객체를 사용할지를 지정한다.
- 전략 패턴은 서브클래스를 만드는 방법을 대신해서 유연성을 극대화 한다.

### 정상성 점검하기

- 정상성 점검(sanity check)
- 중복되어 있는 코드가 꽤 많은 클래스는 추상 클래스로 만들고, 몇 가지 기본 기능을 추가한다.
- GumballMachine 객체의 인스턴스를 여러 개 만들게 되면 상태 인스턴스를 정적 인스턴스 변수로 만들어서 공유한다.