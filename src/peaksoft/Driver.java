package peaksoft;


import static peaksoft.Main.GSON;

public class Driver {
    private int id;
    private String name;
    public String trackName;
    public static Driver creatDriver ( int id,String name,String trackName){
        Driver driver=new Driver();
        driver.id=id;
        driver.name=name;
        driver.trackName=trackName;
        return driver;
    }
    public static void driverTab (String gson) {
        Driver[] drivers = GSON.fromJson(gson, Driver[].class);
        System.out.println("# | Driver  | Bus");
        System.out.println("--*---------*--------");
        for (Driver driver : drivers) {
            System.out.println(driver.id+" "+driver.name+" "+driver.trackName);
        }
    }

          public static void driverTab1(Driver[] drivers) {
            System.out.println("# | Driver  | Truck");
            System.out.println("--*---------*--------");
            for (Driver driver : drivers) {
                System.out.println(driver.id+"  "+driver.name+" "+driver.trackName);

            }

        }



            public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String infoDriving (){
        return " "+id+" "+name;
    }

    @Override
    public String toString() {
        return " ";
    }
}
