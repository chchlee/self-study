
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

#### 어느상황에 사용할까?

- Singleton (싱글톤): 객체의 인스턴스를 하나만 생성하고, 이후에는 그 인스턴스를 공유해서 사용하는 패턴. 주로 자원을 공유해야 하는 경우나, 설정 정보 등의 공통된 데이터를 유지해야 하는 경우에 사용된다.

- Visitor (비지터): 객체 구조를 변경하지 않고, 특정한 연산을 적용하기 위한 패턴. 객체 구조가 자주 변경되지 않고, 연산이 자주 추가되는 경우에 유용하다.

- Interpreter (인터프리터): 주어진 언어에 대한 문법을 해석하고 실행하기 위한 패턴. 간단한 언어나 문법이 정해져 있는 경우에 사용된다.

- Template Method (템플릿 메서드): 상위 클래스에서 알고리즘의 뼈대를 정하고, 하위 클래스에서 구체적인 내용을 구현하는 패턴. 공통적인 알고리즘이 있지만, 구체적인 내용이 다를 때 사용된다.

- Builder (빌더): 복잡한 객체의 생성 과정을 단순화하기 위한 패턴. 객체의 생성 과정이 복잡하거나, 다양한 종류의 객체를 생성해야 하는 경우에 사용된다.

- Factory Method (팩토리 메서드): 객체의 생성을 서브 클래스에 위임하는 패턴. 객체를 생성하는 방법이 달라질 때 사용된다.

- Adapter (어댑터): 호환되지 않는 인터페이스를 사용하는 객체들을 연결해주는 패턴. 기존의 코드를 수정하지 않고도 새로운 인터페이스를 사용할 수 있도록 해주는 경우에 사용된다.

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
Thread th1 = new Thread(new Runnable(){...};
```

2. 주어진 문제에 대해 문제 풀이를 한다. 단, 주의할 점은 쓰레드를 사용할 경우 반드시 동시성에 관한 문제를 잘 제어할 수 있어야 한다.

2-1. 가장 간단한 방법은 `synchronize` 키워드를 이용하는 것이다. `메소드`와 `블럭`으로 사용이 가능하다. 이 작업은 매우 간편하지만,  `synchonize`를 사용할 경우 가장 큰 단점은 메소드와 블럭을 기준으로 동기화를 하기 때문에 많은 작업이 이루어질 경우  속도가 느려질 수 있다는 단점이 있다.

2-2. 그 외에는 `semaphore`, `mutex` 를 사용한 방법이 있다.

3. 추가적으로 `Broadcast`는 쓰레드 간 메시지 전달을 위한 메커니즘으로 사용될 수 있다. 예를 들어, 하나의 쓰레드에서 작업을 수행한 후, 이를 다른 쓰레드에게 알리고자 할 때 사용한다.

```java
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");
        System.out.println(message);
    }
}

public class BroadcastExample {
    public static void main(String[] args) {
        Context context = new Context(); // Context 객체 생성
        MyReceiver receiver = new MyReceiver();
        Intent intent = new Intent();
        intent.putExtra("message", "Hello, World!");
        context.sendBroadcast(intent);
    }
}
```

4. `Handler`는 쓰레드 간 통신 및 비동기 작업을 처리를 위해 사용된다. Handler를 사용하여 쓰레드 간 메시지 전달을 처리하고, 다른 쓰레드에게 알리고자 할 떄 Handler를 사용하여 메시지를 전달할 수 있다.

```java
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HandlerExample {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor(); // 스레드풀 생성
        Handler handler = new Handler(executor);

        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}


```

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

```java
// 소켓통신과 쓰레드를 사용한 예제
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 8888;
    private static HashSet<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("채팅 서버 시작...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("서버 에러: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (writers) {
                    writers.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("메시지 수신: " + message);
                    synchronized (writers) {
                        for (PrintWriter writer : writers) {
                            writer.println(message);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("클라이언트 연결 에러: " + e.getMessage());
            } finally {
                if (out != null) {
                    synchronized (writers) {
                        writers.remove(out);
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("소켓 종료 에러: " + e.getMessage());
                }
            }
        }
    }
}


import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("서버에 연결되었습니다.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            new Thread(() -> {
                while (true) {
                    String message = scanner.nextLine();
                    out.println(message);
                }
            }).start();

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("서버로부터 받은 메시지: " + message);
            }
        } catch (IOException e) {
            System.err.println("클라이언트 에러: " + e.getMessage());
        }
    }
}


