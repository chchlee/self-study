## 1. 컬렉션 프레임워크
### 1.1 컬렉션 프레임워크의 핵심 인터페이스
컬렉션 프레임워크에서는 컬렉션데이터 그룹을 크게 3가지 타입이 존재한다고 인식하고 각 컬렉션을 다루는데 필요한 기능을 가진 3개의 인터페이스를 정의하였다. 그리고 인터페이스 List와 Set의 공통된 부분을 다시 뽑아서 새로운 인터페이스인 Collection을 추가로 정의하였다.
<div align="center">
<img src="https://user-images.githubusercontent.com/63405904/144552104-6d0d4ba5-92c9-464a-8e14-3580a0972f6c.png">
</div>
인터페이스 List와 Set을 구현한 컬렉션 클래스들은 서로 많은 공통부분이 있어서, 공통된 부분을 다시 뽑아 Collection 인터페이스를 정의할 수 있었지만 Map인터페이스는 이들과는 전혀 다른 형태로 컬렉션을 다루기 떄문에 같은 상속계층도에 포함되지 못했다.


|인터페이스|특징|
|--|--|
|List|순서가 있는 데이터의 집합. 데이터의 중복을 허용한다. </br> 예)대기자 명단 </br> 구현클래스 : ArrayList, LinkedList, Stack, Vector|
|Set|순서를 유지하지 않는 데이터의 집합. 데이터의 중복을 허용하지 않는다. </br>양의 정수집합. 소수의 집합. </br> 구현클래스 : HashSet, TreeSet 등|
|Map|키(key)와 값(value)의 쌍(pari)로 이루어진 데이터의 집합 순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복은 허용한다. </br> 구현클래스 : HashMap, TreeMap, Hashtable, properties 등|

#### Collection 인터페이스
List와 Set의 조상인 Collection인터페이스에는 다음과 같은 메서드들이 정의되어 있다.
|메서드|설 명|
|--|--|
|boolean add(Object o) </br> boolean addAll(Collection c)|지정된 객체(o) 또는 Colleciton(c)의 객체들을 Collection에 추가한다.|
|void clear()|Collection의 모든 객체를 삭제한다.|
|boolean contains(Object o) </br> boolean containsAll(Collection c)|지정된 객체(o) 또는 Collection 객체들이 Collection에 포함되어 있는지 확인한다.|
|boolean equals(Object o)|동일한 Collection인지 확인한다.|
|int hashCode()|Collection의 hash code를 반환한다.|
|boolean isEmpty()|Collection이 비어있는지 확인한다.|
|Iterator iterator()|Collection의 iterator를 얻어서 반환한다.|
|boolean remove(Object o)|지정된 객체를 삭제한다.|
|boolean removeAll(Collection c)|지정된 Collection에 포함된 객체들을 삭제한다.|
|boolean retainAll(Colletion c)|지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다. 이 작업으로 인해 Collection에 변화가 있으면 true를 그렇지 않으면 false를 반환한다. 교집합이라 생각하자.|
|int size()|Collection에 저장된 객체의 개수를 반환한다.|
|Object[] toArray()|Collection에 저장된 객체를 객체배열(Object[])로 반환한다.|
|Object[] toArray(Object[] a)|지정된 배열에 Collection의 객체를 저장해서 반환한다.|

위의 표에서 반환 타입이 boolean인 메서드들은 작업이 성공하거나 사실이면 true를, 그렇지 않으면 false를 반환한다.
Iterator 인터페이스는 컬렉션에 포함된 객체들을 접근할 수 있는 방법을 제공한다.

#### List인터페이스
List인터페이스는 중복을 허용하면서 저장순서가 유지되는 컬렉션을 구현하는데 사용된다.
<div align="center">
<img src="https://velog.velcdn.com/images%2Foyeon%2Fpost%2F6a3b5891-8cb6-447d-a53d-3b943e03de2e%2Fimage.png">
<p>List의 상속 계층도</p>
</div>
List 인터페이스에 정의된 메서드는 다음과 같다.

