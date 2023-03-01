## 1. 지네릭스(Generics)
cla
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

단, 두 지네릭 클래스가 상속관계에 있고, 대입된 타입이 같은 것은 괜찮다. FruitBox는 Box의 자손이라 가정하자.
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

### 1.4 제한된 지네릭 클래스
타입 문자로 사용할 타입을 명시하면 한 종류의 타입만 저장할 수 있도록 제한할 수 있지만, 그래도 여전히 모든 종류의 타입을 지정할 수 있다는 것에는 변함이 없다.

```java
FruitBox<Toy> fruitBox = new FruitBox<Toy>();
fruitBox.add(new Toy()); // OK. 과일 상자에 장난감을 담을 수 있다.
```

다음과 같이 지네릭 타입에 'extends'를 사용하면, 특정 타입의 자손들만 대입할 수 있게 제한할 수 있다.

```java
class FruitBox<T extends Fruit> { // Fruit의 자손만 타입으로 지정가능
    ArrayList<T> list = new ArrayList<T>();
    ...
}
```

게다가 add()의 매개변수의 타입 T도 Fruit와 그 자손 타입이 될 수 있으므로, 아래와 같이 여러 과일을 담을 수 있는 상자가 가능하게 된다.
```java
FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
fruitBox.add(new Apple()); // OK Apple이 Fruit의 자손
fruitBox.add(new Grape()); // OK Grape는 Fruit의 자손
```

다형성에서 조상타입의 참조변수로 자손타입의 객체를 가리킬 수 있는 것처럼, 매개변수화된 타입의 자손 타입도 가능한 것이다. 타입 매개변수 T에 Object를 대입하면, 모든 종류의 객체를 저장할 수 있게 된다.
만일 클래스가 아니라 인터페이스를 구현해야 한다는 제약이 필요하다면, 이때도 'extends'를 사용한다. 'implements'를 사용하지 않는 다는 점에 주의하자.

```java
Interface Eatable {}
class FruitBox<T extends Eatable> { ... }
```

클래스 Fruit의 자손이면서 Eatable인터페이스도 구현해야 한다면 아래와 같이 '&'기호로 연결한다.
```java
class FruitBox<T extends Fruit & Eatable> { ... }
```

### 1.5 와일드 카드
매개변수에 과일박스를 대입하면 주스를 만들어서 반환하는 Juicer라는 클래스가 있고, 이 클래스에는 과일을 주스로 만들어서 반환하는 makeJuice()라는 static 메서드가 다음과 같이 정의되어 있다고 가정하자.

```java
class Juicer {
    static Juice makeJuice(FruitBox<Fruit> box){
        String tmp = "";
        for(Fruit f : box.getList())
            tmp += f + " ";
        return new Juice(tmp);
    }
}
```

Juicer 클래스는 지네릭 클래스가 아닌데다, 지네릭 클래스라고 해도 static 메서드에는 타입 매개변수 T를 매개변수에 사용할 수 없으므로 아예 지네릭스를 적용하지 않던가, 위와 같이 타입 매개변수 대신, 특정 타입을 지정해줘야 한다.

```java
FruitBox<Fruit> fruitBox = new FruitBox<Fruit>;
FruitBox<Apple> appleBox = new FruitBox<Apple>;
...
System.out.println(Juicer.makeJuice(fruitBox));
System.out.println(Juicer.makeJuice(appleBox)); // 에러 FruitBox<Apple>
```

