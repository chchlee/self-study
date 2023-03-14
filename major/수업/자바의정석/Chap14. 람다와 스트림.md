## 1. 람다식

### 1.1 람다식이란?
람다식(Lambda Expression)은 간단히 말해서 메서드를 하나의 식(expression)으로 표현한 것이다. 람다식은 함수를 간략하면서도 명확한 식으로 표현할 수 있게 해준다.
메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로, 람다식을 '익명 함수(anonymous funciton)'이라고도 한다.

```java
int[] arr = new int[5];
Arrays.setAll(arr, (i) -> (int) (Math.random() * 5) +1 );
```

이 람다식이 하는 일을 메서드로 표현하면 다음과 같다.
```java
int method() {
    return (int) (Math.random() * 5) + 1;
}
```

모든 메서드는 클래스에 포함되어야 하므로 클래스도 새로 만들어야 하고, 객체도 생성해야만 비로소 이 메서드를 호출할 수 있다.
게다가 람다식은 메서드의 매개변수로 전달되어지는 것이 가능하고, 메서드의 결과로 반환될 수 있다. 람다식으로 인해 메서드를 변수처럼 다루는 것이 가능해진 것이다.

### 1.2 람다식 저장하기

람다식은 '익명 함수' 답게 메서드에서 이름과 반환타입을 제거하고 매개변수 선언부와 몸통{} 사이에 `->`를 추가한다.

```java
반환타입 메서드이름(매개변수 선언) {
    문장들
}

(매개변수 선언) -> {
    문장들
}
```

반환 값이 있는 메서드의 경우, return 대신 '식(expression)'으로 대신할 수 있다. 식의 연산결과가 자동적으로 반환 값이 된다. 이때는 문장이 아닌 식이므로 끝에 ';'를 붙이지 않는다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/224745356-c4ea0d45-a043-4528-b8f0-2fadc076dee7.png">
</div>

람다식에 선언된 매개변수의 타입은 추론이 가능한 경우는 생략할 수 있는데, 대부분의 경우에 생략가능하다. 람다식에 반환타입이 없는 이유도 항상 추론이 가능하기 때문이다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/224745397-a13cde32-a9f0-4aa9-bfd2-ae9421b92ff1.png">
</div>

아래와 같이 선언된 매개변수가 하나뿐인 경우에는 괄호()를 생략할 수 있다. 단, 매개변수의 타입이 있으면 괄호()를 생략할 수 없다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/224749322-0d383c7b-1735-463e-bb88-b6c6650facea.png">
</div>

마찬가지로 괄호{} 안의 문장이 하나일 때는 괄호{}를 생략할 수 있다. 이 때 문장의 끝에 ';'을 붙이지 않아야 한다는 것에 주의하자.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/224749359-1bd37773-c0fe-44b1-b35c-26574f412451.png">
</div>

#### 확인해보기

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/224750107-efdd9c3e-6ff1-430c-8b9b-3958b5f62a09.png">
</div>

### 1.3 함수형 인터페이스(Funtional Interface)

자바에서 모든 메서드는 클래스 내에 포함되어야 하는데, 람다식은 어떤 클래스에 포함되는 것일까? 지금까지 람다식이 메서드와 동등한 것처럼 표현되었지만, 사실 람다식은 익명 클래스의 객체와 동등하다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/224751518-4ac65b0c-ef41-4189-8a17-1b7313fb8c26.png">
</div>

참조변수가 있어야 객체의 메서드를 호출 할 수 있기 때문에 우선 이 익명 객체의 주소를 f라는 참조변수에 저장해 보자.

```java
타입 f = (int a, int b) -> a > b ? a : b;
```

참조변수 f의 타입은 어떤 것이어야 할까? 참조형이기 때문에 클래스 또는 인터페이스가 가능하다.

```java
interface MyFunction {
    public abstract int max(int a, int b);
}
```

그러면 이 인터페이스를 구현한 익명 클래스의 객체는 다음과 같이 생성할 수 있다.

```java
MyFunction f = new MyFunction() {
    public int max(int a, int b) {
        return a > b ? a : b;
    }
}

int big = f.max(5, 3);
```

