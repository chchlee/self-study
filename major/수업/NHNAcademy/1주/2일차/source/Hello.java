public class Hello{
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Thread thread = Thread.currentThread(); // 현재 쓰레드를 thread 참조변수에
        System.out.println(thread.getName());  // thread의 이름
        System.out.println(thread.getPriority());// 현재 쓰레드의 우선 순위

    }
}