package peaksoft;

import java.util.Random;
import java.util.Scanner;

public class TruckService {
    static String driverName;
    static String truckName;
    static Scanner scanner = new Scanner(System.in);
    static Driver driver = new Driver();
    static Random random = new Random();

    public static void changeTrack(Truck[] trucks, Driver[] drivers, int id) {
        for (Truck truck : trucks) {
            if (truck.getDriver().getName() == null) {
                truck.getDriver().setName(" ");
            }
            driverName = truck.getDriver().getName();
            if (truck.getId() == id) {
                System.out.println("#  " + truck.getId());
                System.out.println("name  " + truck.getName());
                System.out.println("Driver:  " + driverName);
                if (truck.getStatus().equals(Status.BASE)) {
                    System.out.println("для выбора грузовика нажмите 1");
                    System.out.println("для отправки на ремонт нажмите 2");
                    System.out.println("для выбора водителя нажмите  3");
                    System.out.println();
                    int change = scanner.nextInt();
                    if (change == 1) {
                        randomDriver(drivers);
                        startDriving(truck.getName(), driverName);
                        truck.setDriver(driver);
                        truck.setStatus(Status.ROUTE);

                    }
                    if (change == 2) {
                        randomDriver(drivers);
                        truck.setStatus(Status.REPAIR);
                        truck.setDriver(driver);
                        startRepairing(truckName, driverName);

                    }
                    if (change == 3) {
                            changeDriver(drivers,truck.getName());
                            truck.setDriver(driver);
                            System.out.println("Хотитте отправить в путь? Нажмите на 1, если нет ,то 0");
                            int change2 = scanner.nextInt();
                            if (change2 == 1) {
                                truck.setStatus(Status.ROUTE);
                                startDriving(truck.getName(),driverName);
                            }
                            if (change2 == 0) {
                                truck.setStatus(Status.BASE);
                                System.out.println("on BASE");

                            }
                        }
                    }if (truck.getStatus().equals(Status.ROUTE)){
                    System.out.println("Мышина в пути");
                }
                if (truck.getStatus().equals(Status.REPAIR)){
                    System.out.println("Машина в ремонте");
                }
                }
            if (id> trucks.length){
                throw new RuntimeException("Выбирете из списка автобазы");
            }
            }
        }

        public static void startDriving (String truckName, String driverName){
            System.out.println("Truck" + truckName + " driver " + driverName);


        }
        public static void startRepairing (String truckName, String driverName){
            System.out.println("Truck" + truckName + " driver " + driverName);
        }
        public static void changeDriver (Driver[]drivers,String truckName){
            System.out.println("Выберите водителя");
            Driver.driverTab1(drivers);
            int sc = scanner.nextInt();
            for (Driver driver1 : drivers) {
                if (driver1.getId() == sc) {
                    driverName = driver1.getName();
                    driver1.setTrackName(truckName);
                    driver = driver1;
                }
            }
            Driver.driverTab1(drivers);
        }

        public static void randomDriver (Driver[]drivers){
            int d = random.nextInt(3) + 1;
            for (Driver driver1 : drivers) {
                if (driver1.getId() == d) {
                    driverName = driver1.getName();
                    driver = driver1;

                }


            }
        }

    }
