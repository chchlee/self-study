```java
import java.util.ArrayList;
import java.util.Collections;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() { // 생성자
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object newEntry) { // add 메소드
        Node newNode = new Node(newEntry);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public void addAt(int newPosition, Object newEntry) { // addAt 메소드
        if (newPosition < 1 || newPosition > size + 1) {
            System.out.println("인덱스 오류");
            return;
        }

        Node newNode = new Node(newEntry);
        if (newPosition == 1) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else if (newPosition == size + 1) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            Node temp = head;
            for (int i = 1; i < newPosition - 1; i++) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            newNode.setPrev(temp);
            temp.getNext().setPrev(newNode);
            temp.setNext(newNode);
        }
        size++;
    }

    public void remove(int position) { // remove 메소드
        if (position < 1 || position > size) {
            System.out.println("인덱스 오류");
            return;
        }

        if (position == 1) {
            head = head.getNext();
            head.setPrev(null);
        } else if (position == size) {
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.getNext();
            }
            Node newNode = new Node(size);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            size++;
        }
    }

    public void clear(){ // clear메소드
        head = null;
        tail = null;
        size = 0;
    }

    public void replace(int position, Object newEntry) {
        if (position < 1 || position > size) {
            System.out.println("인덱스 오류");
            return;
        }

        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.getNext();
        }
        temp.setData(newEntry);
    }

    public Object getEntry() { // getEntry 메소드
        if (head == null) {
            System.out.println("리스트가 비어있습니다.");
            return null;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        return temp.getData();
    }

    public Object getEntry(int position) { // getEntry 메소드(인자 : 인덱스) 있음.
        if (position < 1 || position > size) {
            System.out.println("인덱스 오류");
            return null;
        }

        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.getNext();
        }

        return temp.getData();
    }

    public int size() {
        return size;
    }


    public void sort() { // 정렬 메소드
        Node temp = head;
        Object swapData;

        for (int i = 0; i < size - 1; i++) {
            while (temp.getNext() != null) {
                if ((int)temp.getData() > (int)temp.getNext().getData()) {
                    swapData = temp.getData();
                    temp.setData(temp.getNext().getData());
                    temp.getNext().setData(swapData);
                }
                temp = temp.getNext();
            }
            temp = head;
        }
    }

    public void print() { // 출력 메소드
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }

        //for each를 사용해도 무방함.
        System.out.println();
    }


}



```