```

### 네트워킹에서 문제 해결시 유용한 메서드

#### URL 라이브러리

<table style="width:100%;">

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

#### HttpClient 라이브러리

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

### 디자인패턴에 대해 알아보자

- `어댑터패턴` : 기존 클래스의 인터페이스를 새로운 인터페이스로 변경하는 디자인 패턴이다.

```java

// 온도센서 인터페이스
public interface CelsiusTemperatureSensor {
    double getTemperatureInCelsius();
}


// 화씨온도 인터페이스
public interface FahrenheitTemperatureSensor {
    double getTemperatureInFahrenheit();
}

// 온도 센서 구현
public class CelsiusThermometer implements CelsiusTemperatureSensor {
    @Override
    public double getTemperatureInCelsius() {
        return 25.0;
    }
}

// 화씨 온도센서 구현
public class FahrenheitThermometer implements FahrenheitTemperatureSensor {
    @Override
    public double getTemperatureInFahrenheit() {
        return 77.0;
    }
}

// 어댑터 클래스
public class FahrenheitToCelsiusAdapter implements CelsiusTemperatureSensor {
    private FahrenheitTemperatureSensor fahrenheitSensor;

    public FahrenheitToCelsiusAdapter(FahrenheitTemperatureSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperatureInCelsius() {
        double fahrenheit = fahrenheitSensor.getTemperatureInFahrenheit();
        return (fahrenheit - 32) * 5 / 9;
    }
}

// 실행
public class Main {
    public static void main(String[] args) {
        CelsiusTemperatureSensor celsiusSensor = new CelsiusThermometer();
        System.out.println("Celsius sensor: " + celsiusSensor.getTemperatureInCelsius() + "°C");

        FahrenheitTemperatureSensor fahrenheitSensor = new FahrenheitThermometer();
        CelsiusTemperatureSensor adaptedSensor = new FahrenheitToCelsiusAdapter(fahrenheitSensor);
        System.out.println("Fahrenheit sensor (adapted): " + adaptedSensor.getTemperatureInCelsius() + "°C");
    }
}

```

- `팩토리 메서드 패턴` : 객체를 생성하는 인터페이스를 정의하지만, 인스턴스를 만들 클래스를 서브 클래스에서 결정하게 하는 디자인 패턴

```java
// 추상화를 해서 객체의 공통된 인터페이스를 만든다.
public interface Shape {
    void draw();
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}
// 도형에 객체 생성에 관한 인터페이스를 만든다. 필드를 추가할 일이 있으면
// default method나 abstract class로 만들어도 좋다.
public interface ShapeFactory {
    Shape createShape();
}

// 각 객체에 대한 생성 팩토리를 상속받아 구현한다. 이것을 의존성 역전이라 한다.
// 의존성 역전은 추상화에 의존해야지, 구체화에 의존해서 안된다는 의미이다.
public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

public class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}

public class TriangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Triangle();
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();

        ShapeFactory triangleFactory = new TriangleFactory();
        Shape triangle = triangleFactory.createShape();
        triangle.draw();
    }
}

```

- `싱글톤 패턴` : 클래스에 인스턴스가 단 하나만 있도록 보장하는 디자인패턴

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation from outside
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Singleton instance is doing something");
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton singletonInstance1 = Singleton.getInstance();
        singletonInstance1.doSomething();

        Singleton singletonInstance2 = Singleton.getInstance();
        singletonInstance2.doSomething();

        System.out.println("Are both instances equal? " + (singletonInstance1 == singletonInstance2));
    }
}

```

- `반복자 패턴` : 객체 집합의 요소를 순차적으로 접근할 수 있는 일관된 인터페이스를 제공하는 디자인 패턴이다. 이 패턴은 집합의 내부 표현을 드러내지 않고 요소를 순회하는 방법을 제공한다.

```java
public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

public interface MyIterator {
    boolean hasNext();
    Object next();
}

import java.util.ArrayList;

public class Bookshelf {
    private ArrayList<Book> books;

    public Bookshelf() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public int getSize() {
        return books.size();
    }

    public MyIterator iterator() {
        return new BookshelfIterator();
    }

    private class BookshelfIterator implements MyIterator {
        private int index;

        public BookshelfIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < getSize();
        }

        @Override
        public Object next() {
            return getBookAt(index++);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.addBook(new Book("Book 1"));
        bookshelf.addBook(new Book("Book 2"));
        bookshelf.addBook(new Book("Book 3"));

        MyIterator iterator = bookshelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println("Book title: " + book.getTitle());
        }
    }
}


```

- `GoF 빌더패턴`  : 빌더 패턴을 사용하면 객체 생성 단계를 나누고, 각 단계에서 필요한 구성 요소를 구체적으로 구현할 수 있다. 이를 통해 복잡한 객체를 만드는 과정을 단순화하고, 가독성을 높일 수 있다.

