1. **전략 패턴(Strategy Pattern)** 은 알고리즘군을 정의하고, 캡슐화해서 각각의 알고리즘군을 수정해서 쓸 수 있게 해 줍니다. 전략 패턴을 사용하면 클라이언트로부터 알고리즘을 분리해서 독립적으로 변경할 수 있습니다.
2. **옵저버 패턴(Observer Pattern)** 은 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체에게 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many) 의존성을 정의합니다.

**[옵저버 패턴]**

- 주제는 옵저버들이 Observer 인터페이스를 구현한다는 것을 제외하면 옵저버에 대해 전혀 모른다. (느슨한 결합)
- 옵저버 패턴은 옵저버가 데이터를 가져오는(풀 방식)을 활용하자.
- 출판-구독 패턴과 친척이다.

**[객체지향 원칙]**

- 바뀌는 부분은 캡슐화한다.
- 상속보다는 구성을 활용한다.
- 구현보다는 인터페이스에 맞춰서 프로그래밍한다.
- 상호작용하는 객체 사이에서는 가능하면 느슨한 결합을 사용해야 한다.