이렇게 지네릭 타입을 'FruitBox<Fruit>'로 고정해 놓으면, 위의 코드에서 알 수 있듯이 'FruitBox<Apple>'타입의 객체는 makeJuice()의 매개변수가 될 수 없으므로, 여러 가지 타입의 매개변수를 갖는 makeJuice()를 만들 수 밖에 없다.(오버로딩 할 수 밖에 없다.)
그러나 오버로딩 시 컴파일 에러가 발생할 것이다. 지네릭 타입이 다른 것만으로는 오버로딩이 성립하지 않기 때문이다. 지네릭 타입은 컴파일러가 컴파일 할 때만 사용하고 제거해 버린다. 그래서 오버로딩이 아니라 메서드 중복 정의가 되어버린다.
이럴 때 사용하기 위해 고안된 것이 바로 '와일드 카드'이다. 와일드 카드는 기호 '?'로 표현하는데, 와일드 카드는 어떠한 타입도 될 수 있다.
'?'만으로는 Object 타입과 다를 게 없으므로, 다음과 같이 'extends'와 'super'로 상한 (upper bound)과 하한(lower bound)을 제한 할 수 있다.

```java
<? extends T> 와일드 카드의 상한 제한. T와 그 자손들만 가능
<? super T> 와일드 카드의 하한 제한. T와 그 조상들만 가능
<?> 제한 없음. 모든 타입이 가능. <? extends Object>와 동일
```

와일드 카드를 사용해 매개변수 타입을 변환하면 다음과 같아진다.
```java
class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit> box){
        String tmp = "";
        for(Fruit f : box.getList())
            tmp += f + " ";
        return new Juice(tmp);
    }
}

Fruit<Fruit> fruitBox = new FruitBox<Fruit>();
Fruit<Apple> appleBox = new FruitBox<Apple>();

System.out.println(Juicer.makeJuice(fruitBox)); // OK. FruitBox<Fruit>
System.out.println(Juicer.makeJuice(appleBox)); // OK. appleBox<Fruit>
```

### 1.6 지네릭 메서드
메서드의 선언부에 지네릭 타입이 선언된 메서드를 지네릭 메서드라 한다. Collections.sort()가 바로 지네릭 메서드이며, 지네릭 타입의 선언 위치는 반환 타입의 바로 앞이다.
`static <T> void sort(List<T> list, Comparator<? super T> c)`
지네릭 클래스에 정의된 타입 매개변수와 지네릭 메서드에 정의된 타입 매개변수는 전혀 별개의 것이다. 같은 타입 문자 T를 사용해도 같은 것이 아니라는 것에 주의해야 했다.
```java
class FruitBox<T> {
        ...
    static <T> void sort(List<T> list, Comparator<? super T> c){
        ...
    }
}
```
위의 코드에서 지네릭 클래스 FruitBox에 선언된 타입 매개변수 T와 지네릭 메서드 sort()에 선언된 타입 매개변수 T는 타입 문자만 같을 뿐 서로 다른 것이다. static 멤버에는 타입 매개변수를 사용할 수 없지만, 이처럼 메서드에 지네릭 타입을 선언하고 사용하는 것은 가능하다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/221922735-e7c05e33-5f53-4a8d-a140-f4f0e0b680bd.png">
</div>

이제 이 메서드를 호출할 때는 아래와 같이 타입 변수에 타입을 대입해야 한다.
```java
FruitBox<Fruit> fruitBox = new FruitBox<Fruit>;
FruitBox<Apple> appleBox = new FruitBox<Apple>;
...
System.out.println(Juicer.<Fruit>makeJuice(fruitBox));
System.out.println(Juicer.<Apple>makeJuice(appleBox));
```

그러나 대부분의 경우 컴파일러가 타입을 추정할 수 있기 때문에 생략해도 된다.

지네릭 메서드는 매개변수의 타입이 복잡할 때도 유용하다. 만일 아래와 같은 코드가 있다면 타입을 별도로 선언함으로써 코드를 간략화 할 수 있다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/221923565-cd7d2c7e-9234-48b6-bdc5-bdacc82e3724.png">
</div>

### 1.7 지네릭 타입의 형변환
지네릭 타입과 원시 타입(raw type)간의 형변환이 가능할까?
```java
Box box = null;
Box<Object> objBox = null;

box = (Box)objBox; // OK. 지네릭 타입 -> 원시 타입. 경고 발생.
objBox = (Box<Object>)box; // OK. 원시 타입 -> 지네릭 타입. 경고 발생.
```
지네릭 타입과 넌지네릭(non-generic) 타입간의 형변환은 항상 가능하다.


