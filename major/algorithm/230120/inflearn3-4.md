```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1=0, sum=0, cnt=0;

        for(int i=0;i<N;i++){
            sum += arr[i];
            if(sum == M){
                cnt++;
            }
            while (sum>=M){
                sum -= arr[p1++];
                if (sum == M){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);







    }
}```