|메서드|설명|
|--|--|
|void add(int index, Object element) </br> boolean addAll(int index, Collection c)|지정된 위치(index)에 객체(element) 또는 컬렉션이 포함된 객체들을 추가한다.|
|Object get(int index)|지정된 위치(index)에 있는 객체를 반환한다.|
|int indexOf(Object o)|지정된 객체의 위치(index)를 반환한다. </br> (List의 첫 번째 요소부터 순방향으로 찾는다.)|
|int lastIndexOf(Object o)|지정된 객체의 위치(index)를 반환한다. </br> (List의 마지막 요소부터 역방향으로 찾는다.)|
|ListIterator listIterator() </br> ListIterator(int index)|List의 객체에 접근할 수 있는 ListIterator를 반환한다.|
|Object remove(int index)|지정된 위치(index)에 객체(element)를 저장한다.|
|Object set(int index, Object element)|지정된 위치(index)에 있는 객체를 삭제하고 삭제된 객체를 반환한다.|
|void sort(Comparator c)|지정된 비교자(comparator)로 List를 정렬한다|
|List subList(int fromIndex, int toIndex)|지정된 범위(fromIndex부터 toIndex)에 있는 객체를 반환한다.|

#### Set인터페이스
Set인터페이스는 중복을 허용하지 않고 저장순서가 유지되지 않는 컬렉션 클래스를 구현하는데 사용된다. Set인터페이스를 구현한 클래스로는 HashSet, TreeSet 등이 있다.
<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/221416961-5743594d-2853-45ee-a7c3-957d8fb3c05d.png">
</div>

#### Map인터페이스
Map인터페이스는 키(key)와 값(value)을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현하는데 사용된다. 키는 중복될 수 없지만 값은 중복을 허용한다. 기존에 저장된 데이터와 중복된 키와 값을 저장하면 기존의 값은 없어지고 마지막에 저장된 값이 남게 된다.
<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/221417396-68195219-2fd8-4ad6-bb92-bfdc81947841.png">
</div>

|메서드|설 명|
|--|--|
|void clear()|Map의 모든 객체를 삭제한다.|
|boolean containsKey(Object key)|지정된 key객체와 일치하는 Map의 key객체가 있는지 확인한다.|
|boolean containsValue(Object value)|지정된 value 객체와 일치하는 Map의 value의 객체가 있는 지 확인한다.|
|Set entrySet()|Map에 저장되어 있는 key-value쌍을 Map.Entry타입의 객체로 저장한 Set으로 반환한다.|
|boolean equals(Object o)|동일한 Map인지 확익한다.|
|Object get(Object key)|지정한 key객체에 대응하는 value객체를 찾아서 반환한다.|
|int hashCode()|해쉬코드를 반환한다.|
|boolean isEmpty()|Map이 비어있는지 확인한다.|
|Set keySet()|Map에 저장된 모든 key객체를 반환한다.|
|Object put(Object key, Object value)|Map에 value 객체를 key 객체에 연결(mapping) 하여 저장한다.|
|void putAll(Map t)|지정된 Map의 모든 key-value쌍을 추가한다.|
|Object remove(Object key)|지정된 key객체와 일치하는 key-value객체를 삭제한다.|
|int size()|Map에 저장된 key-value쌍의 개수를 반환한다.|
|Collection values()|Map에 저장된 모든 value 객체를 반환한다.|


#### Map.Entry 인터페이스
Map.Entry인터페이스는 Map인터페이스의 내부 인터페이스이다. 내부 클래스와 같이 인터페이스도 인터페이스 안에 인터페이스를 정의하는 내부 인터페이스(inner interface)를 정의하는 것이 가능하다.

|메서드|설명|
|--|--|
|boolean equals(Object o)|동일한 Entry인지 비교한다.|
|Object getKey()|Entry의 key객체를 반환한다.|
|Object getValue()|Entry의 value객체를 반환한다.|
|int hashCode()|Entry의 hashCode를 반환한다.|
|Object setValue(Object value)|Entry의 value객체를 지정된 객체로 바꾼다.|

### 1.2 ArrayList
ArrayList는 기존의 Vector를 개선한 것으로 Vector와 구현원리와 기능적인 측면에서 동일하다고 할 수 있다.
ArrayList는 Object 배열을 이용해서 데이터를 순차적을 저장한다. 배열에 더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성해서 기존의 배열에 젖아된 내용을 새로운 배열로 복사한 다음에 저장된다.

