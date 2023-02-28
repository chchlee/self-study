public class Test {
    public static void main(String[] args) {
        Thread task1 = new AThread();
        Thread task2 = new Thread(new BThread());



        // Runnable task2 = () -> {
        //     System.out.println("BThread");
        // }

        // Thread task2 = new Thread(task2);
        // 다음과 같이 lambda를 이용해서 간단한 쓰레드를 만들 수 있다.

        task1.start();
        task2.start();
    }
}

class AThread extends Thread {
    @Override
    public void run(){
        while(true){
            try{
                System.out.println("A Thread");
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class BThread implements Runnable {
    @Override
    public void run(){
        while(true){
            try{
                System.out.println("B Thread");
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
