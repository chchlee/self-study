## 1. 네트워킹(Networking)
네트워킹이란 두 대 이상의 컴퓨터를 케이블로 연결하여 네트워크를 구성하는 것을 말한다.
자바에서 제공하는 java.net 패키지를 사용하면 이러한 네트워크 어플리케이션의 데이터 통신을 쉽게 작성할 수 있으며, 간단한 네트워크 어플리케이션은 단 몇 줄의 자바코드 만으로 작성이 가능하다.

### 1.1 클라이언트/서버(client/server)
- 서버(server) : 서비스를 제공하는 컴퓨터(service provider)
- 클라이언트(client) : 서비스를 사용하는 컴퓨터(service user)

하드웨어 샤앙에 관계없이 서비스를 제공하는 소프트웨어가 실행되는 컴퓨터를 서버라 한다.

서비스는 서버가 클라이언트로부터 요청받은 작업을 처리하여 그 결과를 제공하는 것을 뜻하며 서버가 제공하는 서비스의 종류에 따라 파일서버, 메일서버, 어플리케이션 서버 등이 있다.

파일공유프로그램인 소리바다나 푸르나와 같은 프로그램은 클라이언트 프로그램과 서버 프로그램을 하나로 합친 것으로 이를 설치한 컴퓨터는 클라이언트인 동시에 서버가 되어 다른 컴퓨터로부터 파일을 가져오는 동시에 또 다른 컴퓨터에게 파일을 제공할 수 있다.

네트워크를 구성할 때 전용서버를 두는 것을 서버기반모델(server-based model)이라하고 별도의 전용서버없이 각 클라이언트가 서버역할을 동시에 수행하는 것을 P2P모델(Peer to Peer)이라 한다.

|서버기반 모델|P2P 모델|
|--|--|
|- 안정적인 서비스 제공이 가능 </br> - 공유 데이터의 관리와 보안이 용이 </br> - 서버 구축비용과 관리비용이 든다.|- 서버구축 및 운용비용을 절감할 수 있다. </br> - 자원의 활용을 극대화할 수 있다. </br> - 자원의 관리가 어렵다. </br> - 보안이 취약하다.|

### 1.2 IP주소
IP주소는 컴퓨터(host)를 구별하는데 사용되는 고유한 값으로 인터넷에 연결된 모든 컴퓨터는 IP주소를 갖는다. IP주소는 4byte(32bit)의 정수로 이루어져 있으며, 4개의 정수가 마침표로 구분자로 'a.b.c.d'와 같은 형식으로 표현된다. a,b,c,d 는 부호없는 1byte 값, 즉 0~255사이의 정수이다.

IP주소는 다시 네트워크주소와 호스트주소로 나눌 수 있는데, 32bit(4byte)의 IP주소 중에서 네트워크주소와 호스트주소가 각각 몇 bit를 차지하는 지는 네트워크를 어떻게 구성하였는지에 따라 달라진다. 그리고 서로 다른 두 호스트의 IP주소의 네트워크주소가 같다는 것은 두 호스트가 같은 네트워크에 포함되어 있다는 것을 의미한다.

#### 서브넷 마스크란?
클래스리스 기반 IP 주소에서 네트워크 주소와 호스트 주소를 구분하기 위한 구분자.

- IP주소와 서브넷 마스크를 2진수로 표현하면 다음과 같다.
<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223481887-48849e03-4c2f-4dae-ba50-cf77e9499332.png">
</div>

- IP주소와 서브넷 마스크를 비트연산자 '&'로 연산하면 IP주소에서 네트워크 주소만을 뽑아낼 수 있다.
<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223481928-d6527c0d-7397-4d55-9bc5-c4df9376fba4.png">
</div>

이 결과로부터 '192.168.10.100'의 네트워크 주소는 24bit(192.168.10)이라는 것과 호스트 주소는 마지막 8bit(100)이라는 것을 알 수 있다.

IP주소에서 네트워크주소가 차지하는 자리수가 많을수록 호스트 주소의 범위가 줄어들기 때문에 네트워크의 규모가 작아진다. 이 경우 호스트 주소의 자리수가 8자리이기 때문에 256(2^8)개의 호스트만 이 네트워크에 포함될 수 있다.
호스트 주소가 0인 것은 네트워크 자신을 나타내고, 255는 브로트캐스트 주소로 사용되기 때문에 실제로 네트워크에 포함 가능한 호스트 개수는 254개이다.

### 1.3 InetAddress
자바에서는 IP주소를 다루기 위한 클래스로 InetAddress를 제공한다.
<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223484561-e629b4cf-8713-400e-be7f-56948bcceb11.png">
</div>

### 1.4 URL(Uniform Resource Locator)
URL은 인터넷에 존재하는 여러 서버들이 제공하는 자원에 접근할 수 있는 주소를 표현하기 위한 것으로 '프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조'의 형태로 이루어져 있다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223485363-c7c981a5-99ac-4db0-9b1d-380234c973c7.png">
</div>

- URL을 다루기 위한 메소드는 다음과 같다.
<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223485363-c7c981a5-99ac-4db0-9b1d-380234c973c7.png">
</div>

- URL객체를 생성하는 방법은 다음과 같다.
```java
URL url = new LUR("http://www.codechobo.com/sample/hello.html");
URL url = new URL("www.codechobo.com", "/sample/hello.html");
URL url = new URL("http", "www.codechobo.com", 80, "/sample/hello.html");
```

