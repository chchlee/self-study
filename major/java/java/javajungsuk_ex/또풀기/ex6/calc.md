```java
class Calc{
    private int left;
    private int right;
    private int third;

    public void setOp(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void setOp(int left, int right, int third) {
        this.left = left;
        this.right = right;
        this.third = third;
    }

    public void sum(){
        System.out.println(this.left+this.right);
    }

    public void avg(){
        System.out.println((this.left+this.right+this.third)/3);
    }
}

public class Main {
    public static void main(String[] args) {
        Calc c = new Calc();
        c.setOp(1,5);
        c.sum();
        c.avg();
        c.setOp(1,5,5);
        c.sum();
        c.avg();
    }
}
```