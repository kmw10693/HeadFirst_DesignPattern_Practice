### 반복을 캡슐화하기

- 바뀌는 부분을 캡슐화 하라.
- 메뉴에서 리턴하는 객체 컬렉션의 형식이 다를때, 반복 작업을 캡슐화 해보자.

1. breakfastItems의 각 항목에 순환문을 돌릴 때는 ArrayList의 size()와 get() 메소드를 사용한다.

```java
for (int i = 0; i < breakfastItems.size(); i++) {
	MenuItem menuitem = breakfastItems.get(i);
}
```

1. lunchItems에 순환문을 돌릴 때는 배열의 length 필드와 배열 첨자를 사용한다.

```java
for (int i=0; i<lunchItems.length; i++) {
	MenuItem menuItem = lunchItems[i];
}
```

1. 객체 컬렉션의 반복 작업 처리 방법을 캡슐화한 Iterator라는 객체를 만들어 ArrayList에 적용한다.

```java
Iterator iterator = breakfastMenu.createIterator();

while (iterator.hasNext()) {
	MenuItem menuItem = iterator.next();
```

1. 배열에도 적용한다.

```java
Iterator iterator = lunchMenu.createIterator();

while (iterator.hasNext()) {
	MenuItem menuItem = iterator.next();
}
```

### 반복자 패턴

- 반복자(iterator) 패턴이라고 부른다.
- iterator 인터페이스가 있으면 배열, 리스트, 해시테이블은 물론 모든 종류의 객체 컬렉션에 반복자를 구현 가능하다.

### 배열에 반복자 추가하기

- Iterator 인터페이스 추가하기

```java
public interface Iterator {
	boolean hasNext();
	MenuItem next();
}
```

- 구상 Iterator 클래스를 만든다.

```java
public class DinerMenuIterator implements Iterator {
	MenuItem[] items;
	int position = 0;
	
	public DinerMenuIterator(MenuItem[] items) {
		this.items = items;
	}
	
	public MenuItem next() {
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}
	
	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}
}

```

- DinerMenu 클래스에서 반복자를 사용하자.

```java
public class DinerMenu {
	static final int MAX_ITEMS = 6;
	int memberOfItems = 0;
	MenuItem[] menuItems;
	
	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}
}
```

### 반복자 패턴의 정의

- 반복자 패턴은 컬렉션의 구현 방법을 노출하지 않으면서 집합체 내의 모든 항목에 접근하는 방법을 제공한다.

![Untitled](data:image/png;base64,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)

- Aggregate 인터페이스 → 클라이언트와 객체 컬렉션의 구현이 분리된다.
- concreteAggregate → 객체 컬렉션이 들어있으며, 그 안에 들어있는 컬렉션을 Iterator로 리턴하는 메서드를 구현한다.
- concreteIterator는 반복 작업 중에 현재 위치를 관리하는 일을 맡고 있다.
- Iterator는 모든 반복자가 구현해야 하는 인터페이스를 제공한다. 컬렉션에 들어있는 원소에 돌아가면서 접근할 수 있게 해주는 메소드를 제공한다.

### 단일 역할 원칙

- 하나의 클래스는 하나의 역할만 맡아야 한다.
- 응집도란 한 클래스 또는 모듈이 특정 목적이나 역할을 얼마나 일관되게 지원하는지를 나타내는 척도이다.

### 향상된 for 순환문 알아보기

- Iterable 인터페이스를 구현하는 클래스 객체

```java
List<MenuItem> menuItems = new ArrayList<MenuItem>();
```

- ArrayList의 원소를 대상으로 반복 작업을 수행 가능하다.

```java
Iterator iterator = menu.iterator();
while (iterator.hasNext()) {
	MenuItem menuItem = iterator.next();
}
```

- ArrayList도 iterable이므로, 자바의 향상된 for 순환문을 사용 가능하다.

```java
for (MenuItem item: menu) {
}
```

### 해시 테이블을 반복자 패턴으로 바꾸기

```java
public class CafeMenu implements Menu {
	Map<String, MenuItem> menuItems = new HashMap<String, MenuItem>();
	
	public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}
}
```