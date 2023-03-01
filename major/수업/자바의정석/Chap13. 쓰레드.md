### 1. 프로세스와 쓰레드
프로세스란 간단히 말해서 '실행 중인 프로그램'이다. 프로그램을 실행하면 OS로부터 실행에 필요한 자원(메모리)를 할당 받아 프로세스가 된다.

프로세스는 프로그램을 수행하는 데 필요한 데이터와 메모리 등의 자원 그리고 쓰레드로 구성되어 있으며 프로세스의 자원을 이용해서 실제로 작업을 수행하는 것이 바로 쓰레드이다.
```
프로세스 = 데이터 + 메모리 + 쓰레드
```

하나의 프로세스가 가질 수 있는 쓰레드의 개수는 제한되어 있지 않으나 쓰레드가 작업을 수행하는데 개별적인 메모리 공간(호출스택)을 필요로 하기 때문에 프로세스의 메모리 한계에 따라 생성할 수 있는 쓰레드의 수가 결정된다.

#### 멀티쓰레딩의 장점
- CPU의 사용률을 향상시킨다.
- 자원을 보다 효율적으로 사용할 수 있다.
- 사용자에 대한 응답성이 향상된다.
- 작업이 분리되어 코드가 간결해진다.

메신저로 채팅하면서 파일을 다운로드 받거나 음성대화를 나눌 수 있는 것이 가능한 이유가 바로 멀티쓰레드로 작성되어 있기 때문이다.

#### 멀티쓰레딩의 단점
멀티쓰레드 프로세스는 여러 쓰레드가 같은 프로세스 내에서 자원을 공유하면서 작업을 하기 때문에 발생할 수 있는 동기화(synchronization), 교착상태(deadlock)와 같은 문제들을 고려해서 신중히 프로그램해야 한다.

### 2. 쓰레드의 구현과 실행
쓰레드를 구현하는 방법은 Thread클래스를 상속받는 방법과 Runnable 인터페이스를 구현하는 방법 두 가지가 있다.

```java
1. Thread 클래스를 상속
class MyThread extends Thread {
    public void run() { ... }
}
```

```java
2. Runnable 인터페이스를 구현
class MyThread implements Runnable {
    public void run() { ... }
}
```

```java
class ThreadEx1{
    public static void main(String[] args){
        ThreadEx_1 t1 = new ThreadEx_1(); // ThreadEx_1()는 참조변수 t1에 ThreadEx_1을 상속 받아서 사용

        Thread t2 = new Thread(new ThreadEx1_2());// ThreadEx1_2() 구현한 Runnable Interface를 구현해서 참조변수 t2에 할당.
    }
}
```

#### 쓰레드의 실행 - start()
쓰레드를 생성했다고 해서 자동으로 실행되는 것은 아니다. start()를 호출해야만 쓰레드가 실행된다.

### 3. start()와 run()
start()는 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택(call stack)을 생성한 다음에 run()을 호출해서, 생성된 호출스택 run()이 첫 번째로 올라가게 한다.
 모든 쓰레드는 독립적인 작업을 수행하기 위해 자신만의 호출스택을 필요로 하기 때문에, 새로운 쓰레드를 생성하고 실행시킬 때마다 새로운 호출스택이 생성되고 쓰레드가 종료되면 작업에 사용된 호출스택은 소멸된다.

 <div align="center">
 <img src="https://user-images.githubusercontent.com/97272787/221750545-92afc046-6fa4-427d-b7a5-1becb1d09648.png">
 </div>

#### main 쓰레드
main메서드의 작업을 수행하는 것도 쓰레드이며, 이를 main 쓰레드라 한다.
실행중인 쓰레드가 하나도 없을 때 프로그램은 종료된다.

