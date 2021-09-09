package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.designpattern.strategy;

/**
 * @author sidharthdas on 09/09/21.
 */
public class MainClass {

    public static void main ( String[] args ) {

        Player p1 = new Player("Terrorist");
        Player p2 = new Player("Counter Terrorist");

        System.out.println("before bomb");
        p1.mode = new DefenssiveMode();
        p2.mode = new AgressiveMode();

        p1.action();
        p2.action();

        System.out.println("after bomb");
        p1.mode = new AgressiveMode();
        p2.mode = new DefenssiveMode();

        p1.action();
        p2.action();


    }
}
