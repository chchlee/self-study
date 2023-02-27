## 1. 지네릭스(Generics)
### 1.1 지네릭스란?
지네릭스는 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일시 타입 체크(type-time check)를 해주는 기능이다. 객체의 타입을 컴파일 시에 체크하기 때문에 객체의 타입 안정성을 높이고 형변환의 번거로움이 줄어든다.
타입 안정성을 높인다는 것은 의도하지 않은 타입의 객체가 저장되는 것을 막고, 저장된 객체를 꺼내올 때 원래의 타입과 다른 타입으로 형변환되어 발생할 수 있는 오류를 줄여준 다는 뜻이다.
예를 들어, ArrayList와 같은 컬렉션 클래스는 다양한 종류의 객체를 담을 수 있긴 하지만 보통 한 종류의 객체를 담는 경우가 더 많다. 그런데도 꺼낼 때 마다 타입 체크를 하는 것은 불편할 수 밖에 없다. 게다가 원하지 않은 종류의 객체가 포함되는 것을 막을 수 없다는 것을 막을 방법이 없다는 것도 문제다. 이러한 문제를 지네릭스가 해결해 준다.

### 1.2 지네릭 클래스의 선언
예를 들어, 클래스 Box가 다음과 같이 정의되어 있다고 가정하자.
```java
class Box{
    Object item;

    void setItem(Object item) { this.item = item; }
    Object getItem() { return item; }
}
```

이 클래스를 지네릭 클래스로 바꾼다고 하면 클래스 앞에 `<T>` 를 붙이기만 하면 된다.

```JAVA
class Box<T>{
    T item;

    void setItem(T item){this.item = item;}
    T getItem(){return this.item{}}
}
```

`Box<T>` 에서 T를 타입 변수라고 하며 'Type'의 첫 글자에서 따온 것이다. 타입 변수는 T가 아닌 다른 것을 사용해도 된다. `ArrayList<E>`의 경우, 타입 변수 E는 'Element'의 첫 글자 E를 따서 사용했다.  타입변수가 여러 개인 경우`Map<K, V>`의 경우 ','(콤마)를 구분자로 사용하면 된다.
이들은 기호와 종류만 다를 뿐 '임의의 참조형 타입'을 의미한다는 것은 같다.

기존에는 다양한 종류의 타입을 다루는 메서드의 매개변수나 리턴타입으로 Object 타입의 참조변수를 많이 사용했고, 그로 인해 형변환이 불가피 했지만, 이젠 Object 타입 대신 원하는 타입을 지정하기만 하면 되는 것이다.
이제 지네릭 클래스가 된 Box클래스의 객체를 생성할 때는 다음과 같이 참조변수의 생성자에 타입 T 대신에 사용될 실제 타입을 지정해 주어야만 한다.

```java
Box<String> box = new Box<String>(); // T대신 실제 타입을 지정
b.setItem(new Object()); // 에러. String 클래스 외에는 다른 타입 지정 불가
b.setItem("ABC"); // String 이므로 가능
String item =  b.getItem();
```

위의 코드에서 타입 T 대신에 String 타입을 지정해줬으므로, 지네릭 클래스`<T>` 는 다음에 정의된 것과 같다.

```java
class Box{
    String item;

    void setItem(String item){ this.item = item; }
    String getItem() { return item; }
}
```
#### 지네릭스의 용어
<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/221534876-d0f727a4-7cec-4d44-9e4b-7dcd21f06e01.png">
</div>

#### 지네릭스의 제한
지네릭 클래스 Box 의 객체를 생성할 때, 객체별로 다른 타입을 지정하는 것은 적절하다. 지네릭스는 이처럼 인스턴스별로 다르게 동작하려고 만든 기능이기 때문이다.

```java
Box<Apple> appleBox = new Box<Apple>();
Box<Grape> grapeBox = new Box<Grape>();
```

