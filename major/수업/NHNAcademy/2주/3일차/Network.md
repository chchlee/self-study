## Java에서 소켓(Socket) 통신을 사용하는 이유

Language 간의 구조가 다르기 때문에 서로 통신을 위해 byte 단위로 정보를 주고 받는 것.



## Http 통신과 Socket 통신의 차이

- HTTP는 단방향 통신
    - HTTP 통신은 Client의 Request가 있을 때만 서버가 Response를 해서 정보를 전송하고 곧바로 연결을 종료하는 방식이다. Client가 요청을 보내는 경우네만 Server가 응답하는 단방향 통신으로 Server가 Client에게 요청을 보낼 수는 없다.

- Socket 통신은 양방향 통신
    - HTTP 통신과 다르게 Server와 Client가 특정 Port를 통해 연결되어 있어서 실시간으로 양방향 통신을 할 수 있다. Streaming이나 실시간 채팅, 게임 등과 같이 즉각적으로 정보를 주고 받을 때 사용한다.

## Stream이란(InputStream, OutputStream)

Stream은 프로그램 동작 중 외부에서 데이터를 읽거나 외부로 데이터를 출력하는 작업에 사용된다. 이때 데이터는 어떤 통로를 통해서 이동되는데 이 통로를 Stream이라 한다.

- InputStream : 외부에서 데이터를 읽는 역할을 수행한다.
- OutputStream : 외부로 데이터를 출력하는 역할을 수행한다.