## 1.5 URLConnection
URLConnection은 어플리케이션과 URL간의 통신연결을 나타내는 클래스의 최상위 클래스로 추상클래스이다. URLConnection을 상속받아 구현한 클래스로는 HttpURLConnection과 JarURLConnection이 있으며 URL의 프로토콜이 http프로토콜이라면 openConneciton()은 Http URLConnection을 반환한다. URLConnection을 사용해서 연결하고자 하는 자원에 접근하고 읽고 쓰기를 할 수 있따. 그 외에 관련된 정보를 읽고 쓸 수 있는 메서드가 제공된다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223486769-a25db4a8-3f22-44d3-b780-c0c6112079b7.png">
</div>


<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223486809-e8f6e354-697f-4722-ae08-f69799197e27.png">
</div>

## 2. 소켓 프로그래밍
소켓 프로그래밍은 소켓을 이용한 통신 프로그래밍을 뜻하는데, 소켓(socket)이란 프로세스간의 통신에 상요되는 양쪽 끝단을 의미한다. 서로 멀리 떨어진 두 사람이 통신하기 위해서 전화기가 필요한 것처럼, 프로세스간의 통신을 위해서는 그 무언가가 필요하고 그것이 바로 소켓이다.
자바에서는 java.net 패키지를 통해서 소켓 프로그래밍을 지원한다.

### 2.1 TCP와 UDP
<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223491009-dcd88a4b-7de5-4fd4-acd4-2df2ee2d1154.png">
</div>

### 2.2 TCP소켓 프로그래밍
TCP 소켓 프로그래밍은 클라이언트와 서버간의 일대일 통신이다. 먼저 서버 프로그램이 실행되어 클라이언트 프로그램의 연결요청을 기다리고 있어야 한다. 서버 프로그램과 클라이언트 프로그램간의 통신과정을 단계별로 보면 다음과 같다.

1. 서버 프로그램에서는 서버소켓을 사용해서 서버 컴퓨터의 특정 포트에서 클라이언트의 연결요청을 처리할 준비를한다.
2. 클라이언트 프로그램은 접속할 서버의 IP주소와 포트 정보를 가지고 소켓을 생성해서 서버에 연결을 요청한다.
3. 서버소켓은 클라이언트의 연결요청을 받으면 서버에 새로운 소켓을 생성해서 클라이언트의 소켓과 연결되도록 한다.
4. 이제 클라이언트의 소켓과 새로 생성된 서버의 소켓은 서버소켓과 관계없이 일대일 통신을 한다.

서버소켓(ServerSocket)은 포트와 결합(bind)되어 포트를 통해 원격 사용자의 연결요청을 기다리다가 연결요청이 올 때마다 새로운 소켓을 생성해서 상대편 소켓과 통신할 수 있도록 연결한다.
여러 개의 소켓이 하나의 포트를 공유해서 사용할 수 있지만, 서버소켓은 포트를 독점한다. 만일 한 포트를 둘 이상의 서버소켓과 연결하는 것이 가능하다면 클라이언트 프로그램이 어떤 서버소켓과 연결해야하는지 알 수 없을 것이다.
포트(port)는 호스트(컴퓨터)가 외부에 통신을 하기 위한 통로로 하나의 호스트가 65536개의 포트를 가지고 있으며 포트는 번호로 구별된다. 포트의 번호는 0~65535의 범위에 속하는 값인데 보통 1023 이하의 포트는 FTP나 Telnet과 같은 기존의 다른 통신 프로그램들에 의해서 사용되는 경우가 많기 때문에 1023번 이상의 번호 중에서 사용하지 않는 포트를 골라서 사용해야 한다.

서버소켓은 소켓간의 연결만 처리하고 실제 데이터는 소켓들끼리 서로 주고받는다. 소켓들이 데이터를 주고받는 연결통로는 바로 입출력스트림이다.
소켓은 두 개의 스트림, 입결스트림과 출력스트림을 가지고 있으며, 이 스트림들은 연결된 상대편 소켓의 스트림들과 교차연결된다.
한 소켓에서 출력스트림으로 데이터를 보내면 상태편 소켓에서는 입력스트림으로 받게 된다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223496449-598fcd92-a88e-4d69-a651-da4b13e1e5f2.png">
</div>

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/223496781-1424ef0f-2bf2-4cec-89b0-c1eaf8e14e33.png">

<img src="https://user-images.githubusercontent.com/97272787/223496807-b115b4c9-c38a-41ea-85a7-2155827196f3.png">
</div>

### 2.3 UDP 소켓 프로그래밍
TCP소켓 프로그래밍에서는 Socket과 ServerSocket을 사용하지만, UDP 소켓 프로그래밍에서는 DatagramSocket과 DatagramPacket을 사용한다.
UDP는 연결지향적인 프로토콜이 아니기 때문에 ServerSocket이 필요하지 않는다.
UDP통신에서 사용하는 소켓은 DatagramSocket이며 데이터를 DatagramPacket에 담아서 전송한다.
DatagramPacket은 헤더와 데이터로 구성되어 있으며, 헤더에서는 DatagramPacket을 수신할 호스트의 정보(호스트의 주소와 포트)가 저장되어 있다. 소포(packet)에 수신할 상대편의 주소를 적어서 보내는 것과 같다고 이해하면 된다.