|메서드|설명|
|--|--|
|void ensureCapacity(int minCapacity)|ArrayList의 용량이 최소한 minCapacity가 되도록 한다.|
|void trimToSize()|용량을 크기에 맞게 줄인다.(빈 공간을 없앤다.)|

### 1.3 LinkedList
배열은 가장 기본적인 형태의 자료구조로 구조가 간단하여 사용하기 쉽고 데이터를 읽어 오는데 걸리는 시간(접근시간, access time)이 가장 빠르다는 장점을 가지고 있지만 다음과 같은 단점도 가지고 있다.

1. 크기를 변경할 수 없다.
    - 크기를 변경할 수 없으므로 새로운 배열을 생성해서 데이터를 복사해야 한다.
    - 실행속도를 향상시키기 위해서는 충분히 큰 크기의 배열을 생성해야 하므로 메모리가 낭비된다.
2. 비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸린다.
    - 차례대로 데이터를 추가하고 마지막에서부터 데이터를 삭제하는 것은 빠르지만,
    - 배열의 중간에 데이터를 추가하려면, 빈자리를 만들기 위해 다른 데이터들을 복사해서 이동해야 한다.

이러한 배열의 단점을 보완하기 위해서 링크드 리스트(linked list)라는 자료구조가 고안 되었다. 배열은 모든 데이터가 연속적으로 데이터가 연속적으로 존재하지만 링크드 리스트는 불연속적으로 존재하는 데이터를 서로 연결(link)한 형태로 구성되어 있다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/221421516-4e35a143-79ab-4f1f-81ef-2ac9683f0a32.png">
</div>

```java
class Node{
    Node next; // 다음 요소의 주소를 저장
    Object obj; // 데이터를 저장
}
```

링크드 리스트에서의 데이터 삭제는 삭제하고자 하는 요소의 이전요소가 삭제하고자 하는 요소의 다음 요소를 참조하도록 변경하기만 하면 된다. 단 하나의 참조만 변경하면 삭제가 이루어지는 것이다. 배열처럼 데이터를 이동하기 위해 복사하는 과정이 없기 떄문에 처리속도가 매우 빠르다.
<div align="center"><img src="https://user-images.githubusercontent.com/97272787/221421617-55abbc29-d508-440b-816b-5ac175083209.png"></div>

새로운 데이터를 추가할 때는 새로운 요소를 생성한 다음 추가하고자 하는 위치의 이전 요소의 참조를 새로운 요소에 대한 참조로 변경해주고, 새로운 요소가 그 다음 요소를 참조하도록 변경하기만 하면 되므로 처리속도가 매우 빠르다.
<div align="center"><img src="https://user-images.githubusercontent.com/97272787/221421627-81acecc5-2ff7-4226-b4ba-c2339c58c1ab.png"></div>

|메서드|설명|
|--|--|
|Object element()|LinkedList의 첫 번째 요소로 반환|
|boolean offer(Object o)|지정된 객체(o)를 LinkedList의 끝에 추가. 성공하면 true, 실패하면 false|
|Object peek()|LinkedList의 첫 번째 요소를 반환|
|Object poll()|LinkedList의 첫 번째 요소를 반환. LinkedList에서는 제거된다.|
|Object remove()|LinkedList의 첫 번째 요소를 제거|

LinkedList는 Queue 인터페이스와 Deque인터페이스를 구현하도록 변경되었다.

### 1.4 Stack과 Queue
스택은 마지막에 저장한 데이터를 가장 먼저 꺼내게 되는 LIFO 구조
큐는 처음에 저장한 데이터를 가장 먼저 꺼내게 되는 FIFO 구조
<div align="center"><img src="https://user-images.githubusercontent.com/97272787/221422326-27dfda1e-b17a-449e-8940-8af33b802d76.png"></div>

순차적으로 데이터를 추가하고 삭제하는 스택에는 ArrayList와 같은 배열기반의 컬렉션 클래스가 적합하지만, 큐는 데이터를 꺼낼 때 항상 첫 번째 저장된 데이터를 삭제하므로, ArrayList와 같은 배열기반의 컬렉션 클래스를 사용한다면 데이터를 꺼낼 때마다 빈 공간을 채우기 위해 데이터의 복사가 발생하므로 비효율적이다. 그래서 큐는 ArrayList보다 데이터의 추가/삭제가 쉬운 LinkedList로 구현하는 것이 더 적합하다.

