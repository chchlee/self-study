import java.util.concurrent.Semaphore;

class Calculator {
    private int memory;
    private final Semaphore semaphore = new Semaphore(1);

    public int getMemory() {
        return this.memory;
    }

    public void setMemory(int value) {
        while (true) {
            try {
                semaphore.acquire();
                if (this.memory == 0) {
                    this.memory = value;
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + ":" + this.memory);
                    semaphore.release();
                    break;
                }
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class User extends Thread {
    private Calculator calculator;
    int memory;

    public User(String name, int memory) {
        this.setName(name);
        this.memory = memory;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(this.memory);
    }
}

class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User user1 = new User("User1", 11);
        User user2 = new User("User2", 22);
        User user3 = new User("User3", 33);
        User user4 = new User("User4", 44);
        User user5 = new User("User5", 55);

        user1.setCalculator(calculator);
        user1.start();

        user2.setCalculator(calculator);
        user2.start();

        user3.setCalculator(calculator);
        user3.start();

        user4.setCalculator(calculator);
        user4.start();

        user5.setCalculator(calculator);
        user5.start();
    }
}
