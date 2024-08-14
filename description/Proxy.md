### 원격 프록시의 역할

- 프록시는 진짜 객체처럼 행동하지만, 실제로는 네트워크로 진짜 객체와 데이터를 주고받는다.
- 원격 프록시는 원격 객체의 로컬 대변자 역할을 한다.
- 로컬 대변자의 어떤 메서드를 호출하면 다른 원격 객체에게 그 메서드 호출을 전달해주는 객체를 로컬 대변자라고 한다.

<aside>
💡 클라이언트 객체는 원격 객체의 메서드 호출을 하는 것처럼 행동한다.
실제로는 로컬 힙에 들어있는 프록시 객체의 메서드를 호출한다.

</aside>

### 모니터링 코드에 원격 프록시 추가하기

```java
Duck d = <다른 힙에 있는 객체>
```

- 다음과 같은 방법으로 다른 힙에 들어있는 객체 레퍼런스를 가져올 수 없다.
- 변수 d가 어떤 객체를 참조하던, 그 객체는 선언문이 들어있는 코드와 같은 힙 공간에 있어야 한다.
- 그 부분에서 자바의 원격 메서드 호출(RMI, Remote Method, Invocation)이 쓰인다.

## 원격 메서드의 기초

- 통신을 처리해 주는 보조 객체가 필요하다.
- 보조 객체를 사용하면 클라이언트는 로컬 객체의 메서드만 호출하면 된다.
- 서버는 서비스 보조 객체(service helper)가 있어서, Socket 연결로 클라이언트 보조 객체로부터 요청을 받아 오고, 호출 정보를 해석해서 진짜 서비스 객체 있는 진짜 메서드를 호출한다.

## 자바 RMI의 개요

- RMI는 우리 대신 클라이언트와 서비스 보조 객체를 만들어준다.
- RMI에서 클라이언트 보조 객체는 스텁(stub), 서비스 보조 객체는 스켈레톤(skeleton)이라고 부른다.

### 원격 서비스 만들기

1. 원격 인터페이스 만들기

→ 원격 인터페이스는 클라이언트가 원격으로 호출할 메소드를 정의합니다. 클라이언트에서 이 인터페이스를 서비스의 클래스 형식으로 사용한다.

1. 서비스 구현 클래스 만들기

→ 실제 작업을 처리하는 클래스입니다.

1. RMI 레지스트리 실행하기

→ rmiregistery는 이 레지스트리로부터 프록시(스텁, 클라이언트 보조 객체)를 받아간다.

1. 원격 서비스 실행하기

→ 서비스 객체를 실행해야 한다. 서비스를 구현한 클래스에서 서비스의 인스턴스를 만들고, 그 인스턴스를 RMI 레지스트리에 등록한다.

### 1단계 원격 인터페이스 만들기

1. **java.rmi.Remote를 확장한다.**

```java
public interface MyRemote extends Remote {
```

1. 모든 메소드를 RemoteException을 던지도록 선언한다.

```java
import java.rmi.*;

public interface MyRemote extends Remote {
	public String sayHello() throws RemoteException;
}
```

1. 원격 메서드의 인자와 리턴값은 반드시 원시 형식(primitive) 또는 Serializable 형식으로 선언한다.

### 2단계 서비스 구현 클래스 만들기

1. 서비스 클래스에 원격 인터페이스를 구현한다.

```java
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	public String sayHello() {
		return "Server says, Hey";
	}
	// 기타 코드
}
```

1. UnicastRemoteObject를 확장한다.

```java
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	private static final long serialVersionId = 1L;
}
```

1. RemoteException을 선언하는 생성자를 구현한다.

```java
public MyRemoteImpl() throws RemoteException { }
```

1. 서비스를 RMI 레지스트리에 등록한다.

```java
try {
	MyRemote service = new MyRemoteImpl();
	Naming.rebind("RemoteHello", service);
} catch (Exception ex) {...}
```

### 프록시 패턴의 정의

<aside>
💡 프록시 패턴은 특정 객체로의 접근을 제어하는 대리인을 제공한다.

</aside>

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Proxy_pattern_diagram.svg/1200px-Proxy_pattern_diagram.svg.png)

### 원격 프록시와 가상 프록시 비교하기

- 원격 프록시

→ 원격 프록시는 다른 JVM에 들어있는 객체의 대리인에 해당하는 로컬 객체이다.

- 가상 프록시

→ 가상 프록시는 생성하는 데 많은 비용이 드는 객체를 대신합니다.

### 프록시 동물원 탐방하기

- 방화벽 프록시(Firewall Proxy)는 일련의 네트워크 자원으로의 접근을 제어함으로써, 주제를 나쁜 클라이언트로부터 보호한다.
- 스마트 레퍼런시 프록시는 주제가 참조될 때마다 추가 행동을 제공한다.
- 캐싱 프록시는 비용이 많이 드는 작업의 결과를 임시로 저장해준다.