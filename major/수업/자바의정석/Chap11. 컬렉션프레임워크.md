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