MyFunction 인터페이스에 정의된 메서드 max() 는 람다식 '(int a, int b) -> a > b ? a : b'과 메서드의 선언부가 일치한다. 그래서 익명 객체를 람다식으로 아래와 같이 대체할 수 있다.

```java
MyFunction f = (int a, int b) -> a > b ? a : b;
int big = f.max(5, 3);
```

이처럼 MyFunction 인터페이스를 구현한 익명 객체를 람다식으로 대체 가능한 이유는, 람다식도 실제로는 익명 객체이고, MyFunction인터페이스를 구현한 익명 객체의 메서드 max()와 람다식의 매개변수 타입과 개수 그리고 반환값이 일치하기 때문이다.

그래서 인터페이스를 통해 람다식을 다루기로 결정되었으며, 람다식을 다루기 위한 인터페이스를 '함수형 인터페이스(functional interface)'라 부르기로 했다.

```java
@FunctionalInterface
interface MyFunction {
    public abstract int max(int a, int b);
}
```

단, 함수형 인터페이스에는 오직 하나의 추상 메서드만 정의되어 있어야 한다는 제약이 있다. 그래야 람다식과 인터페이스의 메서드가 1:1로 연결될 수 있기 때문이다. 반면에 static 메서드와 default 메서드의 개수에는 제약이 없다.

```java
List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
Collections.sort(list, new Comparator<String> {
    public int compare(String s1, String s2){
        return s2.compareTo(s1);
    }
});
```

이제 람다식을 간단히 표현할 수 있게 되었다.

```java
List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
```

#### 함수형 인터페이스 타입의 매개변수와 반환 타입

함수형 인터페이스 MyFunction이 아래와 같이 정의되어 있을 때

```java
@FunctionalInterface
interface MyFunction {
    void myMethod();
}
```

메서드의 매개변수 타입이 MyFunction일 때, 이 메서드를 호출할 때 람다식을 참조하는 참조변수를 매개변수로 지정해야 한다는 뜻이다.

```java
void aMethod(MyFunction f){
    f.myFunciton();
}
...

MyFunction f = () -> System.out.println("myMethod()");
aMethod(f);
```

또는 참조변수 없이 아래와 같이 직접 람다식을 매개변수로 지정하는 것도 가능하다.

```java
aMethod(() -> System.out.println("myMethod()"));
```

그리고 메서드의 반환 타입이 함수형 인터페이스 타입이라면, 이 함수형 인터페이스의 추상메서드와 동등한 람다식을 가리키는 참조변수를 반환하거나 람다식을 직접 반환할 수 있다.

```java
MyFunction myMethod() {
    MyFunction f = () -> ();
    return f;
}
```

#### 람다식의 타입과 형변환

함수형 인터페이스로 람다식을 참조할 수 있는 것일 뿐, 람다식의 타입이 항상 함수형 인터페이스의 타입과 일치하는 것은 아니다. 람다식은 익명 객체이고 익명 객체에는 타입이 없다. 정확히는 타입은 있지만 컴파일러가 임의로 타입을 정하는 것이기 때문에 알 수 없는 것이다. 그래서 대입 연산자의 양변의 타입을 일치 시키기 위해 아래와 같은 형변환이 필요하다.

```java
MyFunction f = (MyFunction) (() -> {}); // 양변의 타입이 다르므로 형변환이 필요
```

람다식은 MyFunction 인터페이스를 직접 구현하지는 않았지만, 이 인터페이스를 구현한 클래스의 객체와 완전히 동일하기 때문에 위와 같은 형변환을 허용한다. 그리고 이 형변환은 생략 가능하다.
람다식은 이름이 없을 뿐 분명히 객체인데도, 아래와 같이 Object타입으로 형변환 할 수 없다. 람다식은 오직 함수형 인터페이스로만 형변환이 가능하다.

```java
Object obj = (Object) (() -> {});
```

### 1.4 java.util.function 패키지

