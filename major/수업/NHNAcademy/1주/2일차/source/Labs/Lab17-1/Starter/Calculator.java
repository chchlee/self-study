class Calculator {
    private int memory;

    public int getMemory() {
        return this.memory;
    }

    public void setMemory(int value) { // synchronized 블럭을 사용해도 무방하다.ㅌ
        this.memory = value;
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ":" +this.memory);
        } catch(Exception e){
            e.printStackTrace();
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
    public void run(){
        calculator.setMemory(this.memory);
    }

}

class Test{
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

/**
 * User 1 , User 2 전부 50 이 나오는 이유
 * 공유 객체 생성 시 Interrupt가 걸리지 않았기 때문에
 * 공유객체를 user2가 간섭해 버렸기 때문이다.
 * 이 문제를 해결하기 위한 방법 중 가장 간단한 방법은 Synchronized 키워드를
 * 사용하는 것
 *
 */