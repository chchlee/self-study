## 1. 예외처리
### 1.1 프로그램 오류
- 컴파일 에러 : 컴파일 시 발생하는 에러
- 런타임 에러 : 실행 시에 발생하는 에러
- 논리적 에러 : 실행은 되지만, 의도와 다르게 동작하는 것
- 에러 : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
- 예외 : 프로그램 코드에 의해 수습될 수 있는 다수 미흡한 오류

에러가 발생하면, 프로그램의 비정상적인 종료를 막을 길이 없지만, 예외는 발생하더라도 프로그래머가 이에 대한 적절한 코드를 미리 작성해놓음으로써 프로그램의 비정상적인 종료를 막을 수 있다.

### 1.2 예외 클래스의 계층 구조
자바에서는 실행 시에 발생할 수 있는 오류(Exception과 Error)를 클래스로 정의함.
모든 클래스의 조상은 Object클래스이므로 Exception과 Error 클래스 역시 Object 클래스의 자손.
<div align="center">
<img src="https://velog.velcdn.com/images/mingseok/post/55d9e691-cea8-4add-8859-327a9c1e4521/image.png">
</div>

모든 예외의 최고 조상은 Exception 클래스이며, 상슥계층도를 Exception클래스부터 도식화하면 다음과 같다.
<div align="center">
<img src="https://images.velog.io/images/kookiencream/post/44938894-584d-4ee5-9733-4903e956d49f/java_image_121.png">
</div>


위 그림에서 볼 수 있듯이 예외 클래스들은 다음과 같이 두 그룹으로 나눠질 수 있다.

- Exception 클래스와 그 자손들
- RuntimeException 클래스와 그 자손들

RuntioneException 클래스들은 주로 프로그래머의 실수에 의해서 발생될 수 있는 예외들로 자바 프로그래밍 요소들과 관계가 깊다. 예를 들면, 배열의 범위에 벗어난다던가(ArrayIndexOutOfBoundsException), 값이 Null인 참조변수의 멤버를 호출하려 했다던가(NullPointerException), 클래스간의 형변환을 잘못했다던가(ClassCastException), 정수를 0으로 나누려고(ArithmeticException)하는 경우에 발생한다.

Exception 클래스들은 주로 외부의 영향으로 발생할 수 있는 것들로서, 프로그램의 사용자들의 동작에 의해서 발생하는 경우가 많다. 예를 들면, 존재하지 않는 파일 의 이름을 입력했다던가(FileNotFoundException), 실수로 클래스의 이름을 잘못적었다던가(ClasNotFoundException), 또는 입력한 데이터 형식이 잘못된
(Dataformat Exception) 경우에 발생한다.


<div align="center">
<p text:15px;>예외의 종류</p>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FBBuxf%2Fbtq9NYf58GN%2FfNLV1zOMuwEfc1RDstFxC1%2Fimg.jpg">
</div>

### 1.3 예외처리하기 - try-catch문

예외처리(exception handling)
- 정의 : 프로그램 실행 시 발생할 수 있는 예외에 대비한 코드를 작성하는 것
- 목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것.

발생한 예외를 처리하지 못하면, 프로그램은 비정상적으로 종료되며, 처리되지 못한 예외(uncaught Exception)는 JVM의 '예외처리기(UnhandledExceptionHandler)'가 받아서 예외의 원인을 화면에 출력한다.

### 1.4 try-catch문에서의 흐름

- try블럭 내에서 예외가 발생한 경우,
1. 발생한 예외와 일치하는 catch 블럭이 있는지 확인한다.
2. 일치하는 catch 블럭을 찾게 되면, 그 catch블럭 내의 문장들을 수행하고 전체 try-catch 문을 빠져나가서 그 다음 문장을 계속해서 수행한다. 만일 일치하는 catch블럭을 찾기 못하면, 예외는 처리되지 못한다.

- try 블럭 내에서 예외가 발생하지 않은 경우,
1. catch 블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.

### 1.5 예외의 발생과 catch 블럭
예외가 발생한 문장에 try 블럭에 포함되어있다면, 이 예외를 처리할 수 있는 catch블럭이 있는지 부터 찾게 된다.
첫 번쨰 catch 블럭부터 차례로 내려가면서 catch 블럭의 괄호()내에 선언된 참조변수의 종류와 생성된 예외클래스의 인스턴스에 instanceof 연산자를 이용해서 검사하게 되는데, 검사결과가 true인 catch 블럭을 만날 때 까지 검사는 계속된다.

#### printStackTrace()와 getMessage()
- printStackTrace() - 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
- getMessage() - 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.

### 1.8 fianally 블럭
finally 블럭은 예외의 발생여부에 상관없이 실행되어야할 코드를 포함시킬 목적으로 사용된다. try-catch-fianlly의 순서로 구성된다.

### 1.9 자동 자원 반환 - try-with-fianlly문
주료 입출력에 사