대부분의 메서드는 타입이 비슷하다. 매개변수가 없거나 한 개 또는 두 개, 반환 값은 없거나 한 개. 게다가 지네릭 메서드로 정의하면 매개변수나 반환 타입이 달라도 문제가 되지 않는다.
그래서 `java.util.function` 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다. 매번 새로운 함수형 인터페이스를 정의하지 말고, 가능하면 이 패키지의 인터페이스를 활용하는 것이 좋다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225076683-a7892a0f-2c70-4aaf-96f8-cdfbd64d1de1.png">
</div>

매개변수와 반환값의 유무에 따라 4개의 함수형 인터페이스가 정의되어 있고, Function의 변형으로 Predicate가 있는데, 반환값이 boolean이라는 것만 제외하면 Function과 동일하다. Predicate는 조건식을 함수로 표현하는데 사용된다.

#### 조건식의 표현에 사용되는 Predicate
Predicate는 Function의 변형으로, 반환타입이 boolean이라는 것만 다르다. Predicate는 조건식을 람다식으로 표현하는데 사용된다.

```java
Predicate<String> isEmptyStr = s -> s.length == 0
String s = "";

if(isEmptyStr.test(s))
    System.out.println("This is an empty String.");
```

#### 매개변수가 두 개인 함수형 인터페이스

매개변수의 개수가 2개인 함수형 인터페이스는 이름 앞에 접두사 'Bi'가 붙는다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225111499-adcb6763-1b9e-48ec-a0fc-5cc5a8174c9b.png">
</div>

만약 두 개 이상의 매개변수를 갖는 함수형 인터페이스가 필요하다면 직접 만들어서 써야한다.
만일 3개의 매개변수를 갖는 함수형 인터페이스를 선언한담녀 다음과 같을 것이다.

```java
@FunctionalInterface
interface TriFunction<T,U,V,R> {
    R apply(T t, U u, V v);
}
```
매개변수의 타입으로 보통 'T'를 사용하므로, 알파벳에서 'T'의 다음 문자인 'U', 'V', 'W'를 매개변수의 탕비으로 사용하는 것일 뿐 별다른 의미는 없다.
참고로 Supplier는 매개변수는 업고 반환값만 존재하는데, 메서드는 두 개의 값을 반환할 수 없으므로 BiSupplier가 없는 것이다.

#### UnaryOperator와 BinaryOperator

Function의 또 다른 변형으로 UnaryOperator와 BinaryOperator가 있는데, 매개변수의 타입과 반환타입의 타입이 모두 일치한다는 점만 제외하고는 Function과 같다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225112383-689abf5c-8c7a-456d-999f-f22359e16018.png">
</div>

#### 컬렉션 프레임워크와 함수형 인터페이스

컬렉션 프레임워크의 인터페이스에 다수의 디폴트 메서드가 추가되어는데, 그 중의 일부는 함수형 인터페이스를 사용한다. 다음은 그 메서드들의 목록이다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225112624-d08cd5d8-a063-4c3e-89f4-5f2f7e520066.png">
</div>

#### 기본형을 사용하는 함수형 인터페이스

지금까지 소개한 함수형 인터페이스는 매개변수와 반환값의 타입이 모두 지네릭 타입이었는데, 기본형 타입의 값을 처리할 때도 래퍼(wrapper) 클래스를 사용해왔다. 그러나 기본형 대신 래퍼클래스를 사용하는 것은 당연히 비효율적이다. 그래서 보다 효율적으로 처리할 수 있도록 기본형을 사용하는 함수형 인터페이스들이 제공된다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225113603-dd7bd9d5-8a73-421c-a7f8-0b2804b6f66b.png">
</div>

### 1.5 Function의 합성과 Predicate의 결합

#### Function의 합성

수학에서 두 함수를 합성해서 하나의 새로운 함수를 만들어낼 수 있다는 것처럼, 두 람다식을 합성해서 새로운 람다식을 만들 수 있다. 이미 알고 있는 것처럼, 두 함수의 합성은 어느 함수를 먼저 적용하느냐에 따라 달라진다. 함수 f, g가 있을 때, f.andThen(g)는 함수 f를 먼저 적용하고, 그 다음에 함수 g를 적용한다. 그리고 f.compose(g)는 반대로 g를 먼저 적용하고 f를 적용한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225118964-d7927985-0448-42e3-ab0c-21c7ca4ece25.png">
</div>

