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
