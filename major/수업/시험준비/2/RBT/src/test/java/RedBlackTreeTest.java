import java.util.Set;
import java.util.TreeSet;


/**
 * RedBlackTree를 사용하는 TreeSet을 이용하였음.
 * 문제를 실수로 잘못읽고 아예 레드블랙트리를 구현해버렸습니다.
 */
public class RedBlackTreeTest {
    public static void main(String[] args) {
        System.out.println("2.1. 정수를 저장하는 해당 클래스의 인스턴스를 작성합니다.");
        RedBlackTree redBlackTree = new RedBlackTree();

        System.out.println("2.2. 객체에 30개의 무작위 정수를 추가합니다.");
        Set<Integer> set = new TreeSet<>();
        while (redBlackTree.size() < 30) {
            int num = (int) (Math.random() * 100 + 1);
            set.add(num);
            redBlackTree.insertNode(num);
        }

        System.out.println("\n2.3. 삽입된 무작위 정수들을 삽입 순서대로 출력합니다.");
        redBlackTree.printTree();

        System.out.println("\n2.4. 삽입된 무작위 정수들을 내림차순으로 정렬해서 출력합니다.");
        redBlackTree.printDescending();

        System.out.println("\n\n2.5.모든 노드들의 합");
        System.out.println(redBlackTree.sum());
    }
}