예를 들어, 문자열을 숫자로 변환하는 함수 f와 숫자를 2진 문자열로 변환하는 함수 g를 andThen()으로 합성하여 새로운 함수 h를 만들어 낼 수 있다.

```java
Functional<String, Integer> f = (s) -> Integer.parseInt(s, 16);
Functional<Integer, String> g = (i) -> Integer.toBinaryString(i);
Functional<String, String> h = (h) -> f.andThen(g);
```

함수 h의 지네릭 타입이 '<String, String>'이다. 죽, String을 입력 받아서 String을 결과로 반환한다. 예를 들어 함수 h에 문자열 "FF"를 입력하면, 결과로 "11111111"을 얻는다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225118990-f1c14693-ab9e-4912-ab33-14034e087ee4.png">
</div>

이번에 compse()를 이용해서 두 함수의 반대의 순서로 합성해보자.

```java
Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
Function<Integer, Integer> h = f.compose(g);
```

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225119018-e735646c-c03d-45ce-a9d3-1fea77ba8d3a.png">
</div>

그리고 identity()는 함수를 적용하기 이전과 이후가 동일한 '항등 함수'가 필요할 때 사용한다. 이 함수를 람다식으로 표현하면 'x->x'이다. 아래의 두 문장은 동등하다.

```java
Function<String, String> f = x -> x;
Function<String, String> f = Function.identity(); // 위의 문장과 동일
```

#### Predicate의 결합

여러 조건식을 논리 연산자인 &&, ||, ! 으로 연결해서 하나의 식을 구성할 수 있는 것처럼, 여러 Predicate를 and(), or(), negate()로 연결해서 하나의 새로운 Predicate로 결합할 수 있다.

```java
Predicate<Integer> p = i -> i < 100;
Predicate<Integer> p = q -> i < 200;
Predicate<Integer> p = r -> i -> i%2 == 0;
Predicate<Integer> notP = p.negate();

Predicate<Integer> all = notP.and(q.or(r));
```

이처럼 and(), or(), negate()로 여러 조건식을 하나로 합칠 수 있다.

### 1.6 메서드 참조

람다식이 하나의 메서드만 호출하는 경우에는 '메서드 참조(method reference)'라는 방법으로 람다식을 간단하게 호출 할 수 있다.

```java
Function<String, String> f = (String s) -> Integer.parseInt(s);
```

보통은 이런식으로 람다식을 작성하는데, 이 람다식을 메서드로 표현하면 아래와 같다.

```java
Integer wrapper(String s) {
    return Integer.parseInt(s);
}
```

이 wrapper 메서드는 별로 하는 일이 없다. 그저 값을 받아서 Integer.parseInt()에게 넘겨주는 일만 할 뿐이다. 이 거추장 스러운 메서드는 벗겨내고 Integer.parseInt()를 직접 호출하는 것이 낫지 않을까?

```java
Function<String, Integer> f = (String s) -> Intger.parseInt(s);

Function<String, Integer> f = Integer::parseInt;
```

위 메서드의 참조에서 람다식의 일부가 생략되었지만, 컴파일러는 생략된 부분을 우변의 parseInt 메서드의 선언부로부터, 또는 좌변의 Function 인터페이스에 지정된 지네릭 타입으로부터 쉽게 알아낼 수 있다.

한 가지 예를 더 보자

```java
BiFunction<String, String, Boolean> f = (s1, s2) -> s1.equals(s2);
```

참조변수 f의 타입만 봐도 람다식이 두 개의 String 타입의 매개변수를 받는 다는 것을 알 수 있으므로, 람다식의 매개변수들은 없어도 된다.

```java
BiFunction<String, String, Boolean> f = (s1, s2) -> s1.equals(s2);

BiFunction<String, String, Boolean> f = String::equals;
```

Boolean을 반환하는 equals라는 이름의 메섣드는 다른 클래스에도 존재할 수 있기 때문에 equals 앞에 클래스 이름은 반드시 필요하다.
메서드 참조를 사용할 수 있는 한 가지가 더 있는데, 이미 생성된 객체의 메서드를 람다식에서 사용한 경우에는 클래스 이름 대신 그 객체의 참조변수를 적어주면 된다.

