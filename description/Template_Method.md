- 템플릿 메서드 패턴(Template Method Pattern)은 알고리즘의 일부 단계를 서브클래스에서 구현할 수 있으며, 알고리즘의 구조는 그대로 유지하면서 알고리즘의 특정 단계를 서브클래스에서 재정의 가능하다.
- 알고리즘의 골격을 정의한다. 템플릿 메서드를 사용하면 알고리즘의 일부 단계를 서브클래스에서 구현할 수 있다.

### 템플릿 메서드 틀

```java
abstract Class AbstractClass {
	final void templateMethod() {
		primitiveOperation1();
		primitiveOperation2();
		concreteOperation();
		hook();
	}
	
	abstract void primitiveOperation1();
	
	abstract void primitiveOperation2();
	
	void concreteOperation() {
		concreteOperation()
	}
	
	void hook() {}
}

```

### 템플릿 메서드 속 후크

- 추상 클래스에서 선언되지만, 기본적인 내용만 구현되어 있거나 아무 코드도 들어있지 않은 메소드이다.
- 후크를 사용하려면 서브클래스에서 후크를 오버라이드해야 한다.

```java
public abstract class CaffeineBeverageWithHook {
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments()) {
			addCondiments();
		}
	}
	
	// 이 메서드는 서브클래스에서 필요할 때 오버라이드할 수 있는 메서드이므로 후크이다.
	boolean customerWantsCondiments() {
		return true;
	}
}
```

### 할리우드 원칙

- 먼저 연락하지 마세요. 저희가 연락 드리겠습니다.
- 의존성 부패(dependency rot)를 방지할 수 있다. (고수준 구성 요소가 저수준 구성 요소에 의존하고, 그 저수준 구성 요소는 다시 고수준 구성 요소에 의존 하는 것)

<aside>
💡 CaffeineBeverage → 고수준 구성 요소는 메서드 구현이 필요한 상황에만 서브 클래스를 불러낸다.
- prepareRecipe()
- boilWater()
- brew()
- addCondiments()

Coffee → 서브클래스는 자질구레한 메서드 구현을 제공하는 용도만 사용 / 호출 당하기 전까지 추상 클래스를 호출하지 않는다.
- brew()
- addCondiments()

</aside>

### 템플릿 메서드로 정렬하는 방법(자바의 Arrays)

```java
public static void sort(Object[] a) {
	Object aux[] = (Object[])a.clone();
	mergeSort(aux, a, 0, a.length, 0);
}

private static void mergeSort(Object src[], Object dest[], int low, int high, int off) {
	for(int i=low; i<high; i++){
		// 템플릿 메서드를 완성하려면 CompareTo() 메서드를 구현해야 한다.	
		for(int j=i; j>low; && ((Comparable)dest[j-1]).compareTo((Comparable)dest[j]>0; j--)
		{
			swap(dest, j, j-1); // Array 클래스에 이미 정의되어 있는 구상 메서드
		}
	}
}
```

### 오리 정렬하기

- compareTo()
    
    두 객체를 비교해서 그 대소 관계를 리턴하는 메서드이다. sort() 메서드에서 그 결과를 사용해서 배열을 정리한다.
    

```java
public Class Duck implements Comparable<Duck> {
	String name;
	int weight;
	
	public int compareTo(Duck otherDuck) {
		if (this.weight < otherDuck.weight) return -1;
		else if (this.weight == otherDuck.weight) return 0;
		else return 1;
	}
```

### 템플릿 메서드가 적용된 정렬

1. Duck 배열이 필요하다.

```java
Duck[] ducks = {new Duck("Daffy", 8), ... };
```

1. Arrays 클래스에 있는 sort() 템플릿 메서드 호출

```java
Arrays.sort(ducks);
```

1. sort() 메서드는 두 오리 객체를 비교할 때 compareTo() 메서드에 의존한다.

```java
ducks[0].compareTo(ducks[1]);
```

1. Arrays에 들어있는 swap() 구상 메서드를 써서 두 오리 객체를 맞바꾼다.

```java
swap()
```

### 템플릿 메서드로 그래픽 출력하기 (JFrame)

- paint()를 오버라이드하면 특정 화면 영역에 특정 내용을 표시하는 JFrame의 알고리즘에 사용자가 원하는 그래픽을 추가 가능하다.

```java
public class MyFrame extends JFrame {
	
	//... 초기화 생략
	
	// paint()는 후크 메서드이고, paint()를 오버라이드해서 메시지를 그린다.
	public void paint(Graphics graphics) {
		super.paint(graphics);
		String msg = "내가 최고!";
		graphics.drawString(msg, 100, 100);
	}
}
```

### AbstractList로 나만의 리스트 만들기

- ArrayList, LinkedList 자바 리스트 컬렉션은 AbstractList 클래스를 확장한다.
- AbstractList에는 get()과 size() 추상 메서드에 의존하는 subList() 템플릿 메서드가 있다. 나만의 리스트를 만들때, 이 두개의 메서드를 구현해야 한다.

```java
public class MyStringList extends AbstractList<String> {
	//... 생성자 생략
	
	public String get(int index) {
		return myList[index];
	}
	public int size() {
		return myList.length;
	}
}
```