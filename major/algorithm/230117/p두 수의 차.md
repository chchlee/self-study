```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;

        answer = num1 - num2;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution S = new Solution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        System.out.println(S.solution(num1,num2));
    }
}

```