<p>Stack의 메서드</p>

|메서드|설명|
|--|--|
|boolean empty()|Stack이 비어있는지 알려준다.|
|Object peek()|Stack의 맨 위에 저장된 객체를 반환. pop()과 달리 Stack에서 객체를 꺼내지는 않음|
|Object pop()|Stack의 맨 위에 저장된 객체를 꺼낸다.|
|Object push()|Stack에서 객체(item)를 저장한다.|
|int search(Object o)|Stack에서 주어진 객체(o)를 찾아서 그 위치를 반환. 못찾으면 -1을 반환|

Queue의 메서드

|메서드|설명|
|--|--|
|boolean add(Object o)|지정된 객체를 Queue에 추가한다. 성공하면 true를 반환.|
|Object remove()|Queuedㅔ서 객체를 꺼내 반환.|
|Object element()|삭제없이 요소를 읽어온다.|
|boolean offer(Object o)|Queue에 객체를 저장. 성공하면 true. 실패하면 false반환|
|Object poll()|Queue에서 객체를 꺼내서 반환. 비어있으면 null을 반환|
|Object peek()|삭제없이 요소를 읽어온다. Queue가 비어있으면 null을 반환|

#### 스택과 큐의 활용
- 스택 : 수식계산, 수식괄호검사, 워드프로세서 undo/redo, 웹브라우저 뒤로/앞으로
- 큐 : 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)

#### PriorityQueue
저장한 순서에 관계 없이 우선순위(priority)가 높은 것부터 꺼내게 된다는 특징이 있다. 그리고 null은 저장할 수 없다. PriorityQueue는 저장공간으로 배열을 사용하며, 각 요소를 heap이라는 자료구조의 형태로 저장한다. 힙은 이진 트리의 한 종류로 가장 큰 값이나 가장 작은 값을 빠르게 찾을 수 있다는 장점이 있다.

#### Deque(Double-Ended Queue)
Deque(덱, 또는 디큐)는 양쪽 끝에 추가/삭제가 가능하다. Deque의 조상은 Queue이며, 구현체로는 ArrayDeque와 LinkedList 등이 있다.
Deque는 스택과 큐를 합쳐놓은 것과 같으며 스택으로 사용할 수도 있고, 큐로사용할 수도 있다.

|Deque|Queue|Stack|
|--|--|--|
|offerLast()|offer()|push()|
|pollLast()|-|pop()|
|pollFirst()|poll()|-|
|peekFirst()|peek()||
|peekLast()|-|peek()|

### 1.5 Iterator, ListIterator, Enumeration
Iterator, ListIterator, Enumeration은 모두 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스이다. Enumeration은 Iterator의 구버전이며, ListIterator는 Iterator의 기능을 향상 시킨 것이다.

#### Iterator
컬렉션 프레임워크에서는 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화하였다. 컬렉션에 저장된 각 요소에 접근하는 기능을 가진 Iterator 인터페이스를 정의하고, Colleciton 인터페이스에는 Iterator를 반환하는 iterator()를 정의하고 있다.

|메서드|설명|
|--|--|
|boolean hasNext()|읽어 올 요소가 있는지 확인한다. |
|Object next()|다음 요소를 읽어 온다. next()를 호출하기 전에 hasNext()를 호출해서 읽어 올 요소가 있는지 확인하는 것이 안전하다.|
|void remove()|next()로 읽어온 요소를 삭제한다. next()를 호출할 다음에 remove()를 호출해야 한다.(선택적 기능)|

Collection에 없고 ArrayList에만 있는 메서드를 사용하는 것이 아니라면, Collection 타입의 참조변수로 선언하는 것이 좋다. 만일 Colleciton 인터페이스를 구현한 다른 클래스, 예를 들어 LinkedList로 바꿔야 한다면 선언문 하나만 변경하면 나머지 코드를 검토하지 않아도 된다. 참조변수 타입이 Colleciton이므로 Collection에 정의되지 않은 메서드는 사용되지 않았을 것이 확실하기 때문이다. 그러나 참조변수 타입을 ArrayList로 했을경우, 선언문 이후 문장들을 검토해야 한다. Collection에 정의되지 않은 메서드를 호출했을 수 있기 때문이다.

