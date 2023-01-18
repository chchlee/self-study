```java
public class WrapperEx1 {
    public static void main(String[] args) {
        Integer i  = new Integer(100);
        Integer i2 = new Integer(200);

        System.out.println("i==i2 ? "+(i==i2));
        System.out.println("i.equals(i2) ?"+i.equals(i2));
        System.out.println("i.compareTo(i2)="+i.compareTo(i2));
        System.out.println("i.toString()="+i.toString());
    }
}

```