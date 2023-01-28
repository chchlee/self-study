```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        for(int i=1;i<=N;i++){
            queue.offer(i);
        }

        while (!queue.isEmpty()){
            for(int i=1;i<K;i++){
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size()==1)
                ans= queue.poll();
        }

        System.out.println(ans);


    }
}
```