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

지금까지 소개한 함수형 인터페이스는 매개변수와 반환값의 타입이 모두 지네릭 타입이었는데, 기본형 타입의 값을 처리할 때도 래퍼(wrapper) 클래스를 사용해왔다. 그러나 기본형 대신 래퍼클래스를 사용하는 것은 당연히 비효율적이다. 그래서 보다 효율적으로 처리할 수 잇또록 기본형을 사용하는 함수형 인터페이스들이 제공된다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/225113603-dd7bd9d5-8a73-421c-a7f8-0b2804b6f66b.png">
</div>