```java
MyClass obj = new MyClass();
Function<String, Boolean> f = (x) -> obj.equals(x);
Function<String, Boolean> f2 = obj::equals;
```

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225124890-faad0f69-040f-42b5-8f9c-af6e3e9ac8cc.png">
</div>

#### 생성자의 메서드 참조
생성자를 호출하는 람다식도 메서드 참조로 변환할 수 있다.

```java
Supplier<MyClass> s = () -> new MyClass();
Supplier<MyClass> s = () -> MyClass::new;
```

매개변수가 있는 생성자라면, 매개변수의 개수에 따라 알맞은 함수형 인터페이스를 사용하면 된다. 필요하다면 함수형 인터페이스를 새로 정의해야 한다.

```java
Function<Integer, MyClass> f = (i) -> new Class(i);
Function<Integer, MyClass> f2 = (i) -> MyClass::new;

BiFunction<Integer, String, MyClass> bf = (i, s) -> new MyClass(i, s);
BiFunction<Integer, String, MyClass> bf2 = MyClass::new;

Function<Integer, int[]> f = x -> new int[x];
Function<Integer, int[]> f2 = int[]::new;
```

메서드 참조는 람다식을 마치 static 변수처럼 다룰 수 있게 해준다.

## 2. 스트림(Stream)

## 2.1 스트림이란?

스트림은 데이터소스를 추상화하고, 데이터를 다루는데 자주 사용하는 메서드들을 정의해 놓았다. 데이터 소스를 추상화 한다는 것은, 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있게 되었다는 것과 코드의 재사용성이 높아진다는 것을 의미한다.

예를 들어, 문자열 배열과 같은 내용의 문자열을 저장하는 List가 있을 때,

```java
String[] strArr = {"aaa","ddd","ccc"};
List<String> strList = Arrays.asList(strArr);
```

이 두 데이터 소스를 기반으로 하는 스트림은 다음과 같이 생성한다.

```java
Stream<String> strStream1 = strList.stream();
Stream<String> strStream2 = Arrays.stream(strArr);
```

```java
strStream1.sorted().forEach(System.out::println);
strStream2.sorted().forEach(System.out::println);
```

두 스트림의 데이터 소스는 서로 다르지만, 정렬하고 출력하는 방법은 완전히 동일하다.
예전에는 아래와 같이 소스를 작성해야 했을 것이다.

```java
Arrays.sort(strArr);
Collections.sort(strList);

for(String str : strArr)
    System.out.println(str);

for(String str : strList)
    Systme.out.println(str);
```

확실히 스트림을 사용한 소스가 간결하다.

#### 스트림은 데이터 소스를 변경하지 않는다.

스트림은 데이터 소스로 부터 데이터를 읽기만할 뿐, 데이터 소스를 변경하지 않는다는 차이가 있다. 필요하다면, 정렬된 결과를 컬렉션이나 배열에 받아서 반환할 수도 있다.

```java
List<String> sortedList = strStream2.sorted().collect(Collectors.toList());
```

#### 스트림은 일회용이다.

스트림은 Iterator 처럼 일회용이다. 스트림은 한번 사용하면 닫혀서 사용할 수 없다.

```java
strStream1.sorted().forEach(System.out::println);
int numOfStr = strStream1.count(); // 에러. 스트림이 이미 닫힘.
```

#### 스트림은 작업을 내부 반복으로 처리한다.

내부 반복 이라는 것은 반복문을 메서드의 내부에 숨길 수 있다는 것을 의미한다. forEach()는 스트림에 정의된 메서드 중의 하나로 매개변수에 대입된 람다식을 데이터 소스의 모든 요소에 적용한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225127424-984c5758-8f2d-457d-b395-1ed27834db1d.png">
</div>

즉, forEach()는 메서드 안으로 for문을 밀어 넣은 것이다. 수행할 작업은 매개변수로 받는다.

```java
void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);

    for(T t : src) {
        action.accept(T);
    }
}
```

#### 스트림의 연산

