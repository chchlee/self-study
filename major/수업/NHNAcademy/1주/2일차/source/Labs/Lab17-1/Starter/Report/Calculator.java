class Calculator {
    private int memory;
    private boolean isSet;

    public int getMemory() {
        return this.memory;
    }

    public void setMemory(int value) {
        while (isSet) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.memory = value;
        isSet = true;
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        isSet = false;
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
        User user1 = new User("User1", 100);
        User user2 = new User("User2", 50);

        user1.setCalculator(calculator);
        user1.start();

        user2.setCalculator(calculator);
        user2.start();
    }
}
