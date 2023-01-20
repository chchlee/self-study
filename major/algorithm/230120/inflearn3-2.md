```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }

//        for(int i:arrN){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        for(int x:arrM){
//            System.out.print(x+" ");
//        }
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arrN);
        Arrays.sort(arrM);

        int p1=0, p2=0;

        while (p1<N && p2<M){
            if(arrN[p1] == arrM[p2]){
                list.add(arrN[p1++]);
                p2++;
            }else if (arrN[p1] < arrM[p2]){
                p1++;
            }else {
                p2++;
            }
        }

        for(int x:list){
            System.out.print(x+" ");
        }
    }
}
```