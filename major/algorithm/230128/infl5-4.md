```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Integer> stack = new Stack<>();

        for(char x:s.toCharArray()){
            if(Character.isDigit(x)){
                stack.push(x-48);
            }else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(x=='+'){
                    stack.push(lt+rt);
                } else if (x=='-') {
                    stack.push(lt-rt);
                } else if (x=='*') {
                    stack.push(lt*rt);
                } else if (x=='/') {
                    stack.push(lt/rt);
                }
            }
        }

        System.out.println(stack.get(0));

    }
}
```