### 5. 쓰레드의 우선순위
쓰레드는 우선순위(priority)라는 속성(멤버변수)를 가지고 있는데, 이 우선순위의 값에 따라 쓰레드가 얻는 실행 시간이 달라진다.
예를 들어, 파일전송기능이 있는 메시전의 경우, 파일다운로드를 처리하는 쓰레드보다 채팅내용을 전송하는 쓰레드의 우선순위가 더 높아야 사용자가 채팅하는데 불편함이 없을 것이다.

#### 쓰레드의 우선순위 지정하기
```java
void setPriority(int newPriority);
int getPriority();

public static final int MAX_PRIORITY = 10; // 최대우선순위
public static final int MIN_PRIORITY = 1; // 최소우선순위
public static final int NORM_PRIORITY = 5; // 보통우선순위
```
쓰레드가 가질 수 있는 우선순위의 범위는 1~10이며 숫자가 높을수록 우선순위가 높다.
쓰레드의 우선순위는 쓰레드를 생성한 쓰레드로부터 상속받는다는 것이다. main 메서드를 수행하는 쓰레드는 우선순위가 5이므로 main메서드 내에서 생성하는 쓰레드의 우선순위는 자동적으로 5가 된다.

### 6. 쓰레드 그룹
쓰레드 그룹은 서로 관련된 쓰레드를 그룹으로 다루기 위한 것으로, 폴더를 생성해서 관련된 파일들을 함께 넣어서 관리하는 것처럼 쓰레드 그룹을 생성해서 쓰레드를 그룹으로 묶어서 관리할 수 있다.
또한, 폴더 안에 폴더를 생성할 수 있듯이 쓰레드 그룹에 다른 쓰레드 그룹을 포함시킬 수 있다.
자신이 속한 쓰레드 그룹이나 하위 쓰레드 그룹을 변경할 수 있지만 다른 쓰레드 그룹의 쓰레드를 변경할 수는 없다.
ThreadGroup을 사용해서 생성할 수 있으며, 주요 생성자와 메서드는 다음과 같다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/222191289-cbd3ac11-cdd9-4900-935a-ec0de287cfd8.png">
</div>

쓰레드를 쓰레드 그룹에 포함시키려면 Thread의 생성자를 이용해야한다.
```java
Thread(ThreadGroup group, String name)
Thread(ThreadGroup group, Runnable target)
Thread(ThreadGroup group, Runnable target, String name)
Thread(ThreadGroup group, Runnable target, String name, long stackSize)
```
모든 쓰레드는 반드시 쓰레드 그룹에 포함되어 있어야 하기 때문에, 위와 같이 쓰레드 그룹을 지정하는 생성자를 사용하지 않은 쓰레드는 기본적으로 자신을 생성한 쓰레드와 같은 쓰레드 그룹에 속하게 된다.

### 7. 데몬 쓰레드(daemon thread)
데몬 쓰레드를 다른 일반 쓰레드(데몬 쓰레드가 아닌 쓰레드)의 작업을 돕는 보조적인 역할을 수행하게 되는 쓰레드이다.
일반 쓰레드가 모두 종료되면 데몬 쓰레드는 강제적으로 자동 종료되는데, 그 이유는 데몬 쓰레드가 일반 쓰레드의 보조역할을 수행하므로 일반 쓰레드가 모두 종료되고 나면 데몬 쓰레드의 존재의 의미가 없기 때문이다.
이 점을 제외하고는 데몬 쓰레드와 일반 쓰레드는 다르지 않다.데몬 쓰레드의 예로는 가비지 컬렉터, 워드프로세서의 자동저장, 화면자동갱신 등이 있다.

데몬 쓰레드는 무한루프와 조건문을 이용해서 실행 후 대기하고 있다가 특정 조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.
데몬 쓰레드는 일반 쓰레드의 작성방법과 실행방법이 같으며 다만 쓰레드를 생성한 다음 실행하기 전에 setDaemon(true)를 호출하기만 하면 된다. 그리고 데몬 쓰레드가 생성한 쓰레드는 자동적으로 데몬 쓰레드가 된다는 점도 알아두자.

