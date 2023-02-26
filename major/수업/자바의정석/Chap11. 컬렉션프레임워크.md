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
List인터페이스는 중복을 허용핮면서 저장순서가 유지되는 컬렉션을 구현하는데 사용된다.
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