스트림이 제공하는 다양한 연산을 이용해서 복잡한 작업들을 간단히 처리할 수 있다. 마치 데이터베이스에 SELECT 문으로 질의를 하는 것과 같은 느낌이다.

스트림이 제공하는 연산은 중간 연산과 최종 연산으로 분류할 수 있다. 중간 연산은 연산 결과를 스트림으로 반환하기 때문에 중간 연산을 연속해서 연결 할 수 있다. 반면에 최종 연산은 스트림의 요소를 소모하면서 연산을 수행하므로 단 한번만 연산이 가능하다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225128259-91984b61-ce06-47cb-8f28-6d02287b2530.png">
</div>

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225128283-7cb87a93-c441-492c-90b0-fe60315fc80d.png">
</div>

#### 지연된 연산

스트림 연산에서 한 가지 중요한 점은 최종 연산이 수행되기 전 까지는 중간 연산이 수행되지 않는다는 점이다. 스트림에 대해 distinct()나 sort()같은 중간 연산을 호출해도 즉각적인 연산이 수행되는 것은 아니라는 점이다. 중간 연산을 호출하는 것은 단지 어떤 작업이 수행되어야 하는지를 지정해주는 것일 뿐이다.

#### `Stream<Integer>`와 `IntStream`

요소의 타입이 T인 스트림은 기본적으로 Stream<T> 이지만, 오토박싱 & 언박싱으로 비효율을 줄이기 위해 데이터의 소스의 요소를 기본형으로 다루는 IntStream, LongStream, DoubleSteram이 제공된다.

#### 병렬 스트림

스트림으로 데이터를 다룰 때 장점 중 하나가 바로 병렬 처리가 쉽다는 것이다. 병렬 스트림은 내부적으로 이 `fork & join` 프레임워크를 사용해서 자동적으로 연산을 병렬로 수행한다. 우리가 할일이라고는 스트림에 `parrael()` 이라는 메서드를 호출해서 병렬로 연산을 수행하도록 지시하면 될 뿐이다.

```java
int sum = strStream.parallel()
                   .mapToInt(s -> s.length)
                   .sum();
```

### 2.2 스트림 만들기

#### 컬렉션

컬렉션의 최고 조상인 Collection에 stream()이 정의되어 있다. 그래서 Collection의 자손인 List와 Set을 구현한 컬렉션 클래스들은 모두 이 메서드로 컬렉션을 구현할 수 있다.
stream()은 해당 컬렉션을 소스(source)로 하는 스트림을 반환한다.

```java
Stream<T> Collection.stream()
```

예를 들어 List로부터 스트림을 생성하는 코드는 다음과 같다.

```java
List<Integer> list = Arrays.asList(1,2,3,4,5);
Stream<Integer> intStream = list.stream();
```

forEach()는 지정된 작업을 스트림의 모든 요소에 대해 수행한다.
```java
intStream().forEach(System.out::println);
```

#### 배열

배열을 소스로 하는 스트림을 생성하는 메서드는 다음과 같이 Stream과 Arrays에 static 메서드로 정의되어 있다.

```java
Stream<T> Stream.of(T... values) // 가변 인자
Stream<T> Stream.of(T[])
Stream<T> Arrays.stream(T[])
Stream<T> Arrays.stream(T[] array, int startInclusive, int endInclusive)
```

예를 들어 문자열 스트림은 다음과 같이 출력한다.

```java
Stream<String> strStream = Stream.of("a", "b", "c");
Stream<String> strStream = Stream.of(new String[]{"a","b","c"}));
Stream<String> strStream = Arrays.stream(new String[]{"a","b","c"}));
Stream<String> strStream = Arrays.stream(new String[]{"a","b","c"}, 0,3));
```

그리고 int, long, double과 같은 기본형 배열을 소스로 하는 스트림을 생성하는 메서드도 있다.

```java
IntStream IntStream.of(int...values)
IntStream IntStream.of(int[])
IntStream Arrays.stream(int[])
IntStream Arrays.stream(int[] array, int startInclusive, int endInclusive)

```

#### 특정 범위의 정수