```java
boolean isDaemon()
쓰레드가 데몬 쓰레드인지 확인한다. 데몬 쓰레드이면 true를 반환한다.

void setDaemon(boolean on)
쓰레드를 데몬 쓰레드 또는 사용자 쓰레드로 변경한다. 매개변수 on의 값을 true로 지정하면 데몬 쓰레드가 된다.

```

### 8. 쓰레드의 실행제어
쓰레드 프로그래밍이 어려운 이유는 동기화(synchronization)와 스케줄링(scheduling) 때문이다.
효율적인 멀티쓰레드 프로그램을 만들기 위해서는 보다 정교한 스케줄링을 통해 프로세스에게 주어진 자원과 시간을 여러 쓰레드가 낭비없이 잘 사용하도록 프로그래밍 해야 한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/222197937-c8af4660-c84a-462d-99dd-f8ca99302cb6.png">
</div>

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/222197975-4201829b-4121-422d-a7fa-e06e2e075c7c.png">
</div>

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/222198027-bc1d0c0d-be35-44a6-b9fd-4e5279be863f.png">
</div>

#### sleep(long mills) - 일정시간동안 쓰레드를 멈추게 한다.
```java
static void sleep(long mills)
static void sleep(long mills, int nanos)
```
sleep()에 의해 일시정지된 쓰레드는 지정된 시간이 다 되거나 interrupt()가 호출되면 잠에서 깨어나 실행 대기 상태가 된다. 그래서 sleep()을 호출할 때는 항상 try-catch문으로 예외를 처리해 줘야 한다.

#### interrupt()와 interrupted() - 쓰레드의 작업을 취소한다.
진행 중인 쓰레드의 작업이 끝나기 전에 취소시켜야 할 때가 있다. 예를 들어 큰 파일을 다운로드받을 때 시간이 너무 오래걸리면 중간에 다운로드를 포기하고 취소할 수 있어야 한다. interrupt()는 쓰레드에게 작업을 멈추라고 요청한다. 단지 멈추라고 요청만 하는 것일 뿐 쓰레드를 강제 종료시키지는 못한다. interrupt()는 그저 쓰레드의 interrupted상태(인스턴스 변수)를 바꾸는 것일 뿐이다.
그리고 interrupted()는 쓰레드에 대해 interrupt()가 호출되었는지 알려준다. interrupt()가 호출되지 않았다면 false를 interrupt()가 호출되었다면 true를 반환한다.

```java
void interrupt() - 쓰레드의 interrupted 상태를 false에서 true로 변경
boolean isInterrupted() - 쓰레드의 interrupted상태를 반환
static boolean isInterrupted() - 현재 쓰레드의 interrupted상태를 반환 후, false로 변경
```

#### suspend(), resume(), stop()
suspend는 sleep() 처럼 쓰레드를 멈추게 한다. suspend()에 의해 정지된 쓰레드는 resume()을 호출해야 다시 실행상태가 된다. stop()은 호출되는 즉시 쓰레드가 종료된다.

#### yield() - 다른 쓰레드에게 양보한다.
yield()는 쓰레드 자신에게 주어진 실행시간을 다음 쓰레드에게 양보(yield)한다.

#### join() - 다른 쓰레드의 작업을 기다린다.
쓰레드 자신이 하던 작업을 잠시 멈추고 다른 쓰레드가 지정된 시간동안 수행하도록 join()을 사용한다.
```java
void join()
void join(long millis)
void join(long millis, int nanos)
```

시간을 지정하지 않으면, 해당 쓰레드가 작업을 모두 마칠 때까지 기다리게 된다. 작업 중에 다른 쓰레드의 작업이 먼저 수행되어야할 필요가 있을 때 join()을 사용한다.
join()도 sleep()처럼 interrupt()에 의해 대기상태에서 벗어날 수 있으며, join()이 호출되는 부분을 try-catch문으로 감싸야 한다.