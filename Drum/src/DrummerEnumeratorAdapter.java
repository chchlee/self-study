import java.util.Iterator;

public class DrummerEnumeratorAdapter implements Iterator<Drummer> {
    DrummerEnumerator enumerator; // 1. 기존에 호환해야 하는 타입의 참조변수를 선언한다.

    public DrummerEnumeratorAdapter(DrummerEnumerator enumerator) { // 생성자를 만든다.
        this.enumerator = enumerator;
    }

    @Override
    public boolean hasNext() { // 기존 부분과 겹치는 부분을 오버라이딩 하고, 참조변수에 대입하여 반환한다.
        return enumerator.hasMoreElements();
    }

    @Override
    public Drummer next() {
        return (Drummer) enumerator.current();
    }


}