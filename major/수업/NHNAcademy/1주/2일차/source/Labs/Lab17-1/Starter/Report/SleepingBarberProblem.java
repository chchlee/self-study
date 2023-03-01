import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class BarberShop {
    private int numChairs;
    private Queue<Customer> queue;

    public BarberShop(int numChairs) {
        this.numChairs = numChairs;
        this.queue = new LinkedList<Customer>();
    }

    public void addCustomer(Customer customer) throws InterruptedException {
        synchronized (queue) {
            if (queue.size() < numChairs) {
                queue.add(customer);
                System.out.println(customer + "이 대기 중입니다. ");
                queue.notify();
            } else {
                System.out.println("이용할 의자가 없습니다. " + customer + "이 떠납니다. ");
            }
        }
    }

    public Customer getCustomer() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println("자는 중 zzz...");
                queue.wait();
            }
            Customer customer = queue.poll();
            System.out.println(customer + "의 머리를 정리하는 중... ");
            return customer;
        }
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Barber extends Thread {
    private BarberShop shop;

    public Barber(BarberShop shop) {
        this.shop = shop;
    }

    public void run() {
        try {
            while (true) {
                Customer customer = shop.getCustomer();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CustomerGenerator extends Thread {
    private BarberShop shop;
    private Random rand;

    public CustomerGenerator(BarberShop shop) {
        this.shop = shop;
        this.rand = new Random();
    }

    public void run() {
        try {
            int i = 1;
            while (true) {
                Thread.sleep(rand.nextInt(3000));
                Customer customer = new Customer("고객" + i);
                shop.addCustomer(customer);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Test {
    public static void main(String[] args) {
        BarberShop shop = new BarberShop(3);
        Barber barber = new Barber(shop);
        CustomerGenerator generator = new CustomerGenerator(shop);

        barber.start();
        generator.start();
    }
}