Map인터페이스를 구현한 컬렉션 클래스는 키와 값을 쌍으로 저장하고 있기 때문에 iterator()를 직접 호출할 수 없고, 그 대신 keySet()이나 entrySet()과 같은 메서드를 통해서 키와 값을 각각 따로 Set의 형태로 얻어온 후에 다시 iterator()를 호출해야 Iterator를 얻을 수 있다.

```java
Map map = new HashMap();
...
Iterator it = map.entrySet().iterator();
```

<div align="center">
<img src = "https://user-images.githubusercontent.com/97272787/221426629-b0463e3d-5136-4234-a86d-79e3a3ca589c.png"> </div>

#### ListIterator와 Enumeration
ListIterator는 Iterator에 양방향 조회기능을 추가한 것(List를 구현한 경우에만 사용가능)
|메서드|설명|
|--|--|
|boolean hasPrevious()|읽어 올 이전 요소가 남아있는지 확인한다.|
|Object previous()|이전 요소를 읽어온다.|
|int previousIndex()|이전 요소의 index를 반환한다.|


### 1.6 Arrays
Arrays 클래스는 배열을 다루는데 유용한 클래스들이 정의되어 있다.

#### 배열의 복사 - copyOf(), copyOfRange()
copyOf는 배열 전체를, copyOfRange()는 배열의 일부를 복사해서 새로운 배열을 만들어서 반환한다.

#### 배열 채우기 - fill(), setAll()
fill()은 배열의 모든 요소를 지정된 값으로 채운다. setAll()은 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받는다. 이 메서드를 호출 할 때는 함수형 인터페이스를 구현한 객체로 매개변수로 지정하던가 아니면 람다식을 지정해야 한다.

```java
Arrays.setAll(arr, () -> (int) (Math.random() * 5) +1 );
```

#### 배열의 정렬과 검색 - sort(), binarySearch()
sort()는 배열을 정렬할 때, 그리고 배열에 저장된 요소를 검색할 경우는 binarySearch()를 사용한다. binarySearch()는 배열에서 저장된 값이 저장된 위치(index)를 찾아서 반환하는데, 반드시 배열이 정렬되어야만 올바른 결과를 얻는다.

#### 배열의 비교와 출력 - equals(), toString()
toString()은 배열의 모든 요소를 문자열로 편하게 출력할 수 있다.
deepToString()은 배열의 모든 요소를 재귀적으로 접근해서 다차원 배열 출력이 가능하게 한다.
eqauls()는 두 배열에 저장된 모든 요소를 비교해서 같으면 true, 다르면 false를 반환하게 한다.
다차원 배열에서는 deepEquals()를 사용하면 된다.

#### 배열을 List로 변환 - asList()
asList()는 배열을 List()로 담아서 반환한다.
한 가지 주의할 점은 asList()가 반환한 List()의 크기를 변경할 수 없다.

#### pararellXXX(), spliterator(), stream()
'pararell'로 시작하는 메서드들은 보다 빠른 결과를 얻기 위해 여러 쓰레드가 나누어 작업을 처리하도록 한다.
spliterator는 여러개의 쓰레드가 처리할 수 있게 하나의 작업을 여러 작업으로 나누는 Spliterator를 반환하며, stream은 컬렉션을 스트림으로 변환한다.

### 1.7 Comparator와 Comparable
Arrays.sort()를 하면 컴퓨터가 자동으로 정렬을 한 것 처럼 보이지만 사실은 Comparable() 구현에 의해서 정렬된 것이다.
Comparator과 Comparable은 모두 인터페이스로 컬렉션을 정렬하는데 필요한 메서드를 정의하고 있다.
Comparable 을 구현하고 있는 클래스들은 같은 타입의 인스턴스끼리 서로 비교하고 있는 클래스들을 오름차순으로 정렬할 수 있게 구현되어 있다.

- Comparable : 기본 정렬을 구현하는데 사용
- Comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용

### 1.8 HashSet
HashSet은 Set인터페이스를 구현한 대표적인 컬렉션이다.
HashSet에 새로운 요소를 추가할 때는 add나 addAll메서드를 사용한다.

