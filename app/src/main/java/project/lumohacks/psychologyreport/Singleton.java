package project.lumohacks.psychologyreport;

public class Singleton {
    //Put the data that you want to share through the page

    private static volatile Singleton singleton = new Singleton();
    private Singleton() {
        //Initialize the data at first

    }

    //To get the data that we need (sharing through pages)
    public static Singleton getInstance() {
        return singleton;
    }
}