그러나 모든 객체에 대해 동일하게 동작해야하는 static 멤버에 타입 변수 T를 사용할 수는 없다. T는 인스턴스 변수로 간주되기 때문이다. staic 변수는 인스턴스변수를 참조할 수 없다.
```java
class Box<T>{
    static T item; // 에러
    static int compare(T a, T b) { ... } // 에러.
}
```

static 멤버는 타입 변수에 지정된 타입, 즉 대입된 타입의 종류에 관계없이 동일한 것이어야 하기 때문이다. 즉, `'Box<Apple>.item`과 `'Box<Grape>.item'`이 다른 것이어서는 안된다는 뜻이다. 그리고 지네릭 타입의 배열을 생성하는 것도 허용되지 않는다. 지네릭 배열의 참조변수를 선언하는 것은 가능하지만, `'new T[10]'`과 같이 배열을 생성하는 것은 안된다는 뜻이다.

```java
class Box<T> {
    T[] itemArr; // OK. T타입의 배열을 위한 참조변수
    ...
    T[] toArray() {
        T[] tmpArr = new T[itemArr.length]; // 에러. 지네릭 배열 생성 불가.
        ...
        return tmpArr;
    }
}
```

지네릭 배열을 생성할 수 없는 이유는 new 연산자 때문인데, 이 연산자는 컴파일 시점에 타입 T가 뭔지 정확히 알아야 한다. 그런데 위의 코드에 정의된 `Box<T>`클래스를 컴파일 하는 시점에서 T가 어떤 타입이 되는지 알 수 없기 때문이다. instanceof 연산자도 new 연산자와 같은 이유로 T를 피연산자로 사용할 수 없다.
꼭 지네릭 배열을 생성해야 할 필요가 있을 때는, new 연산자 대신 'Reflection API'의 newInstance()와 같이 동적으로 객체를 생성하는 메서드로 배열을 생성하거나, Object배열을 생성해서 복사한 다음에 T[]로 형변환 하는 방법 등을 사용한다.

### 1.3 지네릭 클래스의 객체 생성과 사용
지네릭 클래스의 `Box<T>`가 다음과 같이 정의되어 있다고 가정하자. 이 `Box<T>`의 객체에는 한 가지 종류, 즉 T의 타입의 객체만 저장할 수 있다. 전과 달리 ArrayList를 이용해서 여러 종류의 객체를 저장할 수 있도록 하였다.

```java
class Box<T>{
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    ArraList<T> getList() { return list; }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}
```

`Box<T>`의 객체를 생성할 때는 다음과 같이 한다. 참조변수와 생성자에 대입된 타입(매개변수화된 타입)이 일치해야 한다.

```java
Box<Apple> appleBox = new Box<Apple>(); // OK
Box<Apple> appleBox = new Box<Grape>(); // ERROR
```

두 타입이 상속 관계에 있어도 마찬가지이다. Apple이 Fruit의 자손 관계라고 가정하자.

```java
Box<Fruit> appleBox = new Box<Apple>(); // 에러. 대입된 타입이 다르다.
```

단, 두 지네릭 클래스의 타입이 상속관계에 있고, 대입된 타입이 같은 것은 괜찮다. FruitBox는 Box의 자손이라 가정하자.
```java
Box<Apple> appleBox = new FruitBox<Apple>(); // OK. 다형성
```

생성된 `Box<T>`의 객체에 `'void add(T item)'`으로 객체를 추가할 때, 대입된 타입과 다른 타입의 객체는 추가할 수 없다.
```java
Box<Apple> appleBox = new Box<Apple>();
appleBox.add(new Apple()); // OK.
appleBox.add(new Grape()); // ERROR. Box<Apple>에는 <Apple> 만 추가 가능
```

그러나 타입 T가 Fruit인 경우 'void add(Fruit item);'가 되므로 Fruit의 자손들은 이 메서드의 매개변수가 될 수 있다. Apple이 Fruit의 자손이라 가정하였다.
```java
Box<Fruit> fruitBox = new Box<Fruit>();
fruitBox.add(new Fruit());
fruitBox.add(new Apple());
```