```java
IntStream - IntStream.range(int begin, int end) 1,5 -> 1,2,3,4
IntStream - IntStream.rangeClosed(int begin, int end) 1,5 -> 1,2,3,4,5
```

#### 임의의 수

난수를 생성하는데 사용하는 Random클래스에는 아래와 같은 인스턴스 메서드들이 포함되어 있다. 이 메서드들은 해당 타입의 난수들로 이루어진 스트림을 반환한다.

```java
IntStream intStream = new Random().ints(); // 정수 무한스트림
intStream.limit(5).forEach(System.out::println); // 5개의 요소만 출력
```

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225160219-bd6dae52-8f2a-4251-b25a-a8aed9d7e247.png">
</div>

#### 람다식 - iterate(), generate

Stream 클래스의 iterate()와 generate()는 매개변수를 받아서, 이 람다식에 의해 계산되는 값들을 요소로 하는 무한 스트림을 생성한다.

```java
static <T> Stream<T> iterate(T seed, UnaryOperatior<T> f)
static <T> Stream<T> generate(Supplier<T> s)
```

iterate()는 seed로 부터 시작해서 람다식 f에 의해 계산된 결과를 다시 seed로 해서 계산을 반복한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225161251-48428d9b-1547-41e6-aa68-745a2f81dc83.png">
</div>

generate()도 iterate()처럼, 람다식에 의해 계산되는 값을 요소로 하는 무한스트림을 생성해서 반환하지만, iterate()와 달리,이전 결과를 이용해서 다음요소를 계산하지 않는다.
그리고 gernerate()에 정의된 매개변수의 타입은 Supplier<T> 이므로 매개변수가 없는 람다식만 허용된다.

#### 파일

`java.nio.file.Files` 는 파일을 다루는데 유용한 메서드들을 정의하는데, list()는 지정된 디렉토리에 있는 파일의 목록을 소스로하는 스트림을 생성해서 반환한다.

```java
Stream<Path> Files.list(Path dir)
```

#### 빈 스트림

요소가 하나도 없는 빈 스트림을 생성할 수도 있다. 스트림을 연산하는 결과가 하나도 없을 때, null 보단 빈 스트림을 반환하는 것이 더 낫다.

```java
Stream emptyStream = Stream.empty(); // empty는 빈 스트림을 생성하여 반환한다.
long count = emptyStream.count(); // count의 값은 0
```

#### 두 스트림의 연결

Stream의 static 메서드인 concat()을 이용하면, 두 스트림을 하나로 연결할 수 있다. 물론 연결하는 요소의 타입은 같은 타입 이어야 한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225163445-0624ba28-4327-4b6f-88cb-7d8b93c6cff2.png">
</div>

### 2.3 스트림의 중간연산

#### 스트림 자르기 - skip(), limit()

skip()과 limit()은 스트림의 일부를 잘라낼 때 사용한다.
skip(3)은 처음 요소 3개를 건너뛰며, limit(5)는 스트림의 요소를 5개로 제한한다.

```java
Stream<T> skip(long n)
Stream<T> limit(long maxSize)
```

#### 스트림의 요소 걸러내기 - filter(), distinct()

distinct()는 스트림에서 중복된 요소를 제거하고, filter()는 주어진 조건 (Predicate)에 맞지 않는 요소를 걸러낸다.

```java
Stream<T> filter(Predicate<? super T> predicate)
Stream<T> distinct()
```

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225164211-2d60887f-6e83-4ef2-9c2c-7e4cf5ef18ae.png">
</div>

#### 정렬 - sorted()

sorted()는 지정된 Comparator()로 스트림을 생성하는데, Comparator대신 int 값을 반환하는 람다식을 사용하는 것도 가능하다. Comparator을 지정하지 않으면 스트림의 기본 정렬 기준(Comparable)으로 정렬한다. 단, 스트림의 요소가 Comparable을 구현한 클래스가 아니면 예외가 발생한다.

```java
Stream<String> strStream = Stream.of("dd","Aaa","CC");
strStream.sorted().forEach(System.out::print); // CC
```

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225164359-581b1400-0045-4d6e-bbb7-20880ab897cc.png">
</div>