```java
public class HTMLDocument {
    private final String content;

    public HTMLDocument(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

public interface DocumentBuilder {
    void addTitle(String title);
    void addHeading(String heading);
    void addParagraph(String paragraph);
    HTMLDocument getResult();
}

public class HTMLDocumentBuilder implements DocumentBuilder {
    private StringBuilder content = new StringBuilder();

    @Override
    public void addTitle(String title) {
        content.append("<h1>").append(title).append("</h1>");
    }

    @Override
    public void addHeading(String heading) {
        content.append("<h2>").append(heading).append("</h2>");
    }

    @Override
    public void addParagraph(String paragraph) {
        content.append("<p>").append(paragraph).append("</p>");
    }

    @Override
    public HTMLDocument getResult() {
        return new HTMLDocument(content.toString());
    }
}

public class DocumentDirector {
    private DocumentBuilder builder;

    public DocumentDirector(DocumentBuilder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.addTitle("Builder Pattern Example");
        builder.addHeading("Introduction");
        builder.addParagraph("This is an example of the Builder Pattern.");
        builder.addHeading("Conclusion");
        builder.addParagraph("The Builder Pattern is useful for creating complex objects step by step.");
    }

    public HTMLDocument getResult() {
        return builder.getResult();
    }
}

public class Main {
    public static void main(String[] args) {
        HTMLDocumentBuilder builder = new HTMLDocumentBuilder();
        DocumentDirector director = new DocumentDirector(builder);

        director.construct();
        HTMLDocument document = director.getResult();

        System.out.println("Generated HTML Document:");
        System.out.println(document.getContent());
    }
}


```

- `Effective Java 빌더패턴` : 복잡한 객체를 생성하는 과정을 단계별로 분리하여, 동일한 생성 절차를 통해 서로 다른 표현 결과를 만들 수 있는 디자인 패턴이다. 빌더 패턴은 생성자가 많은 매개변수를 가질때나 객체 생성 과정이 복잡한 경우 사용하면 좋다.

```java
public class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    private Pizza(PizzaBuilder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.topping = builder.topping;
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public String getTopping() {
        return topping;
    }

    public static class PizzaBuilder {
        private String dough;
        private String sauce;
        private String topping;

        public PizzaBuilder() {}

        public PizzaBuilder dough(String dough) {
            this.dough = dough;
            return this;
        }

        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder topping(String topping) {
            this.topping = topping;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

```

- `템플릿 메서드 패턴` : 어떤 알고리즘의 골격을 정의하고 알고리즘의 일부 단계를 서브 클래스로 구현할 수 있게 한다.

```java
public abstract class CaffeineBeverage {

    //템플릿 메서드: 알고리즘의 뼈대를 정의
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    //서브클래스에서 구현될 메서드
    abstract void brew();
    abstract void addCondiments();

    //공통적으로 사용되는 메서드
    void boilWater() {
        System.out.println("물 끓이는 중");
    }

    void pourInCup() {
        System.out.println("컵에 따르는 중");
    }
}

public class Coffee extends CaffeineBeverage {

    //서브클래스에서 구현되는 메서드
    void brew() {
        System.out.println("필터를 통해서 커피를 우려내는 중");
    }

    void addCondiments() {
        System.out.println("설탕과 우유를 추가하는 중");
    }
}

public class Tea extends CaffeineBeverage {

    //서브클래스에서 구현되는 메서드
    void brew() {
        System.out.println("차를 우려내는 중");
    }

    void addCondiments() {
        System.out.println("레몬을 추가하는 중");
    }
}

```

- `비지터패턴` : 객체 구조를 탐색하면서 각 객체에 대한 특정 작업을 수행하는 패턴이다. 이 패턴은 객체의 클래스와 작업을 분리하고, 새로운 작업을 추가하기 쉬운 유연한 설계를 가능하게 한다.

```java
public interface Product {
    void accept(Visitor visitor);
}

public class Book implements Product {
    private double price;

    public Book(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class Clothing implements Product {
    private double price;

    public Clothing(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public interface Visitor {
    void visit(Book book);
    void visit(Clothing clothing);
}

public class DiscountVisitor implements Visitor {
    public void visit(Book book) {
        double price = book.getPrice();
        price *= 0.8;
        System.out.println("할인된 가격: " + price);
    }

    public void visit(Clothing clothing) {
        double price = clothing.getPrice();
        price *= 0.9;
        System.out.println("할인된 가격: " + price);
    }
}

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public void calculateDiscount(Visitor visitor) {
        for (Product product : products) {
            product.accept(visitor);
        }
    }
}

```
