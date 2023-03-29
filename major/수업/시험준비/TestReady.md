
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
  - 싱글톤 패턴

- 데이터베이스
    - 모름
- HTML/CSS/JS
    - 모름

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

4. 주어진 문제에 대해 문제 풀이를 한다. 단, 주의할 점은 쓰레드를 사용할 경우 반드시 동시성에 관한 문제를 잘 제어할 수 있어야 한다.

4-1. 가장 간단한 방법은 `synchronize` 키워드를 이용하는 것이다. `메소드`와 `블럭`으로 사용이 가능하다. 이 작업은 매우 간편하지만,  `synchonize`를 사용할 경우 가장 큰 단점은 메소드와 블럭을 기준으로 동기화를 하기 때문에 많은 작업이 이루어질 경우  속도가 느려질 수 있다는 단점이 있다.

4-2. 그 외에는 `semaphore`, `mutex` 를 사용한 방법이 있다.