### 1.9 TreeSet
TreeSet은 이진 검색 트리(binary Search Tree)라는 자료구조 형태로 데이터를 저장하는 컬렉션 클래스이다. 이진 검색 트리는 정렬, 검색, 범위 검색에 높은 성능을 보이는 자료구조 이며 TreeSet은 레드블랙트리로 구현되어 있다.
그리고 Set 인터페이스로 구현되어 있으므로 중복된 데이터의 저장을 허용하지 않으면서 정렬된 위치에 저장하므로 저장순서를 유지하지도 않는다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/221512063-6d4fa30b-ba58-4031-bdb4-e74a447ee703.png">
</div>

```java
class TreeNode{
    TreeNode left;
    Object element; // 객체를 저장하기 위한 참조변수
    TreeNode right;
}
```

부모노드 왼쪽에는 부모보다 작은 자식 노드, 오른쪽에는 부모보다 큰 자식 노드가 위치해 있다.

|메서드|설명|
|--|--|
|Object first()|정렬된 순서에서 첫 번째 순서를 반환한다.|
|Object last()|정렬된 순서에서 마지막 객체를 반환한다.|
|Object floor()|지정된 객체와 같은 객체를 반환. 없으면 작은 값을 가진 객체 중 제일 작은 값을 반환|
|Object higher(Object o)|지정된 객체보다 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환|
|SortedSet headSet(Object toElement)|지정된 값보다 작은 값의 객체들을 반환한다.|
|SortedSet tailSet(Object fromElement)|지정된 객체보다 큰 값의 객체들을 반환한다.|
|Sorted subSet(Object fromElement, Object toElement)|범위 검색의 결과를 반환|


### 1.10 HashMap과 Hashtable
Hashtable과 HashMap의 관계는 ArrayList와 Vector와 같아서 Hashtable보다 HashMap을 사용할 것을 권한다.

HashMap은 Entry라는 내부 클래스를 정의하고, 다시 Entry 타입의 배열을 선언하고 있다. 키(Key)와 값(Value)은 별개의 값이 아니라 서로 관련된 값이기 때문에 각각의 배열로 선언하기 보다 하나의 클래스로 정의해서 하나의 배열로 다루는 것이 데이터의 무결성(integrity)적인 측면에서 더 바람직하다.

|비객체지향적인 코드|객체지향적인 코드|
|--|--|
|Object[ ] key; </br> Object[ ] value;|Entry[ ] table; </br> class Entry { </br>   Object key; </br> Object value; </br>}|


|메서드|설명|
|--|--|
|boolean containsKey(Object key)|HashMap에 지정된 key가 있는지 알려준다.|
|boolean containsValue(Object value)|HashMap에 지정된 value가 포함되어 있는지 알려준다.|
|Set entrySet()|HashMap에 저장된 Key와 Value를 entry 형태로  Set에 저장하여 반환한다.|
|Object getOrDefault(Object key, Object defaultValue)|지정된 key의 값을 반환. 키를 못찾으면 defaultValue로 지정된 값을 반환.|


#### 해싱과 해시함수
해싱이란 해시함수를 이용해서 데이터를 해시 테이블에 저장하고 검색하는 기법을 말한다. 해시함수는 데이터가 저장되어 있는 곳을 알려주기 때문에 다량의 데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다.
해싱에서 사용하는 자료구조는 다음과 같이 배열과 링크드 리스트로 이루어져 있다.


<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/221518327-8df17377-edf8-4136-b688-8251803d2db0.png">
</div>

저장할 데이터의 키를 해시함수에 넣으면 배열의 한 요소를 얻게 되고, 다시 그 곳에 연결되어 있는 링크드 리스트에 저장하게 된다.

### 1.11 TreeMap
TreeMap은 이진검색트리 형태로 키와 값의 쌍으로 이루어진 데이터를 저장한다. 그래서 검색과 정렬에 적합한 컬렉션 클래스이다.

### 1.12 Properties
Properties는 HashMap의 구버전인 HashTable을 상속받아 구현한 것으로, HashTable은 키와 값을(Object, Object) 형태로 저장하는데 비해 Properties는 (String, String)의 형태로 저장하는 보다 단순화된 컬렉션 클래스이다.
주로 애플리케이션의 환경설정과 관련된 속성(property)을 저장하는데 사용되며, 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/221521030-0449057e-b65a-4e0f-b3ec-e4fa4bad0fb6.png">
</div>