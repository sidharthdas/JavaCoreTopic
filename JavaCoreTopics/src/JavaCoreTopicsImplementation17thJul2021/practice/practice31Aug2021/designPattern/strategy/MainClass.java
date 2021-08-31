package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.designPattern.strategy;

/**
 * @author sidharthdas on 31/08/21.
 */
public class MainClass {

    public static void main ( String[] args ) {
        System.out.println("before");
        Player p1 = new Player();
        p1.playerType = "CounterStrike";
        p1.mode = new AggressiveMode();
        Player p2 = new Player();
        p2.playerType = "Terrorist";
        p2.mode = new CalmMode();

        p1.action();
        p2.action();
        System.out.println("after");
        p1.mode = new CalmMode();
        p2.mode = new AggressiveMode();

        p1.action();
        p2.action();
    }
}
