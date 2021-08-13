package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.designpattern.strategy;

/**
 * @author sidharthdas on 13/08/21.
 */
public class Player {

    Mode mode;
    String type;

    public Player ( String type ) {
        this.type = type;
    }


    public void action () {
        System.out.println("Player Type : " + type);
        mode.mode();
    }
}
