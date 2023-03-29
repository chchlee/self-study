
## 무엇이 나올 수 있을까?

- 쓰레드
  - 동시성에 대해 물어보는 문제
  - 생산자와 소비자 문제를 풀어보자
- 소켓통신(네트워크 프로그래밍)
  - 기본 소켓 통신
  - 쓰레드와 소켓통신을 이용한 동시 채팅 구현 문제를 풀어보자
- Event-Driven
  - 쓰레드를 이용한 벽돌깨기 게임이나 풀어보자.
- Collection Framework
  - 당연히 다 사용할 수 있어야 하고, `Tree`를 잘모르니 그것에 대해 좀 풀어보자.
  - `Iterator`를 이용한 정렬 기준을 바꾸는 방법을 다시 봐보자.

- 디자인패턴
  - 우선 추상화를 잘하자. SOLID를 지키면서, 어떻게 프로그래밍을 할지 구상해야 한다.
  - 싱글톤 패턴, 팩토리 메서드 패턴, 어댑터 패턴, Iterator, 템플릿 메서드 패턴, 비지터 패턴
  - 싱글톤 패턴 : 대표적인 문제는 `계좌번호` 문제이다.
  - 팩토리 메서드 패턴 : `자판기` 문제를 풀어보자.
  - 어댑터 패턴 : `모니터 어댑터 관한 문제`를 풀어보자.
  - 반복자 패턴 : 이건 그냥 다양한 문제에 적용해봐야 한다.
  - 빌터 패턴 : `GoF 빌더패턴`과 `EffectiveJava 빌더 패턴`을 잘 활용해보자.
  - 템플릿 메서드 패턴 : `자판기` 문제를 리팩토링하자.
  - 비지터 패턴 : `Syntax Color Tokenizer`를 다시 풀어보자.

- 데이터베이스
  - 모름
- HTML/CSS/JS
  - 모름

## 쓰레드

1. 쓰레드 인스턴스 생성을 한다.

```java
- Thread 클래스를 상속받았을 경우

Thread th1 = new Thread();

- Runnable 인터페이스를 구현해야 하는 경우
Thread th1 = new Thread(new runnable);
```

2. 주어진 문제에 대해 문제 풀이를 한다. 단, 주의할 점은 쓰레드를 사용할 경우 반드시 동시성에 관한 문제를 잘 제어할 수 있어야 한다.

2-1. 가장 간단한 방법은 `synchronize` 키워드를 이용하는 것이다. `메소드`와 `블럭`으로 사용이 가능하다. 이 작업은 매우 간편하지만,  `synchonize`를 사용할 경우 가장 큰 단점은 메소드와 블럭을 기준으로 동기화를 하기 때문에 많은 작업이 이루어질 경우  속도가 느려질 수 있다는 단점이 있다.

2-2. 그 외에는 `semaphore`, `mutex` 를 사용한 방법이 있다.

3. 추가적으로 `Broadcast`는 쓰레드 간 메시지 전달을 위한 메커니즘으로 사용될 수 있다. 예를 들어, 하나의 쓰레드에서 작업을 수행한 후, 이를 다른 쓰레드에게 알리고자 할 때 사용한다.

4. `Handler`는 쓰레드 간 통신 및 비동기 작업을 처리를 위해 사용된다. Handler를 사용하여 쓰레드 간 메시지 전달을 처리하고, 다른 쓰레드에게 알리고자 할 떄 Handler를 사용하여 메시지를 전달할 수 있다.

## Socket 통신

1. 서버 소켓 인스턴스 생성
2. 서버에서 `serverSocket.accept()`를 하면서 Client와 연결할 준비를 한다.

```java
ServerSocket serverSocket = new ServerSocket(port);
ClientSocket clientSocket = serverSocket.accept();
```

3. 클라이언트에서 소켓 인스턴스를 생성한다. 이때, 접근을 해야하기 때문에 `hostname`과 `port`가 필요하다.

```java
Socket socket = new Socket(hostname, port);
```

### 네트워킹에서 문제 해결시 유용한 메서드

<table style="width:100%;">
    <p>URL 라이브러리</p>
    <tbody>
        <tr style="background-color:gray; font-weight:bold; text-align:center;">
            <td>메서드</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>URL(String spec)</td>
            <td>지정된 문자열 정보의 URL 객체를 생성</td>
        </tr>
        <tr>
            <td>URL(String protocol, String host)</td>
            <td>지정된 값으로 구성된 URL 객체를 생성</td>
        </tr>
        <tr>
            <td>String getFile()</td>
            <td>파일명을 반환한다.</td>
        </tr>
        <tr>
            <td>String getHost()</td>
            <td>호스트명을 반환한다.</td>
        </tr>
        <tr>
            <td>String getPath()</td>
            <td>경로명을 반환한다.</td>
        </tr>
        <tr>
            <td>String getProtocol()</td>
            <td>프로토콜을 반환한다.</td>
        </tr>
        <tr>
            <td>String getQuery()</td>
            <td>쿼리를 반환한다</td>
        </tr>
        <tr>
            <td>String getRef()</td>
            <td>참조(anchor)를 반환한다.</td>
        </tr>
        <tr>
            <td>String getUserInfo()</td>
            <td>사용자 정보 반환</td>
        </tr>
    </tbody>
</table>

<br />

HttpClient 라이브러리

1. HttpClient 객체를 생성한다

```java
HttpClient httpClient = new HttpClient.newHttpClient();
```

2. Http 요청 객체를 생성한다.

```java
URI uri = new URI("http://httpbin.org/get");
// 직접 URI를 파싱하지 않고, URI 라이브러리를 사용하면 편하다.
HttpRequest httpRequest = new HttpRequest.newBuilder(uri).GET().build();
//newBuilder는 Http 요청/응답을 빌더 방식으로 만들 수 있게 해준다.
```

3. Http 요청에 필요한 정보(헤더, 바디)를 추가한다.

```java
HttpResponse<String> response
```

4. Http 요청 실행 및 응답 객체 생성한다.

```java
HttpResponse<String> response = new HttpClient.send(request, HttpResponse.BodyHandlers.ofString());
```

5. Http 응답에서 필요한 정보를 추출한다.

```java
System.out.println("Response status code: " + response.statusCode());
System.out.println("Response body: " + response.body());
```