```java
Box<? extends Object> wBox = new Box<String>(); // 형변환 가능.
```

----
### 참고 Optional 클래스
### java.util.Optional<T> 클래스
Optional<T> 클래스는 Integer나 Double 클래스처럼 'T' 타입의 객체를 포장해 주는 래퍼 클래스(Wrapper class)이다.
이러한 Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 제공하는 메소드로 간단히 회피할 수 있다.
즉, 복잡한 조건문 없이도 널(null) 값으로 인해 발생하는 예외를 처리할 수 있게 된다.

### Optional 객체의 생성
of() 메소드나 ofNullable() 메소드를 사용해서 Optional 객체를 생성할 수 있다.
of() 메소드는 null이 아닌 명시된 값을 가지는 Optional 객체를 반환한다.

따라서 만약 참조 변수의 값이 만에 하나 null이 될 가능성이 있다면, ofNullable() 메소드를 사용하여 Optional 객체를 생성하는 것이 좋다. ofNullable() 메소드는 명시된 값이 null이 아니면 명시된 값을 가지는 Optional 객체를 반환하며, 명시된 값이 null이면 비어있는 Optional 객체를 반환한다.

```java
Optional<String> opt = Optional.ofNullable("자바 Optional 객체");
System.out.println(opt.get());
```
----

```java
Optional<?> EMPTY = new Optional<>();
-> Optional<? extends Object> EMPTY = new Optional<>();
-> Optional<? extends Object> EMPTY = new Optional<Object>();

```

```java
Optional<?> wopt = new Optional<Object>();
Optional<Object> oopt = new Optional<Object>();

Optional<String> sopt = (Optional<String>)wopt; // OK. 형변환 가능
Optional<String> sopt = (Optional<String>)oopt; // 에러. 형변환 불가
```

### 1.8 컴파일 타입의 제거
컴파일러는 지네릭 타입을 이용해서 소스파일을 체크하고, 필요한 곳에 형변환을 넣어준다. 그리고 지네릭 타입을 제거한다. 즉, 컴파일된 파일(*.class)에는 지네릭 타입에 대한 정보가 없는 것이다.
이렇게 하는 주된 이유는 지네릭이 도입되기 전 소스 코드와의 호환성을 유지하기 위해서이다.
앞으로 가능하면 원시타입을 사용하지 않도록 하자. 언젠가는 분명히 새로운 기능을 위해 하위 호환성을 포기하게 될 때가 올 것이기 떄문이다.


## 2. 열거형
### 2.1 열거형이란?
서로 연관된 상수들의 집합을 의미한다.
열거형은 서로 관련된 상수를 편리하게 선언하기 위한 것으로 여러 상수를 정의할 때 사용하면 유용하다.

```java
class Card{
    static final int CLOVER = 0;
    static final int HEART = 1;
    static final int DIAMOND = 2;
    static final int SPADE = 3;

    static final int TWO = 0;
    static final int THREE = 1;
    static final int FOUR = 2;

    final int kind;
    final int num;
}
```
은 아래 열거형을 사용한 코드와 같다.
```java
class Card {
    enum Kind { CLOVER, HEART, DIAMOND, SPADE }
    enum VALUE { TWO, THREE, FOUR }

    final Kind kind; // 타입이 int가 아닌 Kind임에 유의
    final Value value;
}
```

자바의 열거형은 타입에 안전한 열거형이라 실제 값이 같아도 타입이 다르면 컴파일 에러가 발생한다.
이처럼 값뿐만 아니라 타입까지 체크하기 때문에 타입에 안전하다고 하는 것이다.

## 2.2 열거형의 정의와 사용
```java
enum 열거형이름 { 상수명1, 상수명2, ... }
```

예를 들어 동서남북 4방향을 상수로 정의하는 열거형 Direction은 다음과 같다.
```java
enum Direction { EAST, SOUTH, WEST, NORTH }
```

