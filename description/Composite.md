### 컴포지트 패턴의 정의

- 객체를 트리구조로 구성해서 부분-전체 계층구조를 구현한다. 컴포지트 패턴을 사용하면 클라이언트에서 개별 객체와 복합 객체를 똑같은 방법으로 다룰수 있다.

### 컴포지트 패턴 구조

![Untitled](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThug9mUE7_jpiFN2ker8sg1LZ-gzqRlGB5Lw&s)

- MenuComponent 추상 클래스

```java
public abstract class MenuComponent {
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	
	public void print() {
		throw new UnsupportedOperationException();
	}
	...
}
```

- 메뉴 항목 구현하기

```java
public class MenuItem extends MenuComponent {
	String name;
	String description;
	
	public void print() {
		System.out.println(" " + getName());
	}
}
```

- 메뉴 구현하기

```java
public class Menu extends MenuComponent {
	List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
```

- 클라이언트 코드에 컴포지트 적용하기

```java
public class Waitress {
	MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
	
	public void printMenu() {
		allMenus.print();
	}
}
	
```