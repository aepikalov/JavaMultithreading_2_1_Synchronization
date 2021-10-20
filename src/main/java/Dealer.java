import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private static final int RECIEVE_TIME = 3000;
    private static final int SELL_TIME = 1000;
    private List<Car> cars = new ArrayList<>();

    public synchronized void receiveCar() {
        try {
            Thread.sleep(RECIEVE_TIME);
            cars.add(new Car());
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто.");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон.");
            while (cars.size() == 0) {
                System.out.println("Машин нет!");
                wait();
            }
            Thread.sleep(SELL_TIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cars.remove(0);
    }
}
