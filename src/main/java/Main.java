public class Main {
    private static final int CARS = 10;
    public static final int PAUSE = 5000;
    public static int soldCars;

    public static void main(String[] args) {
        final Dealer dealer = new Dealer();
        while (soldCars < CARS) {
            Thread buyer1 = new Thread(null, dealer::sellCar, "Покупатель 1");
            Thread buyer2 = new Thread(null, dealer::sellCar, "Покупатель 2");
            Thread buyer3 = new Thread(null, dealer::sellCar, "Покупатель 3");
            buyer1.setDaemon(true);
            buyer1.start();
            buyer2.setDaemon(true);
            buyer2.start();
            buyer3.setDaemon(true);
            buyer3.start();
            new Thread(null, dealer::receiveCar, "Производитель").start();
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            soldCars++;
        }
    }
}

