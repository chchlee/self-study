```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        HashMap<Character, Integer> a = new HashMap<>();
        HashMap<Character, Integer> b = new HashMap<>();

        for(char x:first.toCharArray()){
            a.put(x,a.getOrDefault(x,0)+1);
        }

        for(char x:second.toCharArray()){
            b.put(x,b.getOrDefault(x,0)+1);
        }

        if(a.equals(b)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        


    }
}
```