이 열거형에 정의된 상수를 사용하는 방법은 '열거형이름.상수명'이다. 클래스의 static 변수를 참조하는 것과 동일하다.
```java
class Unit {
    int x, y;
    Direction dir;

    void init() {
        dir = Direction.EAST;
    }
}
```

열거형의 상수간의 비교에는 '=='를 사용할 수 있다. equals()가 아닌 '=='로 비교가 가능하다는 것은 그만큼 빠른 성능을 제공한다는 얘기다. 그러나 '<' , '>' 와 같은 비교연산자는 사용할 수 없고 compareTo()는 사용가능하다.

```java
if(dir==Direction.EAST) {
    x++;
} else if (dir > Direction.WEST) {
    ...
} else if (dir.compareTo(Direction.WEST) > 0){
    ...
}
```

다음과 같이 switch 문의 조건식에도 열거형을 사용할 수 있다.

```java
void move() {
    switch(dir){
        case EAST: // Direction.EAST라 쓰면 안된다.
            x++;
            break;
        case WEST:
            x--;
            break;
        case SOUTH:
            y++;
            break;
        case NORTH:
            y--;
            break;
    }
}
```

### 2.3 열거형에 멤버 추가하기
열거형 상수의 값이 불연속적인 경우에는 이때는 다음과 같이 열거형 상수의 이름 옆에 원하는 값을 괄호()와 함께 적어주면 된다.

```java
enum Direction { EAST(1), SOUTH(5), WEST(-1), NORTH(10) }
```
그리고 지정된 값을 저장할 수 있는 인스턴스 변수와 생성자를 새로 추가해 주어야 한다.
이 때 주의할 점은, 먼저 열거형 상수를 모두 정의한 다음에 다른 멤버들을 추가해야 한다는 것이다. 그리고 열거형 상수의 마지막에 ';'도 잊지 말아야 한다.

```java
enum Direction {
    EAST(1), SOUTH(5), WEST(-1), NORTH(10)

    private final int value;
    Direction(int value) { this.value = value; }

    public int getValue() { return value; }
    }
```

열거형의 인스턴스 변수는 반드시 final 이어야 한다는 제약은 없지만, value는 열거형 상수의 값을 저장하기 위한 것이므로 final을 붙였다.

```java
Direction d = new Direction(1); // 에러 열거형의 생성자는 외부에서 호출불가
```

필요하다면, 다음과 같이 하나의 열거형 상수에 여러 값을 지정할 수도 있다. 다만 그에 맞게 인스턴스 변수와 생성자 등을 새로 추가해줘야 한다.

### 2.4 열거형의 이해
만일 열거형 Direction이 다음과 같이 정의되어 있을 때,
```java
enum Direction { EAST, SOUTH, WEST, NORTH }
```

열거형 상수 하나하나가 Direction 객체이다.

```java
class Direction{
    static final Direction EAST = new Direction("EAST");
    static final Direction SOUTH = new Direction("SOUTH");
    static final Direction WEST = new Direction("WEST");
    static final Direction NORTH = new Direction("NORTH");

    private String name;

    private Direction(String name{
        this.name = name;
    }
}
```

Direction 클래스의 static 상수 EAST, SOUTH, WEST , NORTH의 값은 객체의 주소이고, 이 값은 바뀌지 않는 값이므로 '=='로 비교가 가능한 것이다.

모든 열거형은 추상클래스 Enum의 자손이므로, Enum을 흉내 내어 MyEnum을 작성하면 다음과 같다.
```java
abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    static int id = 0; // 객체에 붙일 일련번호

    int ordinal;
    String name = "";

    public int ordinal() { return ordinal; }

    MyEnum(String name) {
        this.name = name;
        ordinal = id++;
    }

    public int compareTo(T t) {
        return ordinal - t.ordinal();
    }
}
```

## 3. 애너테이션(annotation)
### 3.1 애너테이션
주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보를 제공하는 것.
<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/222185014-51b729a4-e489-4f7d-9f6d-592f136930d1.png">
</div>