import java.util.*;

public class RedBlackTreeSetTest {
    public static void main(String[] args) {
        System.out.println("2.1. 정수를 저장하는 해당 클래스의 인스턴스를 작성합니다.");
        Set<Integer> set = new TreeSet<>();

        System.out.println("2.2. 객체에 30개의 무작위 정수를 추가합니다.");
        while (set.size() < 30) {
            int num = (int) (Math.random() * 100 + 1);
            set.add(num);
        }

        System.out.println("\n2.3. 삽입된 무작위 정수들을 삽입 순서대로 출력합니다.");
        for (int i : set) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println("\n2.3. 삽입된 무작위 정수들을 삽입 순서대로 출력합니다.");
        Iterator<Set<Integer>> iterator = Arrays.asList(set).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n2.4. 삽입된 무작위 정수들을 내림차순으로 정렬해서 출력합니다.");
        Set<Integer> treeReverse = new TreeSet<>(Collections.reverseOrder());
        treeReverse.addAll(set);


        for (int i : treeReverse) {
            System.out.print(i + " ");
        }


        System.out.println("\n\n2.5.모든 노드들의 합");
        int sum1=0;
        for(int i:set){
            sum1 += i;
        }
        System.out.print(sum1);

        System.out.println("\n\n2.5.모든 노드들의 합");
        int sum2 = set.stream().mapToInt(i -> i).sum();
        System.out.println(sum2);


    }
}
